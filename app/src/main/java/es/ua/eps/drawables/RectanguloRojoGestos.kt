package es.ua.eps.drawables

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat

class RectanguloRojoGestos(context: Context) : View(context) {
    private val paint = Paint()
    private var mX: Float = 0.0F
    private var mY: Float = 0.0F
    private var idPunteroActivo = -1
    private var isPointerInside = false
    private var isRedColor = true
    private var flingStartX: Float = 0.0F
    private var flingStartY: Float = 0.0F
    private var flingEndX: Float = 0.0F
    private var flingEndY: Float = 0.0F
    private val gestureDetector: GestureDetectorCompat

    init {
        gestureDetector = GestureDetectorCompat(context, GestureListener())
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val size = 50

        paint.color = if (isRedColor) Color.RED else Color.BLUE
        canvas.drawRect(mX, mY, mX + size, mY + size, paint)

        if (flingStartX != 0.0F && flingStartY != 0.0F) {
            paint.color = Color.BLACK
            canvas.drawLine(flingStartX, flingStartY, flingEndX, flingEndY, paint)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event)
    }

    inner class GestureListener : GestureDetector.SimpleOnGestureListener() {

        override fun onDown(e: MotionEvent): Boolean {
            if (isInsideRectangle(e.x, e.y)) {
                idPunteroActivo = e.getPointerId(0)
                mX = e.x
                mY = e.y
                isPointerInside = true
                invalidate()
            } else {
                isPointerInside = false
            }
            return isPointerInside
        }

        override fun onScroll(e1: MotionEvent, e2: MotionEvent, p1: Float, p2: Float): Boolean {
            if (isPointerInside) {
                mX -= p1
                mY -= p2
                invalidate()
            }
            return true
        }

        override fun onSingleTapUp(e: MotionEvent): Boolean {
            isRedColor = !isRedColor
            invalidate()
            return true
        }

        override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
            flingStartX = e1.x
            flingStartY = e1.y
            flingEndX = e2.x
            flingEndY = e2.y

            invalidate()
            return true
        }
    }

    private fun isInsideRectangle(x: Float, y: Float): Boolean {
        val rect = Rect()
        getLocalVisibleRect(rect)
        return rect.contains(x.toInt(), y.toInt())
    }

}
