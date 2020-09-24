package com.ebookfrenzy.eventexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

import android.widget.TextView
import android.view.MotionEvent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                TODO("Not yet implemented")
            }
        })

        myButton.setOnClickListener {
            statusText.text = "Button clicked."
        }

        myButton.setOnLongClickListener {
            statusText.text = "Long button click..."
            false //boolen determines whether not other click listener events will fire.
        }

        activity_main.setOnTouchListener { _, m: MotionEvent ->
            handleTouch(m)
            true
        }
    }

    private fun handleTouch(m: MotionEvent) {

        val pointerCount = m.pointerCount
        for (i in 0 until pointerCount) {
            val x = m.getX(i)
            val y = m.getY(i)
            val id = m.getPointerId(i)
            val action = m.actionMasked
            val actionIndex = m.actionIndex
            var actionString: String

            when (action) {
                MotionEvent.ACTION_DOWN -> actionString = "DOWN"
                MotionEvent.ACTION_UP -> actionString = "UP"

                MotionEvent.ACTION_POINTER_DOWN -> actionString = "POINTER DOWN"
                MotionEvent.ACTION_POINTER_UP -> actionString = "POINTER UP"

                MotionEvent.ACTION_MOVE -> actionString = "MOVE"
                else -> actionString = ""
            }

            val touchStatus = "Action: $actionString Index: $actionIndex ID: $id X: $x Y: $y"
            if (id == 0)
                textView1.text = touchStatus
            else
                textView2.text = touchStatus
        }
    }
}