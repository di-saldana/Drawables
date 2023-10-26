package es.ua.eps.drawables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Corrutinas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_corrutinas)

        val tvCrono = findViewById<TextView>(R.id.tvCrono)
        var t = 10

        GlobalScope.launch(Dispatchers.IO) {
            do {
                tvCrono.text = "Contador: $t"
                Thread.sleep(1000)
                t--
            } while (t > 0)
            tvCrono.text = "Contador terminado"
        }
    }
}