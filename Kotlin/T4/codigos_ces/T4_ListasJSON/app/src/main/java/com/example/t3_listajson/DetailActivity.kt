package com.example.t3_listajson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.t3_listajson.databinding.ActivityDetailBinding
import com.example.t3_listajson.model.User

class DetailActivity : AppCompatActivity() {

    private lateinit var user: User
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        user = intent.extras!!.getSerializable("usueario") as User
    }
}