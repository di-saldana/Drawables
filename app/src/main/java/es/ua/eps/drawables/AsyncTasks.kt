package es.ua.eps.drawables

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AsyncTasks : AppCompatActivity() {

    lateinit var tvCrono: TextView
    val contador = Contador()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)

        tvCrono = findViewById(R.id.tvCrono)
        contador.execute()
    }

    inner class Contador : AsyncTask<Void, Int, String>() {
        override fun doInBackground(vararg params: Void?): String {
            var t = 10
            while (t > 0) {
                publishProgress(t)
                Thread.sleep(1000)
                t--
            }
            return "Contador terminado"
        }

        override fun onProgressUpdate(vararg values: Int?) {
            val t = values[0]
            if (t != null) {
                tvCrono.text = "Contador: $t"
            }
        }

        override fun onPostExecute(result: String?) {
            tvCrono.text = result
        }
    }
}