package nitmeghalaya.shishir2020.model

data class ShishirEvent(
    val name: String = "",
    val description: String = "",
    val rules: String = "",
    val image: String ="",
    val registrationLink: String ="",
    val about:String="",
    val judging: String = "",
    val team: String = "",
    val teamMembers: List<TeamMember> = listOf(),
    val imageResId: Int = 0
){
    companion object{
        const val DESCRIPTION = "Description"
        const val RULES="Rules"
        const val TEAM="Team"
        const val JUDGING="Judging"
    }
}