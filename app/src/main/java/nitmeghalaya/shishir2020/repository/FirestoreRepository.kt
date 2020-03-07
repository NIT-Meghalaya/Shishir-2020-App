package nitmeghalaya.shishir2020.repository

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

/**
 * Created by Devansh on 7/3/20
 */

class FirestoreRepository {

    private val db = Firebase.firestore

    companion object {
        private const val COLLECTION_FACEBOOK_ACCESS_TOKEN_CREATOR = "facebookAccessTokenCreators"
    }

    fun getFacebookAccessTokenCreator(documentId: String) =
        db.collection(COLLECTION_FACEBOOK_ACCESS_TOKEN_CREATOR).document(documentId).get()

}