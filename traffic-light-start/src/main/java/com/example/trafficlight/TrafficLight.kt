package com.example.trafficlight

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class TrafficLight(context: Context, attrs: AttributeSet): View(context, attrs) {

    companion object {
        private const val RED_COLOR = Color.RED
        private const val YELLOW_COLOR = Color.YELLOW
        private const val GREEN_COLOR = Color.GREEN
        private const val BLACK_COLOR = Color.BLACK
        private const val GREY_COLOR = Color.GRAY
    }

    private val paint = Paint().apply {
        style = Paint.Style.FILL
    }

    private val trafficLightWidth = resources.getDimensionPixelSize(R.dimen.traffic_light_width)
    private val trafficLightHeight = resources.getDimensionPixelSize(R.dimen.traffic_light_height)

    var state = TrafficState.STOP
        // This is a custom setter for the variable. Calls invalidate() to redraw the View whenever
        // the state is changed.
        set(state) {
            field = state
            invalidate()
        }

    init {
        paint.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        // call super method to keep any drawing from parent
        super.onDraw(canvas)

        drawLightBackground(canvas)
        drawRedLight(canvas)
        drawYellowLight(canvas)
        drawGreenLight(canvas)
    }

    private fun drawLightBackground(canvas: Canvas) {
        paint.color = BLACK_COLOR
        paint.style = Paint.Style.FILL

        val rect = RectF(0f, 0f, trafficLightWidth.toFloat(), trafficLightHeight.toFloat())
        canvas.drawRect(rect, paint)
    }

    private fun drawRedLight(canvas: Canvas) {
        paint.color = if (state == TrafficState.STOP) {
            RED_COLOR
        } else {
            GREY_COLOR
        }
        canvas.drawCircle(150f, 150f, 100f, paint)
    }

    private fun drawYellowLight(canvas: Canvas) {
        // TODO: complete this function
    }

    private fun drawGreenLight(canvas: Canvas) {
        // TODO: complete this function
    }
}

enum class TrafficState {
    STOP,
    SLOW,
    GO;
}

