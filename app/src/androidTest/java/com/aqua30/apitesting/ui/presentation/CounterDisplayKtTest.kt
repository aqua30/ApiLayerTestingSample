package com.aqua30.apitesting.ui.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.aqua30.apitesting.ui.theme.ApiTestingTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Saurabh
 */
@RunWith(AndroidJUnit4::class)  // To indicate that we've to run it with AndroidJUnit runner
class CounterDisplayKtTest {

    @get: Rule
    val composeTestRule = createComposeRule()   // compose rule is required to get access to the composable component

    @Before
    fun setUp() {
        composeTestRule.setContent {    // setting our composable as content for test
            ApiTestingTheme {
                CounterDisplay(modifier = Modifier.fillMaxSize().background(Color.Black))
            }
        }
    }

    @Test
    fun verify_if_all_views_exists() {
        composeTestRule.onNodeWithTag("Counter Display").assertExists()
        composeTestRule.onNodeWithTag("Input").assertExists()
        composeTestRule.onNodeWithText("Copy").assertExists()
    }

    @Test
    fun counterValue_with_emptyInput_displays_InvalidEntry() {
        // mimic if the user clicked on the button
        composeTestRule.onNodeWithText("Copy").performClick()
        // mimic if the user is shown the desired text on UI
        composeTestRule.onNodeWithTag("Counter Display").assertTextEquals("Invalid entry")
    }

    @Test
    fun withInput_as_1_onButtonClick_displayOnTop() {
        // mimic the user inputting the text
        composeTestRule.onNodeWithTag("Input").performTextInput("1")
        // mimic if the user clicked on the button
        composeTestRule.onNodeWithText("Copy").performClick()
        // mimic if the user is shown the desired text on UI
        composeTestRule.onNodeWithTag("Counter Display").assertTextContains("Counter = 1")
    }

    @Test
    fun withInput_as_2_onButtonClick_displayOnTop() {
        // mimic the user inputting the text
        composeTestRule.onNodeWithTag("Input").performTextInput("2")
        // mimic if the user clicked on the button
        composeTestRule.onNodeWithText("Copy").performClick()
        // mimic if the user is shown the desired text on UI
        composeTestRule.onNodeWithTag("Counter Display").assertTextContains("Counter = 2")
    }

    @Test
    fun withInput_123abc__return_InvalidEntry_onButtonClick() {
        // mimic the user inputting the text
        composeTestRule.onNodeWithTag("Input").performTextInput("123abc")
        // mimic if the user clicked on the button
        composeTestRule.onNodeWithText("Copy").performClick()
        // mimic if the user is shown the desired text on UI
        composeTestRule.onNodeWithTag("Counter Display").assertTextContains("Invalid entry")
    }

}