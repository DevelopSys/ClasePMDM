package com.example.t3_listaproductos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.t3_listaproductos.model.Producto

class CestaActivity : AppCompatActivity() {

    private lateinit var cesta: ArrayList<Producto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cesta)
        cesta = intent.getParcelableArrayListExtra("lista")!!
        Log.v("datos",cesta.size.toString())
    }
}