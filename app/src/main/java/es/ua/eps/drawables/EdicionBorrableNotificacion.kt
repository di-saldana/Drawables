package es.ua.eps.drawables

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class EdicionBorrableNotificacion : LinearLayout {
    var editText: EditText? = null
    var button: Button? = null

    constructor(ctx: Context?) : super(ctx) {
        inicializar()
    }
    constructor(ctx: Context?, atts: AttributeSet?)
            : super(ctx, atts) {
        inicializar()
    }
    private fun inicializar() {
        val li = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        li.inflate(R.layout.edicionborrable_notificacion, this, true)

        editText = findViewById(R.id.editText) as EditText
        button = findViewById(R.id.button) as Button

        button?.setOnClickListener {
            if(editText!!.editableText.toString() == "") {
                showNotifToast("Escribe un texto")
            } else {
                showNotifToast(editText!!.editableText.toString())
                editText?.setText("")
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