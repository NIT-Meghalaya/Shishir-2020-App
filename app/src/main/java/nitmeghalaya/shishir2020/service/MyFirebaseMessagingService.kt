package nitmeghalaya.shishir2020.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import coil.Coil
import coil.api.load
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import nitmeghalaya.shishir2020.R
import timber.log.Timber
import kotlin.random.Random

/**
 * Created by Devansh on 15/3/20
 */

class MyFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Timber.d("From: ${remoteMessage.from}")

        remoteMessage.notification?.apply {
            Timber.d("Message Notification Body: $body")

            Coil.load(applicationContext, imageUrl) {
                target { drawable ->
                    val imageBitmap = drawable.toBitmap()

                    val notificationChannelId =
                        applicationContext.getString(R.string.push_notifications_channel)
                    val notification = NotificationCompat.Builder(applicationContext, notificationChannelId)
                        .setColor(ContextCompat.getColor(applicationContext, R.color.colorAccent))
                        .setContentTitle(remoteMessage.notification?.title)
                        .setContentText(remoteMessage.notification?.body)
                        .setSmallIcon(R.drawable.ic_app_foreground)
                        .setLargeIcon(imageBitmap)
                        .setStyle(NotificationCompat.BigPictureStyle()
                            .bigPicture(imageBitmap)
                            .bigLargeIcon(null))
                        .build()

                    NotificationManagerCompat.from(applicationContext).apply {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            createNotificationChannel(
                                NotificationChannel(
                                    notificationChannelId,
                                    "Push notifications",
                                    NotificationManager.IMPORTANCE_DEFAULT
                                )
                            )
                        }
                        notify(Random(40).nextInt(), notification)
                    }
                }
            }
        }
    }

    override fun onNewToken(token: String) {

    }
}