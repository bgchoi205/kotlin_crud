package member

class MemberController {

    fun save(memberService:MemberService){
        println("==회원 정보 입력==")
        print("아이디 입력 : ")
        var loginId = readLine()?.trim()?:"no data"
        print("이름 입력 : ")
        var name = readLine()?.trim()?:"no data"
        print("닉네임 입력 : ")
        var nickname = readLine()?.trim()?:"no data"

        var newMember = memberService.save(loginId, name, nickname)

        println("== new Member!! ==")
        println("id : ${newMember.id}")
        println("loginId : ${newMember.loginId}")
        println("name : ${newMember.name}")
    }

    fun list(memberService: MemberService){
        println("==회원목록==")

        val members = memberService.memberList

        members.forEach{
            println("회원번호 : " + it.id)
            println("아이디 : " + it.loginId)
            println("이름 : " + it.name)
            println("닉네임 : " + it.nickname)
            println("----------------")
        }
    }

    fun modify(memberService: MemberService, loginId: String){
        println("==========")
        println("수정할 이름 : ")
        val nickname = readLine()?.trim()?:"no data"

        val member = memberService.modify(nickname, loginId);

        if(member == null){
            println("존재하지 않는 회원입니다.")
            return
        }

        println("==수정된 회원 정보==")
        println("아이디 : " + member.loginId)
        println("이름 : " + member.name)
        println("닉네임 : " + member.nickname)
    }
}