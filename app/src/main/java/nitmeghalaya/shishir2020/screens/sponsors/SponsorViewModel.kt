package nitmeghalaya.shishir2020.screens.sponsors

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.toObject
import nitmeghalaya.shishir2020.model.SponsorList
import nitmeghalaya.shishir2020.repository.FirestoreRepository

class SponsorViewModel(private val firestoreRepository: FirestoreRepository): ViewModel() {

    fun getSponsors(): LiveData<SponsorList> {
        val sponsorsLiveData = MutableLiveData<SponsorList>()

        firestoreRepository.getSponsors().addOnSuccessListener {
            val sponsors = it.toObject<SponsorList>()
            sponsorsLiveData.value = sponsors
        }

        return sponsorsLiveData
    }

}