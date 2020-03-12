package nitmeghalaya.shishir2020.screens.teammembers

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import nitmeghalaya.shishir2020.model.ShishirTeam
import nitmeghalaya.shishir2020.model.TeamMember

class TeamMembersViewModel : ViewModel() {

    private var shishirTeam: ShishirTeam? = null

    fun getTeamMembersList(teamJson: String): ArrayList<TeamMember> {
        val teamMembers = arrayListOf<TeamMember>()

        if (shishirTeam == null) {
            shishirTeam = getShishirTeamFromJson(teamJson)
        }

        shishirTeam?.apply {
            coordinators.forEach {
                it.position = "Coordinator"
            }

            cocoordinators.forEach {
                it.position = "Co-coordinator"
            }

            members.forEach {
                it.position = "Member"
            }

            generalsecretary.forEach {
                it.position = "General Secretary"
            }

            teamMembers.apply {
                addAll(generalsecretary)
                addAll(coordinators)
                addAll(cocoordinators)
                addAll(members)
            }
        }

        return teamMembers
    }

    fun getTeamName(teamJson: String): String {
        if (shishirTeam == null) {
            shishirTeam = Gson().fromJson(teamJson, ShishirTeam::class.java)
        }

        return shishirTeam?.team ?: ""
    }

    private fun getShishirTeamFromJson(teamJson: String) =
        Gson().fromJson(teamJson, ShishirTeam::class.java)
}