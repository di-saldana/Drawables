package es.ua.eps.drawables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Gestos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val redRectangleView = RectanguloRojoGestos(this)
        setContentView(redRectangleView)
    }
}
