package com.borja.t6_bottomnav.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.borja.t6_bottomnav.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DosFragment extends Fragment {


    public DosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dos, container, false);
    }

}
