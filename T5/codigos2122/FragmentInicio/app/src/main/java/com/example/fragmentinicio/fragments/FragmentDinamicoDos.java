package com.example.fragmentinicio.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentinicio.R;
import com.example.fragmentinicio.utils.Usuario;

public class FragmentDinamicoDos extends Fragment {
    private View view;
    private TextView textoNombre, textoApellido, textoEdad;
    private Usuario usuario;

    public static FragmentDinamicoDos newInstance(Usuario usuario){

        FragmentDinamicoDos fragmentDinamicoDos = new FragmentDinamicoDos();
        Bundle bundle = new Bundle();
        bundle.putSerializable("usuario",usuario);
        fragmentDinamicoDos.setArguments(bundle);
        return fragmentDinamicoDos;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (this.getArguments()!=null){
           this.usuario = (Usuario) this.getArguments().getSerializable("usuario");
        }
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_dinamico_dos_layout,
                container,false);
        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        textoNombre = view.findViewById(R.id.texto_nombre);
        textoEdad = view.findViewById(R.id.texto_edad);
        textoApellido = view.findViewById(R.id.texto_apellido);
        textoApellido.setText(usuario.getApellido());
        textoNombre.setText(usuario.getNombre());
        textoEdad.setText(String.valueOf(usuario.getEdad()));
    }
}
