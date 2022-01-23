package com.lolozianas.dogglersapp.model

import androidx.annotation.DrawableRes

data class Dog(
    @DrawableRes val imageResId: Int,
    val name: String,
    val age: String,
    val hobbies: String
)