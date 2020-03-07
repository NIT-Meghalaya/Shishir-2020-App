package nitmeghalaya.shishir2020.model

import com.facebook.AccessToken
import com.google.firebase.firestore.Exclude

/**
 * Created by Devansh on 7/3/20
 */

data class BasicFacebookAccessTokenCreator(
    val accessToken: String = "",
    val applicationId: String = "",
    val userId: String = "",
    val permissions: ArrayList<String> = arrayListOf()
) {

    @Exclude
    fun makeAccessToken(): AccessToken {
        return AccessToken(
            accessToken,
            applicationId,
            userId,
            permissions,
            null,
            null,
            null,
            null,
            null,
            null
        )
    }
}