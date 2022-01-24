package com.lolozianas.dogglersapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.lolozianas.dogglersapp.data.DataSource

class BaseTests {

    val lastPosition = DataSource.dogs.size - 1

    /**
     * Check the content of a card
     *
     * @param name
     * @param age The full age string as it appears on the screen
     * @param hobbies The full hobbies string as it appears on the screen
     * @param imageResource The image resource Id
     */

    private fun hasListItemContent(name: String, age: String, hobbies: String, imageResource: Int) {
        onView(withText(name)).check(matches(isDisplayed()))
        onView(withText(age)).check(matches(isDisplayed()))
        onView(withText(hobbies)).check(matches(isDisplayed()))
        onView(withText(imageResource)).check(matches(isDisplayed()))
    }

    /**
     * Check the content of the first card
     * */
    fun checkFirstPosition() {
        hasListItemContent("Messi", "7", "Hobbies: sunbathing", R.drawable.messi)
    }
}