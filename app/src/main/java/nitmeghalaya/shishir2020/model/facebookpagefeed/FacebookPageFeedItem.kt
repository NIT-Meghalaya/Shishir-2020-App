package nitmeghalaya.shishir2020.model.facebookpagefeed

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by Devansh on 8/3/20
 */

@JsonClass(generateAdapter = true)
data class FacebookPageFeedItem(
    val id: String = "",
    val message: String = "",
    @Json(name = "full_picture") val fullPictureUrl: String = "",
    @Json(name = "created_time") val createdTime: String = "",
    @Json(name = "permalink_url") val permalinkUrl: String = "",
    val attachments: FacebookFeedItemAttachments = FacebookFeedItemAttachments()
) {

    companion object {
        fun getAllProperties(): String =
            "id,message,full_picture,created_time,permalink_url,attachments{media_type}"
    }

    fun getMediaType() = attachments.data[0].mediaType

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FacebookPageFeedItem

        if (id != other.id) return false
        if (message != other.message) return false
        if (fullPictureUrl != other.fullPictureUrl) return false
        if (createdTime != other.createdTime) return false
        if (permalinkUrl != other.permalinkUrl) return false
        if (attachments != other.attachments) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + message.hashCode()
        result = 31 * result + fullPictureUrl.hashCode()
        result = 31 * result + createdTime.hashCode()
        result = 31 * result + permalinkUrl.hashCode()
        result = 31 * result + attachments.hashCode()
        return result
    }


}