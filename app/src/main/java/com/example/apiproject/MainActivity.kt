package com.example.apiproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.apiproject.databinding.ActivityMainBinding
import com.example.apiproject.repository.Repository
import com.example.apiproject.ui.DetailActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
       binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        binding.root


        val repository=Repository()

        val viewModelFactory=MainViewModelFactory(repository)
        viewModel= ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)



       binding.horos1.setOnClickListener {
           viewModel.getPost("virgo", "today")
           viewModel.myResponse2.observe(this, Observer { response ->

               if (response.isSuccessful) {
                   textView.text = response.body().toString()

                     val intenet = Intent(this,DetailActivity::class.java)
                      startActivity(intenet)

               } else {
                    Toast.makeText(applicationContext, "No Data ", Toast.LENGTH_SHORT).show() }



           })


       }
}}