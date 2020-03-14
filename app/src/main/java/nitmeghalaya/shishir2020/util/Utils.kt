package nitmeghalaya.shishir2020.util

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.util.TypedValue
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream


/**
 * Created by Devansh on 13/3/20
 */

fun Bitmap.share(context: Context) {
    try {
        val cachePath = File(context.cacheDir, "images")
        cachePath.mkdirs()
        val stream = FileOutputStream("$cachePath/this_image.png") // overwrites every time
        this.compress(Bitmap.CompressFormat.PNG, 100, stream)
        stream.close()

        val imagePath = File(context.cacheDir, "images")
        val newFile = File(imagePath, "this_image.png")

        val uri = FileProvider.getUriForFile(context, "nitmeghalaya.shishir2020", newFile)
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri)
        shareIntent.type = "image/jpeg"
        context.startActivity(Intent.createChooser(shareIntent, "Share"))

    } catch (e: FileNotFoundException) {
        e.printStackTrace()
    }
}

tailrec fun Context?.getActivity(): Activity? = when (this) {
    is Activity -> this
    else -> (this as? ContextWrapper)?.baseContext?.getActivity()
}

fun spToPx(sp: Float, context: Context): Int =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.resources.displayMetrics).toInt()

fun dpToPx(dp: Float, context: Context): Int =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, dp, context.resources.displayMetrics).toInt()