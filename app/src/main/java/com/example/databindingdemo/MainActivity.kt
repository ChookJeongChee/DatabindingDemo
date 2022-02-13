package com.example.databindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databindingdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) //pointing to the whole main

        val myData: Student = Student("Brian", "2105252")
        binding.myData = myData

        //binding.tvID.text = "W123456"
        binding.btnUpdate.setOnClickListener(){

            myData.studentName = "Alex"

            binding.apply {
                //fresh everything
                invalidateAll()
            }
        }

        //val tv : TextView = findviewbyId(R.id.tvName)
    }
}