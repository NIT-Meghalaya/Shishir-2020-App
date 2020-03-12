package nitmeghalaya.shishir2020.repository

import nitmeghalaya.shishir2020.model.facebookpagefeed.FacebookPageFeed
import nitmeghalaya.shishir2020.model.facebookpagefeed.FacebookPageFeedItem
import nitmeghalaya.shishir2020.network.FacebookPageApiService
import nitmeghalaya.shishir2020.network.RetrofitService
import retrofit2.Call

/**
 * Created by Devansh on 7/3/20
 */

class FacebookPageRepository {

    private val facebookPageApiService: FacebookPageApiService by lazy {
        RetrofitService.createService(FacebookPageApiService::class.java)
    }

    fun getPageFeedCallback(accessToken: String,
                            fields: String = FacebookPageFeedItem.getAllProperties(),
                            after: String? = null,
                            before: String? = null): Call<FacebookPageFeed> {
        return facebookPageApiService.getPageFeed(accessToken, fields, after, before)
    }
}