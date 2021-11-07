package com.example.mvvm_animals

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgView: ImageView = findViewById(R.id.imgView)
        val duckButton: Button = findViewById(R.id.duckButton)
        val dogButton: Button = findViewById(R.id.dogButton)
        val catButton: Button = findViewById(R.id.catButton)

        val vm = ViewModelProvider(this)[MainViewModel::class.java]

        vm.imagesLiveData.observe(this, {
//            Picasso.get().load(it).into(imgView);
            imgView.loadGifOrImage(this, it)
        })

        vm.errorMessageLiveData.observe(this, {
            Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
        })

        duckButton.setOnClickListener{
            vm.getDuck()
        }

        dogButton.setOnClickListener {
            vm.getDog()
        }

        catButton.setOnClickListener{
            vm.getCat()
        }
    }
}