package com.faustinodegroot.sportunity.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.faustinodegroot.sportunity.R
import com.faustinodegroot.sportunity.databinding.FragmentEventListBinding
import com.faustinodegroot.sportunity.domain.model.Event
import com.faustinodegroot.sportunity.adapter.EventListAdapter
import com.faustinodegroot.sportunity.adapter.LoadingStateAdapter
import com.faustinodegroot.sportunity.viewmodel.EventListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * A fragment representing a list of Items.
 */
@AndroidEntryPoint
class EventListFragment : Fragment(), EventListAdapter.OnEventClickedListener {

    private lateinit var viewModel: EventListViewModel
    private lateinit var binding: FragmentEventListBinding
    private lateinit var eventListAdapter: EventListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentEventListBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this)[EventListViewModel::class.java]

        eventListAdapter = EventListAdapter(this)

        with(binding) {
            with(eventListAdapter) {

                recyclerview.adapter = eventListAdapter.withLoadStateHeaderAndFooter(
                    header = LoadingStateAdapter(this),
                    footer = LoadingStateAdapter(this)
                )
                recyclerview.layoutManager = LinearLayoutManager(context)

                swiperefresh.setOnRefreshListener {
                    eventListAdapter.refresh()
                }
                with(viewModel) {
                    // Observe events and update adapter
                    eventsList.observe(viewLifecycleOwner) {
                        eventListAdapter.submitData(viewLifecycleOwner.lifecycle, it)
                    }

                    lifecycleScope.launch {
                        loadStateFlow.collectLatest {
                            swiperefresh.isRefreshing = it.refresh is LoadState.Loading
                        }
                    }
                }

            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.list_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.menu_refresh -> {
                        eventListAdapter.refresh()
                    }
                }
                return true
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    override fun onEventClicked(event: Event) {
        val eventId = event.id
        val raceId = event.races.first().id
        val action = EventListFragmentDirections.actionEventListFragmentToEventDetailFragment(
            eventId,
            raceId,
            event.name
        )
        findNavController().navigate(action)
    }

}
