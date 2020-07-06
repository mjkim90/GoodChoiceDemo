package com.example.goodchoicedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentList = listOf(HomeFragment(), BookMarkFragment())

        val fragmentAdapter = ViewPagerAdapter(fragmentList, this@MainActivity)
        viewpager.offscreenPageLimit = 2
        viewpager.adapter = fragmentAdapter

        val tabList = listOf(getString(R.string.tab_home), getString(R.string.tab_bookmark))

        TabLayoutMediator(tablayout, viewpager) { tab, position ->
            tab.text = tabList[position]
        }.attach()
    }
}