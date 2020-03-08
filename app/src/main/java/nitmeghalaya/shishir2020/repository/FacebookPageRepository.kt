package nitmeghalaya.shishir2020.repository

import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.HttpMethod

/**
 * Created by Devansh on 7/3/20
 */

class FacebookPageRepository {

    fun getPageFeed(pageId: String, accessToken: AccessToken, action: () -> Unit) {

        GraphRequest(
            accessToken,
            "/$pageId/feed",
            null,
            HttpMethod.GET,
            GraphRequest.Callback {
                action()
            }
        ).executeAsync()
    }

}