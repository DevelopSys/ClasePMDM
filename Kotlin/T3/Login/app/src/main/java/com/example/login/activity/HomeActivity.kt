package com.example.login.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.login.adapter.ProductAdapter
import com.example.login.databinding.ActivityHomeBinding
import com.example.login.dataset.DataSet

class HomeActivity : AppCompatActivity() {


    private lateinit var binding: ActivityHomeBinding
    private var currentUserName: String? = null
    private lateinit var adatperProduct: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        DataSet.initList()
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instances()
        initGUI()
        actions()
        currentUserName = intent.getStringExtra("user_name")
        binding.textUser.text = "Bienvenido ${currentUserName ?: "Invitado"}"

    }

    private fun actions() {

    }

    private fun initGUI() {
        binding.recyclerProductos.adapter = adatperProduct
        // 1 -> port
        // 2 -> land
        // 3 -> square -> table
        if (resources.configuration.orientation == 1){
            binding.recyclerProductos.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        } else {
            binding.recyclerProductos.layoutManager =
                GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, true)
        }


        //LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun instances() {
        // no pongas applicationContext -> this
        adatperProduct = ProductAdapter(DataSet.listProduct, this)
    }
}