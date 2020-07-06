package com.example.goodchoicedemo.model

import com.google.gson.annotations.SerializedName

class ResProductListModel {
    @SerializedName("code")
    val code = 0

    @SerializedName("msg")
    val message = ""

    @SerializedName("data")
    val data = ProductListModel()
}