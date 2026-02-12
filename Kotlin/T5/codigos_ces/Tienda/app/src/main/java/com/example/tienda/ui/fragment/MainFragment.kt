package com.example.tienda.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tienda.adapter.AdapterUserRecycler
import com.example.tienda.databinding.FragmentMainBinding
import com.example.tienda.databinding.FragmentRegistroBinding
import com.example.tienda.databinding.FramentLoginBinding
import com.example.tienda.model.Product
import com.example.tienda.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.gson.Gson

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var uid: String
    private lateinit var adapterUserRecycler: AdapterUserRecycler

    override fun onAttach(context: Context) {
        super.onAttach(context)
        adapterUserRecycler = AdapterUserRecycler(context)
        auth = FirebaseAuth.getInstance()
        uid = auth.currentUser!!.uid
        database =
            FirebaseDatabase.getInstance("https://bmhces2526-default-rtdb.europe-west1.firebasedatabase.app/")
        // database.reference.child("usuarioLogeado")
        //     .setValue(User("Borja","Martin","borja@gmail.com","123123",30))

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
        binding.recyclerUsuarios.adapter = adapterUserRecycler
        binding.recyclerUsuarios.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL, false
        )

        val gson = Gson()

        database.reference.child("usuarios")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (i in snapshot.children) {
                        val user: User = i.getValue(User::class.java) as User
                        adapterUserRecycler.addUser(user)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })

        /*

                    .addChildEventListener(object : ChildEventListener {
                        override fun onChildAdded(
                            snapshot: DataSnapshot,
                            previousChildName: String?
                        ) {

                            // val producto: Product = gson.fromJson(snapshot.value.toString(), Product::class.java)
                            // Log.v("consulta", producto.title.toString())
                            val usuario: User = gson.fromJson(snapshot.value.toString(), User::class.java)
                            adapterUserRecycler.addUser(usuario)
                            Log.v("consulta", usuario.nombre.toString())
                        }

                        override fun onChildChanged(
                            snapshot: DataSnapshot,
                            previousChildName: String?
                        ) {
                        }

                        override fun onChildRemoved(snapshot: DataSnapshot) {
                        }

                        override fun onChildMoved(
                            snapshot: DataSnapshot,
                            previousChildName: String?
                        ) {
                        }

                        override fun onCancelled(error: DatabaseError) {
                        }

                    })
        */
        //

        /*
        database.reference.child("usuarios")
            .child(uid)
            .addChildEventListener(object : ChildEventListener{
                override fun onChildAdded(
                    snapshot: DataSnapshot,
                    previousChildName: String?
                ) {
                    Log.v("datos", "Añadido "+snapshot.toString())                }

                override fun onChildChanged(
                    snapshot: DataSnapshot,
                    previousChildName: String?
                ) {
                    Log.v("datos", "Cambiado "+snapshot.toString())
                }

                override fun onChildRemoved(snapshot: DataSnapshot) {
                    Log.v("datos", "Borrado "+snapshot.toString())
                }

                override fun onChildMoved(
                    snapshot: DataSnapshot,
                    previousChildName: String?
                ) {
                    Log.v("datos", "Movido "+snapshot.toString())
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
            /*.addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    binding.textNombreMain.text ="Bienvenido/a ${snapshot.value}"
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })*/
            /*.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    binding.textNombreMain.text ="Bienvenido/a ${snapshot.value}"
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })*/
*/
        // binding.textNombreMain.text = uid
        binding.guardarDatos.setOnClickListener {
            val referencia = database.reference.child("nombreAPP")
            referencia.setValue("App Firebase")
        }

        binding.elimiarDatos.setOnClickListener {
            database.reference.child("usuarios")
                .child(uid).setValue(null)
        }
    }

}