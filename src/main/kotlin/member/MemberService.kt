package member

class MemberService {

    var memberId = 0
    var memberList = mutableListOf<Member>()

    fun printTest(a : Int, b : Int){
        println("printTest : " + (a + b))
    }

    fun save(loginId: String, loginPw: String, name: String, nickname: String): Member?{

        memberList.forEach{
            if(it.loginId == loginId){
                println("이미 존재하는 아이디입니다.")
                return null
            }
            if(it.nickname == nickname){
                println("이미 존재하는 닉네임입니다.")
                return null
            }
        }

        val member = Member(memberId + 1, loginId, loginPw, name, nickname)
        memberList.add(member)
        memberId++

        return member
    }

    fun modify(nickname: String, loginId: String): Member? {

        memberList.forEach{
            if(it.nickname == nickname) {
                println("이미 사용중인 닉네임입니다.")
                return null
            }
        }

        memberList.forEach {
            if(it.loginId == loginId) {
                it.nickname = nickname
                return it
            }
        }
        return null
    }

    fun login(loginId: String, loginPw: String): Member? {

        memberList.forEach {
            if(it.loginId == loginId && it.loginPw == loginPw) return it
        }

        return null
    }
}