package nitmeghalaya.shishir2020.repository

import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.HttpMethod
import splitties.toast.toast
import timber.log.Timber

/**
 * Created by Devansh on 7/3/20
 */

class FacebookPageRepository {

    public fun getFeed(pageId: String, accessToken: AccessToken) {

        GraphRequest(
            accessToken,
            "/$pageId/feed",
            null,
            HttpMethod.GET,
            GraphRequest.Callback {
                it?.apply {
                    Timber.i(jsonObject.toString())
                    toast(jsonObject.toString())
                }
            }
        ).executeAsync()
    }

}