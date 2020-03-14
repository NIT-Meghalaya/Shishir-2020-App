package nitmeghalaya.shishir2020.screens.teams
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.toObjects
import nitmeghalaya.shishir2020.model.ShishirTeam
import nitmeghalaya.shishir2020.repository.FirestoreRepository

/**
 * Created by Devansh on 6/3/20
 */

class TeamListViewModel(private val firestoreRepository: FirestoreRepository): ViewModel() {

    fun getTeams(): LiveData<List<ShishirTeam>> {
        val teamsLiveData = MutableLiveData<List<ShishirTeam>>()

        firestoreRepository.getTeams().addOnSuccessListener {
            teamsLiveData.value = it.toObjects()
        }.addOnFailureListener {
            Log.e("Teams", "Error: $it")
        }

        return teamsLiveData
    }
}