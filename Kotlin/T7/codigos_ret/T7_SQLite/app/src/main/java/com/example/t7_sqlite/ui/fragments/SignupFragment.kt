package com.example.t7_sqlite.ui.fragments

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.t7_sqlite.database.DBHelper
import com.example.t7_sqlite.database.SchemeDB
import com.example.t7_sqlite.databinding.FragmentLoginBinding
import com.example.t7_sqlite.databinding.FragmentSignupBinding

class SignupFragment : Fragment() {

    private lateinit var binding: FragmentSignupBinding
    private lateinit var openHelper: DBHelper
    private lateinit var database: SQLiteDatabase

    override fun onAttach(context: Context) {
        super.onAttach(context)
        openHelper = DBHelper(context, SchemeDB.DB_NAME, null, SchemeDB.DB_VERSION)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.botonRegistrar.setOnClickListener {
            // db
            database = openHelper.writableDatabase
            database.execSQL(
                "INSERT INTO ${SchemeDB.TAB_USUARIOS}" +
                        " (${SchemeDB.COL_NOMBRE}, ${SchemeDB.COL_CORREO}, ${SchemeDB.COL_PASS}, ${SchemeDB.COL_TELEFONO})" +
                        " VALUES ('${binding.editNombre.text.toString()}','${binding.editCorreo.text.toString()}', '${binding.editPass.text.toString()}', '${
                            binding.editTelefono.text.toString().toInt()
                        }')"
            )
            database.close()
        }
    }
}