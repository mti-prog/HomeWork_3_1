package com.geeks.homework_3_1.data.local.pref

import android.content.Context
import android.content.SharedPreferences
import com.geeks.homework_3_1.data.keys.Keys

class onBoardSharedPreferences(context : Context) {
    private val pref : SharedPreferences = context.getSharedPreferences(Keys.PREF, Context.MODE_PRIVATE)

    fun notEntered(): Boolean{
        return pref.getBoolean(Keys.ENTERED, true)
    }

    fun entered() {
        pref.edit().putBoolean(Keys.ENTERED, false).apply()
    }
}