package com.example.concesionario.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.concesionario.R
import com.example.concesionario.data.DataSet
import com.example.concesionario.databinding.ActivityDetailBinding
import com.example.concesionario.databinding.ItemCardBinding
import com.example.concesionario.model.Marca
import com.example.concesionario.model.Model
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var model: Model;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
    }

    private fun getData() {
        model = intent.getSerializableExtra("model") as Model
        binding.textModel.text = model.name
        binding.textPrice.text = model.price.toString()
        binding.txtCV.text = model.cv.toString()
        Picasso.get().load(model.image).into(binding.image)

        val marca: Marca? = DataSet.listMarca.find {
            it.name.equals(model.marca, true)
        }
        Log.v("data", marca.toString())
        binding.imageMarca.setImageResource(marca!!.logo)
        binding.textMara.text = marca.name
        // binding.imageMarca.setImageDrawable(resources.getDrawable(marca!!.logo))

    }
}