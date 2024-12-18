package com.example.bai3bottomnav

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.bai3bottomnav.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val myViewModel: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(DivisionFragment())
        binding.bnvMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.division -> {
                    replaceFragment(DivisionFragment())
                    true
                }
                R.id.multiplication -> {
                    replaceFragment(MultiplicationFragment())
                    true
                }
                R.id.square -> {
                    replaceFragment(SquareFragment())
                    true
                }
                else -> {
                    true
                }
            }
        }
        binding.btResult.setOnClickListener {
            myViewModel.number = binding.etNumber.text.toString()
            replaceFragment(DivisionFragment())
        }
    }
    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_main, fragment)
            .commit()
    }
}