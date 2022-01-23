package article

class ArticleService {

    var articleList = mutableListOf<Article>()
    var lastArticleId = 0

    fun save(title: String, body: String, memberId:Int): Article{
        val article = Article(lastArticleId + 1, memberId, title, body)
        articleList.add(article)
        lastArticleId++
        return article
    }

    fun modify(articleId: Int, title: String, body: String): Article? {

        articleList.forEach {
            if(articleId == it.id){
                it.title = title
                it.body = body
                return it
            }
        }
        return null
    }

    fun delete(articleId: Int, memberId: Int): Int {
        memberCheck(articleId, memberId)

        articleList.forEach {
            if(articleId == it.id){
                articleList.remove(it)
                return it.id
            }
        }
        return 0
    }

    fun memberCheck(articleId: Int, memberId: Int) {
        articleList.forEach{
            if(articleId == it.id){
                if(it.memberId != memberId){
                    println("권한이 없습니다.")
                    return
                }
            }
        }
    }


}