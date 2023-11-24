package com.faustinodegroot.sportunity.ui.fragment

import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.faustinodegroot.sportunity.R
import com.faustinodegroot.sportunity.databinding.FragmentRaceDetailBinding
import com.faustinodegroot.sportunity.domain.model.Race
import com.faustinodegroot.sportunity.util.Utils
import com.faustinodegroot.sportunity.viewmodel.RaceDetailViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RaceDetailFragment : Fragment(), OnMapReadyCallback {

    private lateinit var eventName: String
    private var eventId = -1
    private var raceId = -1

    private lateinit var viewModel: RaceDetailViewModel
    private lateinit var binding: FragmentRaceDetailBinding
    private lateinit var googleMap: GoogleMap
    private lateinit var mapView: MapView
    private var coordinates: List<List<Double>> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            eventName = RaceDetailFragmentArgs.fromBundle(it).eventName
            eventId = RaceDetailFragmentArgs.fromBundle(it).eventId
            raceId = RaceDetailFragmentArgs.fromBundle(it).raceId
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentRaceDetailBinding.inflate(inflater, container, false)
        mapView = binding.mapView
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)

        viewModel = ViewModelProvider(this)[RaceDetailViewModel::class.java]

        viewModel.raceLiveData.observe(viewLifecycleOwner) { race ->
            race?.let {
                inflateRace(race)
            }
        }

        binding.raceCard.setOnClickListener {
            val visibility = if (binding.expandedView.visibility == View.VISIBLE) View.GONE else View.VISIBLE
            TransitionManager.beginDelayedTransition(binding.raceCard, AutoTransition())
            binding.expandedView.visibility = visibility
        }

        return binding.root

    }

    private fun inflateRace(race: Race) {
        binding.eventName.text = eventName
        binding.raceName.text = race.name
        binding.raceDistance.text = race.distance?.let { Utils.formatDistance(it) }
        binding.startTime.text = race.start?.let { Utils.formatDate(it) }
        binding.participants.text = "${race.participantCount} participants"
        coordinates = race.route.features.first().geometry.coordinates
        updateMap()
    }

    override fun onMapReady(maps: GoogleMap) {
        googleMap = maps
        coordinates.takeIf { it.isNotEmpty() }?.let { updateMap() }

    }

    private fun updateMap() {
        val polylineOptions = PolylineOptions()
        val eventLocation = Utils.createLatLng(coordinates.first())

        coordinates.forEachIndexed { index, coordinate ->
            if (index == 0 || coordinates.size - 1 == index) {
                googleMap.addMarker(
                    MarkerOptions()
                        .position(Utils.createLatLng(coordinate))
                        .title(if (index == 0) getString(R.string.marker_start) else getString(R.string.marker_end))
                )
            }
            polylineOptions.add(Utils.createLatLng(coordinate))
        }

        googleMap.addPolyline(polylineOptions)

        val location = CameraUpdateFactory.newLatLngZoom(eventLocation, 10f)
        googleMap.animateCamera(location)
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

}
