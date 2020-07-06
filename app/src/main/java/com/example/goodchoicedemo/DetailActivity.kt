package com.example.goodchoicedemo

import android.app.Activity
import android.content.Intent
import android.media.Image
import android.os.Bundle
import com.example.goodchoicedemo.util.ImageUtil
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : Activity() {

    private var name = ""
    private var rate = ""
    private var imageUrl = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        name = intent.getStringExtra("name") ?: ""
        rate = intent.getFloatExtra("rate",0f).toString()
        imageUrl = intent.getStringExtra("imageUrl") ?: ""

        txt_name.text = name
        rating.rating = rate.toFloat()
        ImageUtil.loadImage(this, imageUrl, img_thumbnail)
    }

    companion object {
        fun startActivity(activity: Activity, name: String, rate: Float, imageUrl: String) {
            activity.startActivity(Intent(activity, DetailActivity::class.java).apply {
                putExtra("name", name)
                putExtra("rate", rate)
                putExtra("imageUrl", imageUrl)
            })
        }
    }
}
