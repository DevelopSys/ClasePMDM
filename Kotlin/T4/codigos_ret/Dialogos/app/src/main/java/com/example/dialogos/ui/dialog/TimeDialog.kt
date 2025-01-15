package com.example.dialogos.ui.dialog

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.dialogos.MainActivity

class TimeDialog: DialogFragment() {

    private lateinit var context: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context;
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return TimePickerDialog(context,
            context as MainActivity,
            Calendar.getInstance().get(Calendar.HOUR),
            Calendar.getInstance().get(Calendar.MINUTE),
            true)
    }


}