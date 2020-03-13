package nitmeghalaya.shishir2020.network

import nitmeghalaya.shishir2020.model.facebookpagefeed.FacebookPageFeed
import nitmeghalaya.shishir2020.model.facebookpagefeed.FacebookPageFeedItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Devansh on 8/3/20
 */

interface FacebookPageApiService {

    @GET("published_posts")
    fun getPageFeed(@Query("access_token") accessToken: String,
                    @Query("fields") fields: String = FacebookPageFeedItem.getAllProperties(),
                    @Query("after") after: String? = null,
                    @Query("before") before: String? = null,
                    @Query("limit") limit: Int = 20
                    //@Query("since") since: Long = 1575052200
    ): Call<FacebookPageFeed>
}