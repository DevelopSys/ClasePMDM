package com.develop.t3_spinner_ret

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.develop.t3_spinner_ret.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }
}