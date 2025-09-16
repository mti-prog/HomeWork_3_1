package com.geeks.homework_3_1.data.model

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

@SuppressLint("ParcelCreator")
data class CarModel(
    val name : String,
    val price : String,
    val img : String,
    val carType : String,
    val set: String,
    val snowflake : String
) : Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        TODO("Not yet implemented")
    }

}