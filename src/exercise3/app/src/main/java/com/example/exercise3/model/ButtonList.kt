package com.example.exercise3.model

import com.example.exercise3.R

enum class ButtonList(val number: Int, val color: Int, val audio: Int) {
    BUTTON1(1, R.color.button1, R.raw.knopkasignal),
    BUTTON2(2, R.color.button2, R.raw.zvuk_slomannogo_apparata),
    BUTTON3(3, R.color.button3, R.raw.eject_text),
    BUTTON4(4, R.color.button4, R.raw.povorotnymehanizm)
}