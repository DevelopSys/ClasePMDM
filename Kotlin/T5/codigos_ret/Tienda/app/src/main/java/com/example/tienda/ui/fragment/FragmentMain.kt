package com.example.tienda.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tienda.databinding.FragmentLoginBinding
import com.example.tienda.databinding.FragmentMainBinding
import com.example.tienda.databinding.FragmentRegisterBinding
import com.example.tienda.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson

class FragmentMain : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var user: FirebaseUser
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase

    override fun onAttach(context: Context) {
        super.onAttach(context)
        auth = FirebaseAuth.getInstance()
        user = auth.currentUser!!
        database =
            FirebaseDatabase.getInstance("https://bmh2526-ret-default-rtdb.europe-west1.firebasedatabase.app/")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val gson = Gson()
        database.reference.child("usuarios")
            .child(auth.currentUser!!.uid)
            .get().addOnCompleteListener {
                Log.v("consulta", it.getResult().toString())
                val user: User = gson.fromJson(it.getResult().toString(), User::class.java)
                binding.textoMain.text = user.nombre
            }
        binding.btnBorrar.setOnClickListener {
            database.reference.child("usuarios")
                .child(auth.currentUser!!.uid).setValue(null)
        }
        // database.reference.child("uLogin").setValue(user.uid)
        // binding.textoMain.text = user.uid
    }

}

/*
{
  "rules": {
    ".read": "now < 1773270000000",
    ".write": "now < 1773270000000",

  }
}
 */