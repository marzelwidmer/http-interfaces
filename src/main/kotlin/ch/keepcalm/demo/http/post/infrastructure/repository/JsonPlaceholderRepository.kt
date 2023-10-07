package ch.keepcalm.demo.http.post.infrastructure.repository

import ch.keepcalm.demo.http.post.model.Comments
import ch.keepcalm.demo.http.post.model.Post
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange


interface JsonPlaceholderRepository {
    // https://jsonplaceholder.typicode.com/posts
    @GetExchange("/posts")
    fun findAllPosts(): List<Post>

    @GetExchange("/comments/{commentId}")
    fun findOneComment(@PathVariable commentId: String): Comments

    // https://jsonplaceholder.typicode.com/comments?postId=1
    @GetExchange("/comments")
    fun findAllComments(@RequestParam postId: String): List<Comments>

}
