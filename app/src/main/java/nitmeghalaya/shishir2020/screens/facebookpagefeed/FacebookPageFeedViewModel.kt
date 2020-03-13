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
import nitmeghalaya.shishir2020.util.dpToPx
import nitmeghalaya.shishir2020.util.spToPx
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.max

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
        val context = attachTo.context

        val logoBitmap = BitmapFactory.decodeResource(context.resources, R.drawable.ic_app)
        val height = max(spToPx(24f, context), logoBitmap.height + 8)

        val bitmap = Bitmap.createBitmap(attachTo.width, height, Bitmap.Config.ARGB_8888)

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
            textAlign = Paint.Align.LEFT
        }

        val shareText = context.getString(R.string.share_text)
        val textBoundsRect = Rect()
        paint.getTextBounds(shareText, 0, shareText.length, textBoundsRect)
        val drawStartX = bitmap.width - textBoundsRect.right - dpToPx(8f, context).toFloat()
        val drawStartY = bitmap.height / 2f + dpToPx(4f, context)
        canvas.drawText(shareText, drawStartX, drawStartY, paint)

        val logoBitmapRect = Rect(0, 0, logoBitmap.width, logoBitmap.height)
        canvas.drawBitmap(logoBitmap, null, logoBitmapRect, null)
        return bitmap
    }
}