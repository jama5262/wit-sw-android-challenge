package com.jama.wit_sw_android_challenge.helpers

import android.app.Activity
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.jama.wit_sw_android_challenge.R
import me.toptas.fancyshowcase.FancyShowCaseQueue
import me.toptas.fancyshowcase.FancyShowCaseView
import me.toptas.fancyshowcase.FocusShape
import me.toptas.fancyshowcase.listener.OnCompleteListener
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class Tutorial(private val activity: Activity) {
    private val tours = mutableListOf<FancyShowCaseView>()

    suspend fun show(): Boolean {
        return suspendCoroutine { continuation ->
            val queue = FancyShowCaseQueue()

            tours.forEach {
                queue.add(it)
            }

            queue.completeListener = object : OnCompleteListener {
                override fun onComplete() {
                    continuation.resume(true)
                }
            }
            queue.show()

            tours.clear()
        }
    }

    fun add(title: String, view: View? = null) {
        val tour = FancyShowCaseView.Builder(activity)
            .title(title)
            .enableAutoTextPosition()
            .titleSize(20, TypedValue.COMPLEX_UNIT_SP)
            .titleGravity(Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL)
            .typeface(ResourcesCompat.getFont(activity, R.font.libre_baskerville))
            .focusShape(FocusShape.ROUNDED_RECTANGLE)

        if (view != null) tour.focusOn(view)

        tours.add(tour.build())
    }
}