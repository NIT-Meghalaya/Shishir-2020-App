package nitmeghalaya.shishir2020.screens.facebookpagefeed

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import nitmeghalaya.shishir2020.datasource.FacebookPageFeedDataSource
import nitmeghalaya.shishir2020.datasource.FacebookPageFeedDataSourceFactory
import nitmeghalaya.shishir2020.model.facebookpagefeed.FacebookPageFeedItem

/**
 * Created by Devansh on 6/3/20
 */

class FacebookPageFeedViewModel(private val facebookPageFeedDataSourceFactory: FacebookPageFeedDataSourceFactory)
    : ViewModel() {

    val pageFeedItemPagedList: LiveData<PagedList<FacebookPageFeedItem>>
    val pageFeedLiveDataSource: LiveData<FacebookPageFeedDataSource> by lazy {
        facebookPageFeedDataSourceFactory.getFacebookPageFeedLiveDataSource()
    }

    init {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(15)
            .build()

        pageFeedItemPagedList = LivePagedListBuilder(facebookPageFeedDataSourceFactory, pagedListConfig).build()
    }
}