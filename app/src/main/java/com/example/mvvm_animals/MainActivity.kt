package com.example.mvvm_animals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgView: ImageView = findViewById(R.id.imgView)
        val duckButton: Button = findViewById(R.id.duckButton)
        val dogButton: Button = findViewById(R.id.dogButton)
        val catButton: Button = findViewById(R.id.catButton)

        val vm = ViewModelProvider(this).get(MainViewModel::class.java)

        vm.liveData.observe(this, {
            Picasso.get().load(it).into(imgView);
        })

        vm.erorLiveData.observe(this, {
            Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT).show()
        })

        duckButton.setOnClickListener{
            vm.getDuck()
        }

        dogButton.setOnClickListener {
            vm.getDuck()
        }

        catButton.setOnClickListener{
            vm.getCat()
        }
    }
}