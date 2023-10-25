package es.ua.eps.drawables

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val grafica = findViewById<Grafica>(R.id.grafica)
        val seekBar = findViewById<SeekBar>(R.id.seekGrafica)

        val colorButton = findViewById<Button>(R.id.b1)
        val tamanoButton = findViewById<Button>(R.id.b2)
        val p1 = findViewById<TextView>(R.id.p1)
        val p2 = findViewById<TextView>(R.id.p2)

        val barraEstado = findViewById<Button>(R.id.barraEstado)
        val pantallaTactil = findViewById<Button>(R.id.pantallaTactil)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                grafica.setPercentage(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        colorButton.setOnClickListener { showDialogoColor(p1, p2) }
        tamanoButton.setOnClickListener { showDialogoTamano(p1, p2) }

        barraEstado.setOnClickListener {
            val intent = Intent(this, NotificacionesBarraEstado::class.java)
            startActivity(intent)
        }

        pantallaTactil.setOnClickListener {
            val intent = Intent(this, PantallaTactil::class.java)
            startActivity(intent)
        }
    }

    private fun showDialogoTamano(p1: TextView, p2: TextView) {
        val tamanos = arrayOf("Pequeño", "Normal", "Grande")

        AlertDialog.Builder(this)
            .setTitle("Selecciona el tamaño")
            .setItems(tamanos) { dialog, which ->
                Log.i("Dialogos", "Opción elegida: " + tamanos[which])

                when (which) {
                    0 -> {
                        p1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8F)
                        p2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 8F)
                    }
                    1 -> {
                        p1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12F)
                        p2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12F)
                    }
                    2 -> {
                        p1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)
                        p2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20F)
                    }
                }
            }
            .setNegativeButton(R.string.cancelar, null)
            .show()
    }

    private fun showDialogoColor(p1: TextView, p2: TextView) {
        val colores = arrayOf("Blanco y Negro", "Negro y Blanco", "Negro y Verde")

        AlertDialog.Builder(this)
            .setTitle("Selecciona los colores")
            .setItems(colores) { dialog, which ->
                Log.i("Dialogos", "Opción elegida: " + colores[which])

                when (which) {
                    0 -> {
                        p1.setBackgroundColor(Color.WHITE)
                        p1.setTextColor(Color.BLACK)

                        p2.setBackgroundColor(Color.WHITE)
                        p2.setTextColor(Color.BLACK)
                    }
                    1 -> {
                        p1.setBackgroundColor(Color.BLACK)
                        p1.setTextColor(Color.WHITE)

                        p2.setBackgroundColor(Color.BLACK)
                        p2.setTextColor(Color.WHITE)
                    }
                    2 -> {
                        p1.setBackgroundColor(Color.BLACK)
                        p1.setTextColor(Color.GREEN)

                        p2.setBackgroundColor(Color.BLACK)
                        p2.setTextColor(Color.GREEN)
                    }
                }
            }
            .setNegativeButton(R.string.cancelar, null)
            .show()
    }
}