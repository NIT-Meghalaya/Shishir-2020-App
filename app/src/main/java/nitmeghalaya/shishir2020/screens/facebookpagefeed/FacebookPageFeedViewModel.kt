package nitmeghalaya.shishir2020.screens.facebookpagefeed

import android.content.Intent
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import nitmeghalaya.shishir2020.datasource.FacebookPageFeedDataSourceFactory
import nitmeghalaya.shishir2020.model.facebookpagefeed.FacebookPageFeedItem
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Devansh on 6/3/20
 */

class FacebookPageFeedViewModel(private val facebookPageFeedDataSourceFactory: FacebookPageFeedDataSourceFactory)
    : ViewModel() {

    val pageFeedItemPagedList: LiveData<PagedList<FacebookPageFeedItem>>

    init {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(15)
            .build()

        pageFeedItemPagedList = LivePagedListBuilder(facebookPageFeedDataSourceFactory, pagedListConfig).build()
    }

    fun getDateFromISO8601String(dateString: String): Date =
        SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
            .parse(dateString.split("+", ignoreCase = true)[0]) ?: Date()

    fun getExternalLinkIntent(url: String): Intent {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        return intent
    }
}