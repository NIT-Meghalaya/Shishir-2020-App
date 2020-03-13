package nitmeghalaya.shishir2020.screens.facebookpagefeed

import android.content.Intent
import android.graphics.*
import android.net.Uri
import android.text.format.DateUtils
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.datasource.FacebookPageFeedDataSourceFactory
import nitmeghalaya.shishir2020.model.facebookpagefeed.FacebookPageFeedItem
import nitmeghalaya.shishir2020.util.spToPx
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Devansh on 6/3/20
 */

class FacebookPageFeedViewModel(facebookPageFeedDataSourceFactory: FacebookPageFeedDataSourceFactory)
    : ViewModel() {

    val pageFeedItemPagedList: LiveData<PagedList<FacebookPageFeedItem>>

    init {
        val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(15)
            .build()

        pageFeedItemPagedList = LivePagedListBuilder(facebookPageFeedDataSourceFactory, pagedListConfig).build()
    }

    fun getRelativeDateFromISO8601String(dateString: String): CharSequence {
        val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
            .parse(dateString.split("+", ignoreCase = true)[0]) ?: Date()

        val istIncrement = 19800000L
        return DateUtils.getRelativeTimeSpanString(date.time + istIncrement, Date().time,
            DateUtils.MINUTE_IN_MILLIS, DateUtils.FORMAT_ABBREV_RELATIVE)
    }

    fun getExternalLinkIntent(url: String): Intent {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        return intent
    }

    fun createFeedShareMessageBitmap(attachTo: View): Bitmap {
        val bitmap = Bitmap.createBitmap(
            attachTo.width, spToPx(20f, attachTo.context), Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint().apply {
            color = ContextCompat.getColor(attachTo.context, R.color.colorPrimary)
            style = Paint.Style.FILL
        }
        canvas.drawPaint(paint)

        paint.apply {
            color = Color.BLACK
            isAntiAlias = true
            textSize = spToPx(16f, attachTo.context).toFloat()
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        }
        canvas.drawText(attachTo.context.getString(R.string.share_text), 0f, paint.textSize, paint)

        return bitmap
    }
}