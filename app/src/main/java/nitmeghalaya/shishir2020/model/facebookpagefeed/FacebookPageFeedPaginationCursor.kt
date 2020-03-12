    package nitmeghalaya.shishir2020.model.facebookpagefeed

import com.squareup.moshi.JsonClass

/**
 * Created by Devansh on 8/3/20
 */

@JsonClass(generateAdapter = true)
class FacebookPageFeedPaginationCursor(
    val cursors: FacebookPageFeedPaginationCursorItem = FacebookPageFeedPaginationCursorItem(),
    val next: String = "",
    val previous: String = ""
)

@JsonClass(generateAdapter = true)
class FacebookPageFeedPaginationCursorItem(val before: String = "", val after: String = "")