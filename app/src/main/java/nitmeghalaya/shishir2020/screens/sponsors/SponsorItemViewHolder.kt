package nitmeghalaya.shishir2020.screens.sponsors

import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.View
import nitmeghalaya.shishir2020.model.SponsorItem
import nitmeghalaya.shishir2020.screens.BaseViewHolder
import nitmeghalaya.shishir2020.screens.SponsorBaseViewHolder

abstract class SponsorItemViewHolder(view: View): SponsorBaseViewHolder(view) {
    abstract var type: Int
}