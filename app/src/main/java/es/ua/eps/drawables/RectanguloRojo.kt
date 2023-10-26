package es.ua.eps.drawables

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View


class RectanguloRojo(context: Context) : View(context) {
    private val paint = Paint()

    private var mX: Float = 0.0F
    private var mY: Float = 0.0F

    private var idPunteroActivo = -1

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val size = 50

        paint.color = Color.RED
        canvas.drawRect(mX, mY, mX + size, mY + size, paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val accion = event.action and MotionEvent.ACTION_MASK

        when (accion) {
            MotionEvent.ACTION_DOWN -> {
                // Guardamos como puntero activo el primero que se pulsa
                // (sin haber previamente otro pulsado)
                idPunteroActivo = event.getPointerId(0)
                mX = event.x
                mY = event.y
                this.invalidate()

                // return x >= mX && x <= mX + 50 && y >= mY && y <= mY + 50
                // TODO: Check
            }
            MotionEvent.ACTION_MOVE -> {
                // Obtenemos el índice del puntero activo para seguir su movimiento
                val indice = event.findPointerIndex(idPunteroActivo)
                mX = event.getX(indice)
                mY = event.getY(indice)
                this.invalidate()
            }
            // Ya no quedan más punteros en pantalla
            MotionEvent.ACTION_UP ->
                idPunteroActivo = -1

            // Se cancelan los eventos de la pantalla táctil
            MotionEvent.ACTION_CANCEL ->
                idPunteroActivo = -1

            MotionEvent.ACTION_POINTER_UP -> {
                // Comprobamos si el puntero que se ha levantado era el puntero activo
                var indice = (event.action and
                        MotionEvent.ACTION_POINTER_INDEX_MASK
                        shr MotionEvent.ACTION_POINTER_INDEX_SHIFT)
                val idPuntero = event.getPointerId(indice)

                if (idPuntero == idPunteroActivo) {
                    // Seleccionamos el siguiente puntero como activo
                    // Si el índice del puntero desaparecido era el 0,
                    // el nuevo puntero activo será el de índice 1.
                    // Si no, tomaremos como activo el de índice 0.
                    val indiceNuevoPunteroActivo = if (indice == 0) 1 else 0
                    mX = event.getX(indiceNuevoPunteroActivo)
                    mY = event.getY(indiceNuevoPunteroActivo)
                    idPunteroActivo = event.getPointerId(indiceNuevoPunteroActivo)
                    this.invalidate()
                }
            }
        }
        return true
    }
}