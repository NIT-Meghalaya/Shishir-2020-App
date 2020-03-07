package nitmeghalaya.shishir2020.screens.shishirpagefeed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.facebook.AccessToken
import com.google.firebase.firestore.ktx.toObject
import nitmeghalaya.shishir2020.model.BasicFacebookAccessTokenCreator
import nitmeghalaya.shishir2020.repository.FirestoreRepository
import timber.log.Timber

/**
 * Created by Devansh on 6/3/20
 */

class ShishirPageFeedViewModel(private val firestoreRepository: FirestoreRepository): ViewModel() {

    companion object {
        private const val PAGE_ID = "347129762068773"
    }

    //fun getPageFeed(): LiveData

    fun getFacebookAccessToken(): LiveData<AccessToken> {
        val accessTokenLiveData = MutableLiveData<AccessToken>()

        firestoreRepository.getFacebookAccessTokenCreator("shishirPage")
            .addOnSuccessListener {
                val accessTokenCreator = it.toObject<BasicFacebookAccessTokenCreator>()
                accessTokenLiveData.value = accessTokenCreator?.makeAccessToken()
            }.addOnFailureListener {
                Timber.e("Failed to get access token")
            }

        return accessTokenLiveData
    }
}