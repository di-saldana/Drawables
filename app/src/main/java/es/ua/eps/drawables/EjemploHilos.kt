package es.ua.eps.drawables

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EjemploHilos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejemplo_hilos)

//        val tvCrono = findViewById<TextView>(R.id.tvCrono)
//        var t = 10
//        do {
//            tvCrono.text = "Contador: $t"
//            Thread.sleep(1000)
//            t--
//        } while (t > 0)
//        tvCrono.text = "Contador terminado"

        val thread = findViewById<Button>(R.id.thread)
        val async = findViewById<Button>(R.id.asyncTask)
        val corrutinas = findViewById<Button>(R.id.corrutinas)

        thread.setOnClickListener {
            val intent = Intent(this, Threads::class.java)
            startActivity(intent)
        }

        async.setOnClickListener {
            val intent = Intent(this, AsyncTasks::class.java)
            startActivity(intent)
        }

        corrutinas.setOnClickListener {
            val intent = Intent(this, Corrutinas::class.java)
            startActivity(intent)
        }
    }
}