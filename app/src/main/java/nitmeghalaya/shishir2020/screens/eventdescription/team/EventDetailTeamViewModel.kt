package nitmeghalaya.shishir2020.screens.eventdescription.team

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.toObject
import nitmeghalaya.shishir2020.model.ShishirTeam
import nitmeghalaya.shishir2020.model.TeamMember
import nitmeghalaya.shishir2020.repository.FirestoreRepository

class EventDetailTeamViewModel(private val firestoreRepository: FirestoreRepository): ViewModel() {

    fun getTeamMembersList(teamName: String): LiveData<ArrayList<TeamMember>> {
        val teamMembersLiveData = MutableLiveData<ArrayList<TeamMember>>()

        firestoreRepository.getTeamMembers(teamName).addOnSuccessListener {
            val shishirTeam = it.toObject<ShishirTeam>()

            val teamMembers = arrayListOf<TeamMember>()

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

                teamMembers.apply {
                    addAll(coordinators)
                    addAll(cocoordinators)
                    addAll(members)
                }
            }

            teamMembersLiveData.value = teamMembers
        }

        return teamMembersLiveData
    }
}