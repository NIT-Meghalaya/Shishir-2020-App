package nitmeghalaya.shishir2020.model.facebookpagefeed

import com.squareup.moshi.JsonClass

/**
 * Created by Devansh on 8/3/20
 */

@JsonClass(generateAdapter = true)
class FacebookPageFeed(
    val data: List<FacebookPageFeedItem> = listOf(),
    val paging: FacebookPageFeedPaginationCursor = FacebookPageFeedPaginationCursor()
)