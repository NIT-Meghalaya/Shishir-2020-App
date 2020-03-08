package nitmeghalaya.shishir2020.screens.facebookpagefeed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.toObject
import nitmeghalaya.shishir2020.model.AccessToken
import nitmeghalaya.shishir2020.model.facebookpagefeed.FacebookPageFeed
import nitmeghalaya.shishir2020.repository.FacebookPageRepository
import nitmeghalaya.shishir2020.repository.FirestoreRepository
import timber.log.Timber

/**
 * Created by Devansh on 6/3/20
 */

class FacebookPageFeedViewModel(private val firestoreRepository: FirestoreRepository,
                                private val facebookPageRepository: FacebookPageRepository): ViewModel() {


    fun getPageFeed(accessToken: String): LiveData<FacebookPageFeed> {
        return facebookPageRepository.getPageFeed(accessToken)
    }

    fun getFacebookAccessToken(): LiveData<AccessToken> {
        val accessTokenLiveData = MutableLiveData<AccessToken>()

        firestoreRepository.getFacebookAccessTokenCreator("shishirPage")
            .addOnSuccessListener {
                accessTokenLiveData.value = it.toObject<AccessToken>()
            }.addOnFailureListener {
                Timber.e("Failed to get access token")
            }

        return accessTokenLiveData
    }
}