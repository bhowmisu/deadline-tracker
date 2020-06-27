package com.tyche.deadlinetracker.ui.main

import android.app.DatePickerDialog
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.tyche.deadlinetracker.R
import java.util.*

class AddFragment : Fragment() {

    companion object {
        fun newInstance() = AddFragment()
    }

    private lateinit var viewModel: AddViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setStyle(DialogFragment.STYLE_NORMAL, R.style.UserDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root =  inflater.inflate(R.layout.add_fragment, container, false)


        val expiredDateText = root.findViewById<TextView>(R.id.expiryDate)
        expiredDateText.setOnClickListener {
            dateInput(it)
        }

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddViewModel::class.java)
        // TODO: Use the ViewModel
    }


    private fun dateInput(view: View) {
        val calendar = Calendar.getInstance()

        val picker =
            activity?.let {
                DatePickerDialog(
                    it, DatePickerDialog.OnDateSetListener { _: DatePicker, i: Int, i1: Int, i2: Int ->

                    }, calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
            }


        picker?.show()

    }


}