package com.crepass.viewpagertest

import android.database.DatabaseUtils
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.crepass.viewpagertest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val fragmentList = listOf(FirstFragment(),SecondFragment(),ThirdFragment())
        val adapter = ViewPagerAdapter(this, fragmentList)

        binding.viewPager.adapter = adapter

        binding.dotsIndicator.attachTo(binding.viewPager)

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.d("tat",position.toString())
                when (position) {
                    0 -> binding.pageNum.text = "first page"
                    1 -> binding.pageNum.text = "second page"
                    2 -> binding.pageNum.text = "third page"
                }
            }
        })
        binding.apply {
            leftButton.setOnClickListener {
                val currentItem = viewPager.currentItem
                if(currentItem> 0 ){
                    viewPager.currentItem = currentItem -1
                }
            }
            rightButton.setOnClickListener {
                val currentItem = viewPager.currentItem
                if (currentItem < fragmentList.size - 1) {
                    viewPager.currentItem = currentItem + 1
                }
            }
        }

    }
}