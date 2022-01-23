package article

class ArticleController {

    fun save(articleService: ArticleService, memberId: Int){
        print("제목 입력 : ")
        val title = readLine()?.trim()?:"no data"
        print("내용 입력 : ")
        val body = readLine()?.trim()?:"no data"

        val newArticle = articleService.save(title, body, memberId)

        println("==새 게시물!!==")
        println("제목 : " + newArticle.title)
        println("내용 : " + newArticle.body)
        println("작성자 : " + newArticle.memberId)
    }

    fun list(articleService: ArticleService){
        val articles = articleService.articleList
        println("==게시물 리스트==")
        articles.forEach{
            println("번호 : " + it.id)
            println("제목 : " + it.title)
            println("내용 : " + it.body)
            println("작성자 : " + it.memberId)
            println("------------------------")
        }
    }

    fun modify(articleService: ArticleService, memberId: Int){
        print("수정할 게시물 번호 : ")
        val articleId = readLine()?.trim()?.toInt()?:0
        articleService.memberCheck(articleId, memberId)

        print("수정할 제목 입력 : ")
        val title = readLine()?.trim()?:"nothing"
        print("수정할 내용 입력 : ")
        val body = readLine()?.trim()?:"nothing"

        val modifiedArticle = articleService.modify(articleId, title, body)

        if(modifiedArticle != null){
            println("==수정된 게시물!!==")
            println("번호 : " + modifiedArticle.id)
            println("제목 : " + modifiedArticle.title)
            println("내용 : " + modifiedArticle.body)
            println("작성자 : " + modifiedArticle.memberId)
            return
        }

        println("존재하지 않는 게시물 번호입니다.")
    }

    fun delete(articleService: ArticleService, memberId: Int) {
        print("삭제할 게시물 번호 : ")
        val articleId = readLine()?.trim()?.toInt()?:0
        val delArticleId = articleService.delete(articleId, memberId)

        if(delArticleId == 0){
            println("존재하지 않는 게시물입니다.")
            return
        }
        println("$delArticleId 번 게시물 삭제 완료")
    }
}