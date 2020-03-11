package nitmeghalaya.shishir2020.datasource

import androidx.paging.PageKeyedDataSource
import com.google.firebase.firestore.ktx.toObject
import nitmeghalaya.shishir2020.model.AccessToken
import nitmeghalaya.shishir2020.model.facebookpagefeed.FacebookPageFeed
import nitmeghalaya.shishir2020.model.facebookpagefeed.FacebookPageFeedItem
import nitmeghalaya.shishir2020.repository.FacebookPageRepository
import nitmeghalaya.shishir2020.repository.FirestoreRepository
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

/**
 * Created by Devansh on 10/3/20
 */

class FacebookPageFeedDataSource : PageKeyedDataSource<String, FacebookPageFeedItem>(), KoinComponent {

    private val firestoreRepository by inject<FirestoreRepository>()
    private val facebookPageRepository by inject<FacebookPageRepository>()

    private var accessToken: String = ""

    override fun loadInitial(params: LoadInitialParams<String>,
                             callback: LoadInitialCallback<String, FacebookPageFeedItem>) {

        firestoreRepository.getFacebookAccessTokenCreator(FirestoreRepository.SHISHIR_PAGE)
            .addOnSuccessListener {
                accessToken = it.toObject<AccessToken>()?.accessToken ?: ""
                facebookPageRepository.getPageFeedCallback(accessToken)
                    .enqueue(object : Callback<FacebookPageFeed> {

                        override fun onFailure(call: Call<FacebookPageFeed>, t: Throwable) {
                            Timber.e("Failed to get feed data")
                        }

                        override fun onResponse(call: Call<FacebookPageFeed>, response: Response<FacebookPageFeed>) {
                            val facebookPageFeedItemsList = response.body()?.data ?: listOf()
                            val paginationCursor = response.body()?.paging?.cursors

                            callback.onResult(facebookPageFeedItemsList.filter {item ->
                                item.message.isNotEmpty()
                            }, paginationCursor?.before, paginationCursor?.after)
                        }
                    })

            }.addOnFailureListener {
                Timber.i("Failed to get access token: $it")
            }
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, FacebookPageFeedItem>) {
        facebookPageRepository.getPageFeedCallback(accessToken, after = params.key)
            .enqueue(object : Callback<FacebookPageFeed> {
                override fun onFailure(call: Call<FacebookPageFeed>, t: Throwable) {
                    Timber.e("Failed to get feed page data")
                }

                override fun onResponse(call: Call<FacebookPageFeed>, response: Response<FacebookPageFeed>) {
                    val facebookPageFeedItemsList = response.body()?.data ?: listOf()
                    val paginationCursor = response.body()?.paging?.cursors

                    callback.onResult(facebookPageFeedItemsList.filter { item ->
                        item.message.isNotEmpty()
                    }, paginationCursor?.after)
                }
            })
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, FacebookPageFeedItem>) { }
}