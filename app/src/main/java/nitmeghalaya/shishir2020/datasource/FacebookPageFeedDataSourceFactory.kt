package nitmeghalaya.shishir2020.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import nitmeghalaya.shishir2020.model.facebookpagefeed.FacebookPageFeedItem

/**
 * Created by Devansh on 10/3/20
 */

class FacebookPageFeedDataSourceFactory : DataSource.Factory<String, FacebookPageFeedItem>() {

    private val facebookPageFeedLiveDataSource = MutableLiveData<FacebookPageFeedDataSource>()

    override fun create(): DataSource<String, FacebookPageFeedItem> {
        val facebookPageFeedDataSource = FacebookPageFeedDataSource()
        facebookPageFeedLiveDataSource.postValue(facebookPageFeedDataSource)
        return facebookPageFeedDataSource
    }

    fun getFacebookPageFeedLiveDataSource(): LiveData<FacebookPageFeedDataSource> {
        return facebookPageFeedLiveDataSource
    }
}