package nitmeghalaya.shishir2020.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import nitmeghalaya.shishir2020.model.facebookpagefeed.FacebookPageFeed
import nitmeghalaya.shishir2020.model.facebookpagefeed.FacebookPageFeedItem
import nitmeghalaya.shishir2020.network.FacebookPageApiService
import nitmeghalaya.shishir2020.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

/**
 * Created by Devansh on 7/3/20
 */

class FacebookPageRepository {

    private val facebookPageApiService: FacebookPageApiService by lazy {
        RetrofitService.createService(FacebookPageApiService::class.java)
    }

    fun getPageFeed(accessToken: String): LiveData<FacebookPageFeed> {
        val pageFeedStringLiveData = MutableLiveData<FacebookPageFeed>()

        facebookPageApiService.getPageFeed(accessToken, FacebookPageFeedItem.getAllProperties())
            .enqueue(object : Callback<FacebookPageFeed> {
                override fun onFailure(call: Call<FacebookPageFeed>, t: Throwable) {
                    Timber.e("Failure: " + t.localizedMessage)
                }

                override fun onResponse(call: Call<FacebookPageFeed>, response: Response<FacebookPageFeed>) {
                    pageFeedStringLiveData.value = response.body()
                    Timber.i(response.body().toString())
                }
            })

        return pageFeedStringLiveData
    }
}