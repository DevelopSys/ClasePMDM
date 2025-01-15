package com.example.dialogos.ui.dialog

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.dialogos.MainActivity

class DateDialog: DialogFragment() {

    private lateinit var context: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context;
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return DatePickerDialog(context,
            context as MainActivity,
            Calendar.getInstance().get(Calendar.YEAR),
            Calendar.getInstance().get(Calendar.MONTH),
            Calendar.getInstance().get(Calendar.DAY_OF_MONTH))
    }


}