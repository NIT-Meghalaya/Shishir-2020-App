package nitmeghalaya.shishir2020.model

data class ShishirEvent(
    val name: String = "",
    val description: String = "",
    val rules: String = "",
    val judging: String = "",
    val teamMembers: List<TeamMember> = listOf(),
    val imageResId: Int = 0
)