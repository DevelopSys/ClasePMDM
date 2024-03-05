package com.example.t7_sqlite.ui.fragments

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.t7_sqlite.R
import com.example.t7_sqlite.database.DBHelper
import com.example.t7_sqlite.database.SchemeDB
import com.example.t7_sqlite.databinding.FragmentLoginBinding

class LoginFragment : Fragment(){

    private lateinit var binding: FragmentLoginBinding
    private lateinit var helper: DBHelper
    private lateinit var database: SQLiteDatabase

    override fun onAttach(context: Context) {
        super.onAttach(context)
        helper =  DBHelper(context, SchemeDB.DB_NAME,null, SchemeDB.DB_VERSION)
        database = helper.writableDatabase
        /*
        STATEMENT
        database.execSQL("INSERT INTO ${SchemeDB.TAB_USUARIOS}" +
                " (${SchemeDB.COL_NOMBRE}, ${SchemeDB.COL_CORREO}, ${SchemeDB.COL_PASS}, ${SchemeDB.COL_TELEFONO})" +
                " VALUES ('Borja','borja@gmail.com','Retamar1a',123456)")*/

        /*val content = ContentValues()
        content.put(SchemeDB.COL_NOMBRE,"Borja")
        content.put(SchemeDB.COL_CORREO,"borja@gmail.com")
        content.put(SchemeDB.COL_TELEFONO,123456)
        content.put(SchemeDB.COL_PASS,"Retamar1a")
        database.insert(SchemeDB.TAB_USUARIOS,null,content)*/
        database.close()

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.botonRegistrar.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }
    }
}