package nitmeghalaya.shishir2020.model.facebookpagefeed

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by Devansh on 11/3/20
 */

@JsonClass(generateAdapter = true)
data class FacebookFeedItemAttachments(val data: List<AttachmentData> = listOf()) {

    @JsonClass(generateAdapter = true)
    data class AttachmentData(@Json(name = "media_type") val mediaType: String = "")
}