package es.ua.eps.drawables

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Grafica : View {
    private val paint = Paint()
    private var percentage = 0

    constructor(context: Context) : super(context) { inicializar(null) }
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) { inicializar(attrs) }
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) { inicializar(attrs) }

    private fun inicializar(attrs: AttributeSet?) {
        if (attrs == null) return
        val ta = context.obtainStyledAttributes(
            attrs, R.styleable.Grafica )
        this.percentage = ta.getInt(R.styleable.Grafica_percentage, 0)
        ta.recycle()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val size = 100
        setMeasuredDimension(size, size)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width = canvas.clipBounds.width()
        val height = canvas.clipBounds.height()
        val centerX = width / 2f
        val centerY = height / 2f
        val radius = (width / 2).toFloat()

        paint.color = Color.BLUE
        canvas.drawCircle(centerX, centerY, radius, paint)

        paint.color = Color.RED
        val sweepAngle = (360 * (percentage / 100f))
        canvas.drawArc(0f, 0f, width.toFloat(), height.toFloat(), -90f, sweepAngle, true, paint)
    }

    fun setPercentage(percentage: Int) {
        this.percentage = percentage
        invalidate()
    }
}