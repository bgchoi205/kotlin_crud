package member

class MemberService {

    var memberId = 0
    var memberList = mutableListOf<Member>()

    fun printTest(a : Int, b : Int){
        println("printTest : " + (a + b))
    }

    fun save(loginId: String, name: String, nickname: String): Member{

        val member = Member(memberId + 1, loginId, name, nickname)
        memberList.add(member)
        memberId++

        return member
    }

    fun modify(nickname: String, loginId: String): Member? {
        memberList.forEach {
            if(it.loginId == loginId) {
                it.nickname = nickname
                return it
            }
        }
        return null
    }

    fun login(loginId: String): Member? {

        memberList.forEach {
            if(it.loginId == loginId) return it
        }

        return null
    }
}