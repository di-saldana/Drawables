package es.ua.eps.drawables

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import kotlin.random.Random

class TextViewCitas @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : androidx.appcompat.widget.AppCompatTextView(context, attrs) {

    private val array_citas = arrayOf(
        "Fool Me Once, Strike One, But Fool Me Twice… Strike Three.",
        "I'm Not Superstitious, But I Am A Little Stitious.",
        "And I Knew Exactly What To Do. But In A Much More Real Sense, I Had No Idea What To Do.",
        "I Am Beyoncé, Always.", "Would I Rather Be Feared Or Loved? Easy. Both.",
        "That's What She Said.", "\"You miss 100% of the shots you don't take. – Wayne Gretzky\" – Michael Scott",
        "I… Declare…. Bankruptcy!", "Saw Inception. Or at least I dreamt I did…", "It’s never too early for ice cream."
    )

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        setRandomQuote()
        return super.onTouchEvent(event)
    }

    init {
        setRandomQuote()
    }

    private fun setRandomQuote() {
        val randomIndex = Random.nextInt(array_citas.size)
        text = array_citas[randomIndex]
    }

}