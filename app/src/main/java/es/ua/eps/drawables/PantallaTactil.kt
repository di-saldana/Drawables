package es.ua.eps.drawables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PantallaTactil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val redRectangleView = RectanguloRojo(this)
        setContentView(redRectangleView)
    }

}