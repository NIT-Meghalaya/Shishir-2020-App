package nitmeghalaya.shishir2020.screens.eventslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.toObjects
import nitmeghalaya.shishir2020.model.ShishirEvent
import nitmeghalaya.shishir2020.repository.FirestoreRepository
import timber.log.Timber

/**
 * Created by Devansh on 5/3/20
 */

class EventsListViewModel(private val firestoreRepository: FirestoreRepository): ViewModel() {

    fun getAllEventsList(): LiveData<List<ShishirEvent>> {
        val eventsListLiveData = MutableLiveData<List<ShishirEvent>>()

        firestoreRepository.getAllEventsList().addOnSuccessListener {
            val eventsList = it.toObjects<ShishirEvent>()
            eventsListLiveData.value = eventsList
        }.addOnFailureListener {
            Timber.e("Failed to get events list")
        }

        return eventsListLiveData
    }

}