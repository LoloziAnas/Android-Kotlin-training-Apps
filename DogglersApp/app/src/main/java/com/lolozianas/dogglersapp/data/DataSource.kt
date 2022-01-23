package com.lolozianas.dogglersapp.data

import com.lolozianas.dogglersapp.R
import com.lolozianas.dogglersapp.model.Dog

object DataSource {

    val dogs: List<Dog> = listOf(
        Dog(
            R.drawable.messi,
            "Messi",
            "7",
            "sunbathing"
        ),
        Dog(
            R.drawable.leroy,
            "Leroy",
            "4",
            "sleeping in dangerous places"
        ),
        Dog(
            R.drawable.frankie,
            "Frankie",
            "2",
            "stealing socks"
        ),
        Dog(
            R.drawable.nox,
            "Nox",
            "8",
            "meeting new animals"
        ),
        Dog(
            R.drawable.faye,
            "Faye",
            "8",
            "Digging in the garden"
        ),
        Dog(
            R.drawable.bella,
            "Bella",
            "14",
            "Chasing sea foam"
        )
    )
}