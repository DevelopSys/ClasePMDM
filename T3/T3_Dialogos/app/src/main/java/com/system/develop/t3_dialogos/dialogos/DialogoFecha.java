package com.system.develop.t3_dialogos.dialogos;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

public class DialogoFecha extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(),
                Calendar.getInstance().get(java.util.Calendar.YEAR),
                Calendar.getInstance().get(java.util.Calendar.MONTH),
                Calendar.getInstance().get(java.util.Calendar.DAY_OF_MONTH));

    }
}
