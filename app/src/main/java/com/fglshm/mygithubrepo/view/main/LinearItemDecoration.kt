package com.fglshm.mygithubrepo.view.main

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class LinearItemDecoration(
    private val scale: Float,
    private val padding: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        outRect.left = scale.times(padding).toInt()
        outRect.right = scale.times(padding).toInt()
        outRect.bottom = scale.times(padding).toInt()

        if (position == 0) {
            outRect.top = scale.times(padding).toInt()
        }
    }

}