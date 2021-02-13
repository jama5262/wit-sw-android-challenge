package com.jama.wit_sw_android_challenge.helpers

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemSpacing: RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = dpToPx(parent.context, 20)

        when (parent.getChildAdapterPosition(view) % 2) {
            0 -> {
                outRect.left = dpToPx(parent.context, 20)
                outRect.right = dpToPx(parent.context, 5)
            }
            else -> {
                outRect.left = dpToPx(parent.context, 5)
                outRect.right = dpToPx(parent.context, 20)
            }
        }

        when(parent.getChildAdapterPosition(view)) {
            0, 1 -> {
                outRect.top = dpToPx(parent.context, 20)
            }
        }
    }

    private fun dpToPx(context: Context, dp: Int): Int {
        return (dp * context.resources.displayMetrics.density).toInt()
    }
}