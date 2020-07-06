package com.example.goodchoicedemo.model

import android.os.Parcelable
import com.example.goodchoicedemo.model.DescriptionModel
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


class ProductModel {
    @SerializedName("id")
    val id = ""

    @SerializedName("name")
    val name = ""

    @SerializedName("thumbnail")
    val thumbnail = ""

    @SerializedName("description")
    val descriptionModel = DescriptionModel()

    @SerializedName("rate")
    val rate = 0.toFloat()
}
