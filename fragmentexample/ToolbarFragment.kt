package com.ebookfrenzy.fragmentexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import android.widget.Button
import android.widget.SeekBar
import android.content.Context
import kotlinx.android.synthetic.main.toobar_fragment.*

import java.lang.ClassCastException

class ToolbarFragment: Fragment(),SeekBar.OnSeekBarChangeListener { //seekbarChangeListens catches changes to change to bar within seekbar class on screen.
    var seekvalue = 10

    var activityCallback: ToolbarFragment.ToolbarListener?=null
    interface ToolbarListener{fun onButtonClicked(fontsize: Int, text: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            activityCallback = context as ToolbarListener
        } catch (e: ClassCastException){
            throw ClassCastException(context.toString() + "must implement toolbar listener")
        }
    }


    override fun onCreateView( // override the onCreateView function to display fragment. Note: this function autofills in.
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate the layout for this fragment Note: previously created fragment is housed within the val below.
        val view = inflater.inflate(R.layout.toobar_fragment, container, false)

        val seekBar: SeekBar? = view?.findViewById(R.id.button1)
        seekBar?.setOnSeekBarChangeListener(this)
        val button: Button? = view?.findViewById(R.id.button1) // locating elements for the fragment

        seekBar?.setOnSeekBarChangeListener(this)
        button?.setOnClickListener { v:View -> buttonClicked(v) } // whats with all the question marks???

        return view
    }

    private fun buttonClicked(View: View){
        activityCallback?.onButtonClicked(seekvalue, editText1.text.toString())
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) { // required by seekbar lister near/at line 15
        seekvalue = progress // note the progress argument in the function, passing it the value here, storing the value to change the font.
    }

    override fun onStopTrackingTouch(arg0: SeekBar?) { // required by seekbar lister near/at line 15
        TODO("Not yet implemented")
    }

    override fun onStartTrackingTouch(arg0: SeekBar?) { // required by seekbar lister near/at line 15
        TODO("Not yet implemented")
    }
}