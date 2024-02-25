package com.example.exercise3.model

import android.content.Context
import android.content.SharedPreferences

class SharedPrefManager(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE)

    fun saveBestLevel(bestLevel: Int) {
        with(sharedPreferences.edit()) {
            putInt("bestLevel", bestLevel)
            apply()
        }
    }

    fun getBestLevel(): Int {
        return sharedPreferences.getInt("bestLevel", 0)
    }
}