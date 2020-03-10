package nitmeghalaya.shishir2020.model

import com.google.firebase.firestore.PropertyName

class ShishirTeam(

    val cocoordinators: ArrayList<TeamMember> = arrayListOf(),

    val coordinators: ArrayList<TeamMember> = arrayListOf(),

    val members: ArrayList<TeamMember> = arrayListOf(),


    val generalsecretary: ArrayList<TeamMember> = arrayListOf(),

    val team: String = "",

    val image: String = ""
)