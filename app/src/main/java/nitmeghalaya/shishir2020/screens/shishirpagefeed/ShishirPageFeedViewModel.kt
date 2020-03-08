package nitmeghalaya.shishir2020.screens.shishirpagefeed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.toObject
import nitmeghalaya.shishir2020.repository.FacebookPageRepository
import nitmeghalaya.shishir2020.repository.FirestoreRepository
import timber.log.Timber

/**
 * Created by Devansh on 6/3/20
 */

class ShishirPageFeedViewModel(private val firestoreRepository: FirestoreRepository,
                               private val facebookPageRepository: FacebookPageRepository): ViewModel() {


    fun getPageFeed(accessToken: String): LiveData<String> {

        return facebookPageRepository.getPageFeed(accessToken)
    }

    fun getFacebookAccessToken(): LiveData<String> {
        val accessTokenLiveData = MutableLiveData<String>()

        firestoreRepository.getFacebookAccessTokenCreator("shishirPage")
            .addOnSuccessListener {
                accessTokenLiveData.value = it.toObject<String>()
            }.addOnFailureListener {
                Timber.e("Failed to get access token")
            }

        return accessTokenLiveData
    }
}