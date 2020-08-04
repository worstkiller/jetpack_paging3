# Jetpack Paging3
Android sample code for new Jetpack Paging3 Library
Paging3 is one of the new Jetpack libraries for managing and loading a large chunk of the dataset from various data sources efficiently. It allows us to load pages of data from the network or local database with ease and saves our development time.

### Features:
- It caches the paged data in-memory for better usage of the system resources which not only gives fast response but also helps in data loading without hiccups.
- It handles the network request duplication very elegantly hence saving the user's bandwidth and system resources.
- A much flexible Recyclerview Adapter which requests & loads the data gracefully whenever the user reaches near the end of the page, yes now adapter is controlling when and what to load with one-time setup.
- It is Kotlin first means the whole library is written in Kotlin and works very well with other offerings of the Kotlin like Coroutines and Flow. Also, it supports the much-used libraries like RxJava and LiveData as well.
- It has inbuilt support for error handling, retry and refresh use cases.

### About the App:
```
This repository is all about Paging3 implementation for various use cases like 
- Paging using network as data source
- Paging using network and local db room.
- Showing footer error view or loading states.
```
### Screenshot
![Room DB loading](https://github.com/worstkiller/jetpack_paging3/blob/master/screenshots/room_paging3.gif)


#### Feel free to fork or pull and play with the new Paging3.

Let's connect or reach out for suggestions or improvements.

Social | Profile 
--- | --- |
*Twitter* | [`@vikaskum09`](https://twitter.com/vikaskum09) 
*LinkedIn* | [`@vikaskumar09`](https://www.linkedin.com/in/vikaskumar09/)
