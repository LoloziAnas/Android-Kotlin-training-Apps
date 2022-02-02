package com.lolozianas.wordsapp

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTests {

    @Test
    fun navigate_to_words_nav_component() {
        // Create an instance of the navigation controller
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        // Equivalent of ActivityScenarioRule
        val letterListScenario =
            launchFragmentInContainer<LetterListFragment>(themeResId = R.style.Theme_WordsApp)
        // Lastly, we need to explicitly declare which
        // navigation graph we want the nav controller to use for the fragment launched
        letterListScenario.onFragment { fragment ->
            navController.setGraph(R.navigation.nav_graph)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        //Now trigger the event that prompts the navigation.
        onView(withId(R.id.recycler_view)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                2,
                click()
            )
        )
        assertEquals(navController.currentDestination?.id, R.id.wordListFragment)
    }
}