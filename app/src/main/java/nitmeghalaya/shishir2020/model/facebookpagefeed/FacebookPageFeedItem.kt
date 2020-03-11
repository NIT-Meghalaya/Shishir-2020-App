package nitmeghalaya.shishir2020.model.facebookpagefeed

import com.squareup.moshi.Json
//import com.squareup.moshi.JsonClass

/**
 * Created by Devansh on 8/3/20
 */

//@JsonClass(generateAdapter = true)
class FacebookPageFeedItem(
    val id: String = "",
    val message: String = "",
    @Json(name = "full_picture") val fullPictureUrl: String = "",
    @Json(name = "created_time") val createdTime: String = ""
) {

    companion object {
        fun getAllProperties(): String = "id,message,full_picture,created_time"
    }
}