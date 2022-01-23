package com.lolozianas.tiptime

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.Matchers.containsString
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

/**
 * Instrumentation tests require an InstrumentationTestRunner, which allows the test to execute
 * on the device or emulator. There are several other instrumentation runners, but for this test
 * we'll use the AndroidJUnit4 runner.
* */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.lolozianas.tiptime", appContext.packageName)
    }

    /**
     * the app has one activity an in order to interact with it, your test case must first lunch it.
     *
     * */
    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_20_percent_tip(){
        onView(withId(R.id.text_input_cost_of_service))
            .perform(typeText("50.00"))
        onView(withId(R.id.rb_amazing)
        onView(withId(R.id.btn_calculate))
            .perform(click())
        onView(withId(R.id.tv_tip_amount))
            .check(matches(withText(containsString("$10.00"))))

    }
    /**
     * Espresso Library, its a library for instrumentation tests.
     * a library that comes ready to use with an android project when created with android studio.
     * and let's you interact with UI components through code.
     * */

    @Test
    fun calculate_default_tip(){
        onView(withId(R.id.text_input_cost_of_service))
            .perform(typeText("50.00"))
        onView(withId(R.id.btn_calculate))
            .perform(click())
        onView(withId(R.id.tv_tip_amount))
            .check(matches(withText(containsString("$10.00"))))

    }
}