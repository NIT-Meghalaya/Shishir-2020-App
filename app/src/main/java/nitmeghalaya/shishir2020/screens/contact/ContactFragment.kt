package nitmeghalaya.shishir2020.screens.contact

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.google.android.material.card.MaterialCardView
import kotlinx.android.synthetic.main.fragment_contact.*
import kotlinx.android.synthetic.main.fragment_contact.view.*
import nitmeghalaya.shishir2020.R
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream

class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gsCult1ImageView.load("https://firebasestorage.googleapis.com/v0/b/shishir-2020.appspot.com/o/ShubhamGS.jpeg?alt=media&token=50464d8a-2b84-4966-aad7-1f78c75514ab") {
            transformations(RoundedCornersTransformation(20.0f))
        }
            gsCult2ImageView.load("https://firebasestorage.googleapis.com/v0/b/shishir-2020.appspot.com/o/rohitGS.jpg?alt=media&token=a6087666-6972-4112-b908-070b2628b1e4") {
                transformations(RoundedCornersTransformation(20.0f))
        }
        btnEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "shishir@nitm.ac.in", null))
            startActivity(Intent.createChooser(intent, "Choose an Email client :"))
        }

        btnFacebook.setOnClickListener {
            val uri = Uri.parse("https://www.facebook.com/shishir.nitm")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnWebsite.setOnClickListener {
            val uri = Uri.parse("http://www.shishir.co.in/")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnInstagram.setOnClickListener {
            val uri = Uri.parse("https://www.instagram.com/shishir2k18")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        btnShare.setOnClickListener {
            shareCard(view.cardView)
        }

        emailGSCult1.setOnClickListener {
            createEmailIntent(emailGSCult1.text.toString())
        }

        emailGSCult2.setOnClickListener {
            createEmailIntent(emailGSCult2.text.toString())
        }

        phoneGSCult1.setOnClickListener {
            createPhoneIntent(phoneGSCult1.text.toString())
        }

        phoneGSCult2.setOnClickListener {
            createPhoneIntent(phoneGSCult2.text.toString())
        }
    }


    private fun shareCard(card: MaterialCardView) {
        card.isDrawingCacheEnabled = true
        card.buildDrawingCache()
        val bitmap = card.drawingCache

        try {
            val cachePath = File(card.context.cacheDir, "images")
            cachePath.mkdirs() // don't forget to make the directory
            val stream = FileOutputStream("$cachePath/card_image.png") // overwrites this image every time
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            stream.close()

            val imagePath = File(card.context.cacheDir, "images")
            val newFile = File(imagePath, "card_image.png")

            val uri = FileProvider.getUriForFile(card.context, "nitmeghalaya.shishir2020", newFile)

            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.putExtra(Intent.EXTRA_STREAM, uri)
            shareIntent.type = "image/jpeg"
            context!!.startActivity(Intent.createChooser(shareIntent, "Share"))

        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
    }

    private fun createEmailIntent(email: String) {
        val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email, null))
        startActivity(Intent.createChooser(intent, "Choose an Email client :"))
    }

    private fun createPhoneIntent(phone: String) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null))
        startActivity(intent)
    }
    }

