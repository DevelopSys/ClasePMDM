package com.example.masterdetail.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.masterdetail.R;

import org.w3c.dom.Text;

public class FragmentDetail extends Fragment {

    private View view;
    private TextView textView;
    private String dato;

    public static FragmentDetail newInstance(String dato) {
        FragmentDetail fragment = new FragmentDetail();

        Bundle args = new Bundle();
        args.putString("dato",dato);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (this.getArguments() !=null){
            dato = getArguments().getString("dato");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail, container, false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        textView = view.findViewById(R.id.texto_detalle);
        textView.setText(dato);

    }
}
