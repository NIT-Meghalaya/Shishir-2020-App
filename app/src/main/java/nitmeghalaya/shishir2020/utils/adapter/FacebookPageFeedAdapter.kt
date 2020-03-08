package nitmeghalaya.shishir2020.utils.adapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader
import nitmeghalaya.shishir2020.model.FacebookPageFeed

/**
 * Created by Devansh on 8/3/20
 */

class FacebookPageFeedAdapter {

    @FromJson
    fun fromJson(
        jsonReader: JsonReader
//        feedItemAdapter: JsonAdapter<FacebookPageFeedItem>,
//        feedPaginationCursorAdapter: JsonAdapter<FacebookPageFeedPaginationCursor>
    ): FacebookPageFeed {

        val value = jsonReader.readJsonValue()
        return FacebookPageFeed()
    }

}