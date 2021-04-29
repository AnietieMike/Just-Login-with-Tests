package com.decagon.anietie.justlogin

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class RegisterInstrumentedTest {

    companion object {
        const val  NAME = "Anietie Udoaka"
        const val PHONE = "08104690512"
        const val EMAIL = "anietieudoaka@gmail.com"
        const val GENDER = "Male"
        const val PASSWORD = "anietie"

    }

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun registerTitleIsDisplayed() {
        onView(withId(R.id.tv_logo)).check(matches(isDisplayed()))
    }

    @Test
    fun registerFullNameEditTextIsDisplayed() {
        onView(withId(R.id.et_full_name)).check(matches(isDisplayed()))
    }

    @Test
    fun registerSpinnerIsDisplayed() {
        onView(withId(R.id.spinner_gender)).check(matches(isDisplayed()))
    }

    @Test
    fun registerButtonIsDisplayed() {
        onView(withId(R.id.btn_register)).check(matches(isDisplayed()))
    }

    @Test
    fun testNavigation_toDisplayActivity() {
        onView(withId(R.id.et_full_name)).perform(typeText(NAME))
        onView(withId(R.id.et_phone_number)).perform(typeText(PHONE))
        onView(withId(R.id.et_email)).perform(swipeUp(), typeText(EMAIL))
        onView(withId(R.id.spinner_gender)).perform(swipeUp(), click())
        onView(withText(GENDER)).perform(swipeUp(), click())
        onView(withId(R.id.et_password)).perform(swipeUp(), typeText(PASSWORD))
        onView(withId(R.id.et_repassword)).perform(swipeUp(), typeText(PASSWORD))
        onView(withId(R.id.btn_register)).perform(swipeUp(), click())
        onView(withId(R.id.display_activity)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_fullname)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_email)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_phone)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_gender)).check(matches(isDisplayed()))
    }

}

