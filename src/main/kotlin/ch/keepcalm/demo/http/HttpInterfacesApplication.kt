package ch.keepcalm.demo.http

import ch.keepcalm.demo.http.post.infrastructure.repository.JsonPlaceholderRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.beans
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory
import org.springframework.web.service.invoker.createClient

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
