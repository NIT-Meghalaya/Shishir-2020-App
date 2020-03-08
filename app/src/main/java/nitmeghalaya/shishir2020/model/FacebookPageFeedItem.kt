package nitmeghalaya.shishir2020.model

import com.squareup.moshi.Json

/**
 * Created by Devansh on 8/3/20
 */

class FacebookPageFeedItem(
    val id: String = "",
    val message: String = "",
    val from: String = "",
    @Json(name = "full_picture") val fullPictureUrl: String = "",
    @Json(name = "created_time") val createdTime: String = ""
) {

    companion object {
        fun getAllProperties(): String = "id,message,from,full_picture,created_time"
    }
}