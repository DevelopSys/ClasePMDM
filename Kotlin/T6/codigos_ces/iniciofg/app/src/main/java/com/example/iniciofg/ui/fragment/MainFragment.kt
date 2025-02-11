package com.example.iniciofg.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.iniciofg.R
import com.example.iniciofg.databinding.FragmentDosBinding
import com.example.iniciofg.databinding.FragmentMainBinding
import com.example.iniciofg.databinding.FragmenteLoginBinding
import com.example.iniciofg.model.Usuario
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var usuario:Usuario
    private lateinit var fireDatabase: FirebaseDatabase

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fireDatabase = FirebaseDatabase.getInstance("https://compras-ec8a2-default-rtdb.europe-west1.firebasedatabase.app/")
        // usuario = arguments?.getSerializable("usuario") as Usuario
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // XML -> inflater-> View
        binding = FragmentMainBinding.inflate(layoutInflater, container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        val usuario: FirebaseUser? = FirebaseAuth.getInstance().currentUser;
        binding.btnEscribir.setOnClickListener {
            fireDatabase.reference.child("usuarios").child(usuario?.uid?:"invitado").child("nombre").setValue("borja")
            fireDatabase.reference.child("usuarios").child(usuario?.uid?:"invitado").child("correo").setValue("borja@gmail.com")
            fireDatabase.reference.child("usuarios").child(usuario?.uid?:"invitado").child("pass").setValue("password1234")
        }

        binding.btnLeer.setOnClickListener {
            fireDatabase.reference.child("usuarios")
                .addValueEventListener(object: ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        if (snapshot.exists()){
                            /*val valor = snapshot.getValue(String::class.java)
                            Log.v("valores",valor.toString())*/
                            for ( child in snapshot.children){
                                /*val nombre= child.child("nombre")
                                val apellido= child.child("correo")
                                val pass= child.child("pass")*/
                                val usuario = child.getValue(Usuario::class.java)
                                Log.v("valores","Usuario ${usuario!!.nombre} obtenido correctamente")

                            }
                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }

                })
        }
        // binding.textoLogin.text = "Enhorabuena ${usuario.nombre}"

    }
}