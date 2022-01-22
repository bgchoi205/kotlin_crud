import member.Member
import member.MemberController
import member.MemberService
import java.lang.invoke.MethodHandles.loop

class Exam {

}

fun main(args : Array<String>){

    val memberController = MemberController()

    val memberService = MemberService()

    var logonMember: Member? = null

    while(true){


        println("===================")
        print("명령 입력 : ")
        var cmd = readLine()?.trim()?:""

        if(cmd == "out"){
            break
        }else if(cmd == "test"){
            val nums = arrayListOf<Int>(1,2,3,4,5,6)

            run{
                nums.forEach {
                    if(it == 3) return@run

                    println(it)

                }
            }

        }else if(cmd == "login"){
            print("아이디 입력 : ")
            val loginId = readLine()?.trim()?:"nothing"
            val member = memberService.login(loginId)
            if(member == null){
                println("존재하지 않는 회원입니다.")
                return
            }
            logonMember = member

            println(logonMember!!.loginId + " 님 환영합니다.")
        }else if(cmd == "save"){
            memberController.save(memberService)
        }else if(cmd == "list"){
            if(!loginCheck(logonMember!!)) return
            memberController.list(memberService)
        }else if(cmd == "modify"){
            if(!loginCheck(logonMember!!)) return
            memberController.modify(memberService, logonMember.loginId)
        }


    }


}

fun loginCheck(logonMember: Member): Boolean{
    if(logonMember == null){
        return false
    }
    return true
}