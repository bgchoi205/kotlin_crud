package member

data class Member(
    val id : Int,
    val loginId : String,
    val loginPw: String,
    val name : String,
    var nickname: String
)
