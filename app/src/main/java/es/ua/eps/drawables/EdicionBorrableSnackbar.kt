package es.ua.eps.drawables

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class EdicionBorrableSnackbar : LinearLayout {
    var editText: EditText? = null
    var button: Button? = null
    var listaDeTareas: TextView? = null
    constructor(ctx: Context?) : super(ctx) {
        inicializar()
    }
    constructor(ctx: Context?, atts: AttributeSet?) : super(ctx, atts) {
        inicializar()
    }
    private fun inicializar() {
        val li = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        li.inflate(R.layout.edicionborrable_snack, this, true)

        editText = findViewById(R.id.editText) as EditText
        button = findViewById(R.id.button) as Button
        listaDeTareas = findViewById(R.id.textViewSnack) as TextView

        button?.setOnClickListener {
            if (editText!!.editableText.toString() == "") {
                showNotifToast("Escribe un texto")
                editText?.setText("")
            } else {
                val taskText = editText!!.editableText.toString()
                listaDeTareas!!.append("\n$taskText")
                editText?.setText("")

                val snack = Snackbar.make(it, "Tarea añadida", Snackbar.LENGTH_LONG)
                snack.setAction("DESHACER", View.OnClickListener {
                    // TODO: Better implementation
                    val text = listaDeTareas!!.text.toString()
                    val lastTaskIndex = text.lastIndexOf("\n")
                    if (lastTaskIndex >= 0) {
                        listaDeTareas!!.text = text.substring(0, lastTaskIndex)
                    } else {
                        listaDeTareas!!.text = ""
                    }
                }).show()
            }
        }
    }

    private fun showNotifToast(texto: String) {
        val layout = LayoutInflater.from(context).inflate(R.layout.toast_layout, null)
        val toastText = layout!!.findViewById<TextView>(R.id.toast_text)
        toastText.text = texto

        val t3 = Toast(context)
//        if (Build.VERSION.SDK_INT < 30)
        t3.setGravity(Gravity.CENTER, 0, 0)
        t3.duration = Toast.LENGTH_SHORT
        t3.view = layout
        t3.show()
    }
}