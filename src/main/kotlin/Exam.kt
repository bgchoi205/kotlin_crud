import article.Article
import article.ArticleController
import article.ArticleService
import member.Member
import member.MemberController
import member.MemberService
import java.lang.invoke.MethodHandles.loop

class Exam {

}

fun main(args : Array<String>){

    val memberController = MemberController()
    val articleController = ArticleController()

    val memberService = MemberService()
    val articleService = ArticleService()

    var logonMember: Member? = null

    while(true){


        println("===================")
        print("명령 입력 : ")
        var cmd = readLine()?.trim()?:""

        if(cmd == "out"){
            break
        }else if(cmd == "login"){
            print("아이디 입력 : ")
            val loginId = readLine()?.trim()?:"nothing"
            print("비밀번호 입력 : ")
            val loginPw = readLine()?.trim()?:"nothing"
            val member = memberService.login(loginId, loginPw)
            if(member == null){
                println("존재하지 않는 회원입니다.")
                continue
            }
            logonMember = member

            println(logonMember.loginId + " 님 환영합니다.")
        }else if(cmd == "logout"){
            logonMember = null
            println("로그아웃")
            println("--------------")
        }else if(cmd == "/member/save"){
            memberController.save(memberService)
        }else if(cmd == "/member/list"){
            if(!loginCheck(logonMember)) {
                println("로그인 후 이용해주세요.")
                continue
            }
            memberController.list(memberService)
        }else if(cmd == "/member/modify"){
            if (logonMember == null) {
                println("로그인 후 이용해주세요")
                continue
            }
            memberController.modify(memberService, logonMember.loginId)
        }else if(cmd == "/article/save"){
            if (logonMember == null) {
                println("로그인 후 이용해주세요.")
                continue
            }
            articleController.save(articleService, logonMember.id)
        }else if(cmd == "/article/list"){
            articleController.list(articleService)
        }else if(cmd == "/article/modify"){
            if (logonMember == null) {
                println("로그인 후 이용해주세요.")
                continue
            }
            articleController.modify(articleService, logonMember.id)
        }else if(cmd == "/article/delete"){
            if (logonMember == null) {
                println("로그인 후 이용해주세요.")
                continue
            }
            articleController.delete(articleService, logonMember.id)
        }


    }


}

fun loginCheck(logonMember: Member?): Boolean{
    if(logonMember == null){
        return false
    }
    return true
}