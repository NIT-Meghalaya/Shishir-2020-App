package nitmeghalaya.shishir2020.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import nitmeghalaya.shishir2020.model.FacebookPageFeed
import nitmeghalaya.shishir2020.network.FacebookPageApiService
import nitmeghalaya.shishir2020.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Devansh on 7/3/20
 */

class FacebookPageRepository {

    private val facebookPageApiService: FacebookPageApiService by lazy {
        RetrofitService.createService(FacebookPageApiService::class.java)
    }

    fun getPageFeed(accessToken: String): LiveData<String> {
        val pageFeedStringLiveData = MutableLiveData<String>()

        facebookPageApiService.getPageFeed(accessToken, FacebookPageFeed.getAllProperties())
            .enqueue(object : Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    pageFeedStringLiveData.value = "Failure: " + t.localizedMessage
                }

                override fun onResponse(call: Call<String>, response: Response<String>) {
                    pageFeedStringLiveData.value = response.body()
                }
            })

        return pageFeedStringLiveData
    }
}