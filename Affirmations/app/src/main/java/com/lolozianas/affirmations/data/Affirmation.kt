package com.lolozianas.affirmations.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(@StringRes val stringResId: Int, @DrawableRes val imageResId: Int)