# Sportunity Android Assessment
![Static Badge](https://img.shields.io/badge/kotlin-1.9.20-blue)
![Static Badge](https://img.shields.io/badge/minsdk-24-blue)

## Features
- Retrieve list of events using Paging3
- View race details using Google Maps SDK

## Architecture
![Architecture](architecture.png)
* View which consists of a Single Activity and multiple Fragments, handles all UI components
* ViewModel holds the business logic which contains an use case
* Use Case is used to communicate with the repository so that Use Case methods can be used in other VMs
* Repository handles data received from the server. Currently no local DB is used but can be implemented here to add and retrieve data using Dao
  *  PagingDataSource is used to paginate network request.

### Design patterns used
- Dependency Injection Pattern
- Generic Repository Pattern
- Singleton Pattern
- Use Case Pattern


## Libraries & Plugins
- [Coil](https://coil-kt.github.io/coil/) - Image Loader with memory caching
- [Dagger Hilt](https://dagger.dev/hilt/) -  Dependency injection
- [Detekt](https://github.com/detekt/detekt) - Static code analysis
- [Gradle Version Catalog](https://docs.gradle.org/8.1/userguide/platforms.html) - Gradle version catalog
- [Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
- [Retrofit2](https://square.github.io/retrofit/) using Gson Converter

## Possible Improvements
- Implement Viewpager to swipe between races
- Fix empty states
