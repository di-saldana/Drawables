package es.ua.eps.drawables

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Threads : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        val tvCrono = findViewById(R.id.tvCrono) as TextView
        var t = 10

        Thread {
            do {
                tvCrono.text = "Contador: $t"
                Thread.sleep(1000)
                t--
            } while (t > 0)
            tvCrono.text = "Contador terminado"
        }.start()
    }
}