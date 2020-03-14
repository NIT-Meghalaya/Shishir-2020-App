package nitmeghalaya.shishir2020.util

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect
import android.os.Build
import android.os.Handler
import android.view.PixelCopy
import android.view.View
import timber.log.Timber

/**
 * Appends the {@link Bitmap} to the bottom the original bitmap
 *
 * @param otherBitmap Bitmap to add to the bottom space in the first bitmap
 *
 * @return The new bitmap with input added to it
 */
fun Bitmap.appendBelow(otherBitmap: Bitmap): Bitmap {
    val combinedBitmap = Bitmap.createBitmap(width, height + otherBitmap.height, Bitmap.Config.ARGB_8888)
    val combiningCanvas = Canvas(combinedBitmap)

    val originalRect = Rect(0, 0, combinedBitmap.width, height)
    combiningCanvas.drawBitmap(this, null, originalRect, null)
    val otherRect = Rect(0, height + 1, combinedBitmap.width, combinedBitmap.height)
    combiningCanvas.drawBitmap(otherBitmap, null, otherRect, null)

    return combinedBitmap
}

fun View.getBitmap(action: (bitmap: Bitmap) -> Unit) {
    this.context.getActivity()?.window?.let { window ->

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            val locationOfViewInWindow = IntArray(2)
            getLocationInWindow(locationOfViewInWindow)

            try {
                val rect = Rect(
                    locationOfViewInWindow[0],
                    locationOfViewInWindow[1],
                    locationOfViewInWindow[0] + width,
                    locationOfViewInWindow[1] + height
                )

                val pixelCopyResultListener = PixelCopy.OnPixelCopyFinishedListener { copyResult ->
                    if (copyResult == PixelCopy.SUCCESS) {
                        action(bitmap)
                    }
                    else
                        Timber.e("Failed to copy result: $copyResult")
                }
                PixelCopy.request(window, rect, bitmap, pixelCopyResultListener, Handler())
            } catch (e: Exception) {
                when (e) {
                    is IllegalAccessException -> Timber.e("Illegal access: ${e.message}")
                }
            }
        } else {
            this.isDrawingCacheEnabled = true
            this.buildDrawingCache()
            val bitmap = this.drawingCache
            action(bitmap)
        }
    }
}

//Replaces the contents of this bitmap with the contents of the other bitmap
@Throws(IllegalArgumentException::class)
fun Bitmap.replaceContents(otherBitmap: Bitmap) {
    require((width == otherBitmap.width) and (height == otherBitmap.height)) {
        "The two bitmaps must have same the dimensions" }

    val pixels = IntArray(width * height)
    getPixels(pixels, 0, otherBitmap.width, 0, 0, otherBitmap.width, otherBitmap.height)
    setPixels(pixels, 0, width, 0, 0, width, height)
}