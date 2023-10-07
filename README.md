# http-interfaces
https://www.youtube.com/watch?v=AOJzm7yFOl0


````
SpringBootApplication
class HttpInterfacesApplication

fun main(args: Array<String>) {
    runApplication<HttpInterfacesApplication>(*args) {
        addInitializers(
            beans {
                bean("jsonPlaceholderRepository") {
                    createJsonPlaceholderRepository()
                }
                bean {
                    ApplicationRunner {
                        println("ApplicationRunner ----------------->")
                        ref<JsonPlaceholderRepository>().findAll().forEach(::println)
                    }
                }
            }
        )
    }
}

fun createJsonPlaceholderRepository(): JsonPlaceholderRepository {
    val client = WebClient.builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .build()
    val factory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build()
    return factory.createClient()
}
````
