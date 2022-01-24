package com.lolozianas.dogglersapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class GridListTests {

    @get:Rule
    var activity: ActivityScenarioRule<GridListActivity> =
        ActivityScenarioRule(GridListActivity::class.java)


    @Test
    fun grid_list_content_at_first_position() {
        BaseTests().checkFirstPosition()
    }

    @Test
    fun vertical_scrolling() {
        onView(withId(R.id.rv_grid)).perform(swipeUp())
        onView(withText("Bella")).check(matches(isDisplayed()))
    }

    @Test
    fun recycler_view_item_count() {

        //onView(withId(R.id.rv_grid)).check(RecyclerViewAssertion(9))
    }
}