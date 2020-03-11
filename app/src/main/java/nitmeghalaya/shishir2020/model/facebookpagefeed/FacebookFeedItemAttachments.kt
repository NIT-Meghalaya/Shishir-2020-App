package nitmeghalaya.shishir2020.model.facebookpagefeed

import com.squareup.moshi.Json

/**
 * Created by Devansh on 11/3/20
 */

data class FacebookFeedItemAttachments(val data: List<AttachmentData> = listOf()) {

    data class AttachmentData(@Json(name = "media_type") val mediaType: String = "")
}