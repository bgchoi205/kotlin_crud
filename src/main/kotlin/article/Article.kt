package article

data class Article(
    val id: Int,
    val memberId: Int,
    var title: String,
    var body: String
)