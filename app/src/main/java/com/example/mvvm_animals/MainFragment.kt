package com.example.mvvm_animals

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class MainFragment : Fragment(R.layout.fragment_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imgView: ImageView = view.findViewById(R.id.imgView)
        val duckButton: Button = view.findViewById(R.id.duckButton)
        val dogButton: Button = view.findViewById(R.id.dogButton)
        val catButton: Button = view.findViewById(R.id.catButton)

        val vm = ViewModelProvider(this)[MainViewModel::class.java]

        vm.imagesLiveData.observe(viewLifecycleOwner, {
            imgView.loadGifOrImage(requireContext(), it)
        })

        vm.errorMessageLiveData.observe(viewLifecycleOwner, {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
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