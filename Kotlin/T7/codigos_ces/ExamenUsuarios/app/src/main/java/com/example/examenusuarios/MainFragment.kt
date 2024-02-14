package com.example.examenusuarios

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.examenusuarios.adaptadores.RecyclerAdatpter
import com.example.examenusuarios.databinding.FragmentMainBinding
import com.example.examenusuarios.model.Element
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private lateinit var database: FirebaseDatabase
    private lateinit var uid: String
    private lateinit var perfil: String
    private var numeroVeces: Int = 0

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var adatpter: RecyclerAdatpter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        adatpter = RecyclerAdatpter(context, ArrayList())
        uid = arguments?.getString("uid")!!
        database =
            FirebaseDatabase.getInstance("https://bmh-ces-default-rtdb.europe-west1.firebasedatabase.app/")

        database.getReference("usuarios").child(uid).child("perfil")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    perfil = snapshot.value.toString()
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })

        database.getReference("usuarios").child(uid).child("numeroVeces")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    numeroVeces = snapshot.value.toString().toInt()
                    database.getReference("usuarios").child(uid).child("numeroVeces")
                        .setValue(numeroVeces + 1)
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (perfil.equals("Administrador")){
            database.getReference("usuarios").addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    snapshot.children.forEach {
                        var elemento: Element = it.getValue(Element::class.java) as Element
                        adatpter.addElement(elemento)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        } else {
            database.getReference("post").addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    snapshot.children.forEach {
                        var elemento: Element = it.getValue(Element::class.java) as Element
                        adatpter.addElement(elemento)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}