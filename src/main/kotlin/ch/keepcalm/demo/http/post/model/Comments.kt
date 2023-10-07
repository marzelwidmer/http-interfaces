package ch.keepcalm.demo.http.post.model

data class Comments(
    val body: String = "",
    val email: String = "",
    val id: Int = 0,
    val name: String = "",
    val postId: Int = 0
)
