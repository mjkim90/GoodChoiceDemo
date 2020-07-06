package com.example.goodchoicedemo.model


import com.google.gson.annotations.SerializedName

class ProductListModel {
    @SerializedName("totalCount")
    val totalCount = 0

    @SerializedName("product")
    val productList = ArrayList<ProductModel>()
}
