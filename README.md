# http-interfaces
https://www.youtube.com/watch?v=AOJzm7yFOl0


````

@SpringBootApplication
class HttpInterfacesApplication

fun main(args: Array<String>) {
    runApplication<HttpInterfacesApplication>(*args) {
        addInitializers(
            beans {
                bean("jsonPlaceholderRegository") {
                    createJsonPlaceholderRepository()
                }
                bean {
                    ApplicationRunner {
                        println("ApplicationRunner ----------------->")
                        println("-----------------> Find All Posts <-----------------")
                        ref<JsonPlaceholderRepository>().findAllPosts().forEach(::println)
                        println("-----------------> Find All Comments <-----------------")
                        ref<JsonPlaceholderRepository>().findAllComments(postId = "2").forEach(::println)
                        println("-----------------> Find One Comment <-----------------")
                        println(ref<JsonPlaceholderRepository>().findOneComment("1"))
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
