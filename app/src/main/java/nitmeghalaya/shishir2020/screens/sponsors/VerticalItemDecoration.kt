package nitmeghalaya.shishir2020.screens.sponsors

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import nitmeghalaya.shishir2020.R

class VerticalItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view) // item position

        if (position == 0)
            outRect.top = view.context.resources.getDimension(R.dimen.actionBarSize).toInt()
    }
}