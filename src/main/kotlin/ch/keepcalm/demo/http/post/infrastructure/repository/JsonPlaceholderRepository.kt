package ch.keepcalm.demo.http.post.infrastructure.repository

import ch.keepcalm.demo.http.post.model.Post
import org.springframework.web.service.annotation.GetExchange

interface JsonPlaceholderRepository {
    // https://jsonplaceholder.typicode.com/posts
    @GetExchange("/posts")
    fun findAll(): List<Post>

}
