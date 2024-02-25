package com.example.exercise3.utils

import android.content.Context
import android.media.MediaPlayer
import com.example.exercise3.model.ButtonList

object Music {
    private val audioMap = mapOf(
        1 to ButtonList.BUTTON1.audio,
        2 to ButtonList.BUTTON2.audio,
        3 to ButtonList.BUTTON3.audio,
        4 to ButtonList.BUTTON4.audio
    )
    fun playAudio(context: Context, number: Int) {
        val resId = audioMap[number] ?: return
        MediaPlayer.create(context, resId).start()
    }
}