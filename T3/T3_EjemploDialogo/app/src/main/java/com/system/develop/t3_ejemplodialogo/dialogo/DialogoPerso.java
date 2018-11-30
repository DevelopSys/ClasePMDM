package com.system.develop.t3_ejemplodialogo.dialogo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.system.develop.t3_ejemplodialogo.R;
import com.system.develop.t3_ejemplodialogo.adaptadore.AdaptadorPerso;

public class DialogoPerso extends DialogFragment {

    View v;
    Spinner spinnerDialogo;
    AdaptadorPerso adaptadorPerso;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        v = LayoutInflater.from(context).inflate(R.layout.dialogo_perso,null);
        adaptadorPerso = new AdaptadorPerso(null,context);
    }

    /*
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.dialogo_perso,null);
        return v;
    }*/

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        spinnerDialogo = v.findViewById(R.id.spinnerDialogo);
        builder.setView(v);
        return builder.create();
    }
}
