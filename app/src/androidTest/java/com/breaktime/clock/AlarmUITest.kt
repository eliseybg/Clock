package com.breaktime.clock

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.breaktime.clock.data.AlarmEntity
import com.breaktime.clock.presentation.screens.TopAppBarContent
import com.breaktime.clock.presentation.screens.alarm.AlarmFragment
import com.breaktime.clock.presentation.screens.alarm.AlarmItem
import com.breaktime.clock.ui.theme.ClockTheme

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import java.util.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class AlarmUITest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.breaktime.clock", appContext.packageName)
    }

    @Test
    fun testAlarmAppBar() {
        val title = "Alarm"
        composeTestRule.setContent {
            ClockTheme {
                TopAppBarContent(title)
            }
        }
        composeTestRule.onRoot().printToLog("TAG:")
        composeTestRule.onNodeWithText(title).assertIsDisplayed()
    }

    @Test
    fun testMenuAppBar() {
        val title = "Alarm"
        composeTestRule.setContent {
            ClockTheme {
                TopAppBarContent(title)
            }
        }
        composeTestRule.onRoot().printToLog("TAG:")
        composeTestRule.onNodeWithContentDescription("Localized description").performClick()
        composeTestRule.onNodeWithText("Screensaver").assertIsDisplayed()
        composeTestRule.onNodeWithText("Settings").assertIsDisplayed()
        composeTestRule.onNodeWithText("Send feedback").assertIsDisplayed()
        composeTestRule.onNodeWithText("Help").assertIsDisplayed()
    }

    @ExperimentalMaterialApi
    @Test
    fun testAlarmAddButton() {
        composeTestRule.setContent {
            ClockTheme {
                AlarmFragment()
            }
        }
        composeTestRule.onRoot().printToLog("TAG:")
        composeTestRule.onNodeWithContentDescription("Add alarm").assertHasClickAction()
    }

    @ExperimentalMaterialApi
    @Test
    fun testAlarmItemDropDown() {
        composeTestRule.setContent {
            ClockTheme {
                AlarmItem(AlarmEntity(alarmTime = 3 to 25))
            }
        }
        composeTestRule.onRoot().printToLog("TAG:")
        composeTestRule.onNodeWithContentDescription("Drop-Down arrow").assertHasClickAction()
    }

    @ExperimentalMaterialApi
    @Test
    fun testAlarmItemSelectTime() {
        composeTestRule.setContent {
            ClockTheme {
                AlarmItem(AlarmEntity(alarmTime = 3 to 25))
            }
        }
        composeTestRule.onRoot().printToLog("TAG:")
        composeTestRule.onNodeWithContentDescription("Drop-Down arrow").performClick()
        composeTestRule.onRoot().onChildAt(0).onChildAt(5).assertHasClickAction()
    }

    @ExperimentalMaterialApi
    @Test
    fun testAlarmItemDismiss() {
        composeTestRule.setContent {
            ClockTheme {
                AlarmItem(AlarmEntity(alarmTime = 3 to 25))
            }
        }
        composeTestRule.onRoot().printToLog("TAG:")
        composeTestRule.onNodeWithContentDescription("Drop-Down arrow").performClick()
        composeTestRule.onRoot().onChildAt(0).onChildAt(11).assertHasClickAction()

    }

    @ExperimentalMaterialApi
    @Test
    fun testAlarmItemActivate() {
        composeTestRule.setContent {
            ClockTheme {
                AlarmItem(AlarmEntity(alarmTime = 3 to 25))
            }
        }
        composeTestRule.onRoot().printToLog("TAG:")
        composeTestRule.onNodeWithContentDescription("Drop-Down arrow").performClick()
        composeTestRule.onRoot().onChildAt(0).onChildAt(10).assertHasClickAction()
    }

    @ExperimentalMaterialApi
    @Test
    fun testAlarmItemLabel() {
        composeTestRule.setContent {
            ClockTheme {
                AlarmItem(AlarmEntity(alarmTime = 3 to 25))
            }
        }
        composeTestRule.onRoot().printToLog("TAG:")
        composeTestRule.onNodeWithContentDescription("Drop-Down arrow").performClick()
        composeTestRule.onNodeWithContentDescription("label icon").assertIsDisplayed()
    }

    @ExperimentalMaterialApi
    @Test
    fun testAlarmItemDaySelector() {
        composeTestRule.setContent {
            ClockTheme {
                AlarmItem(AlarmEntity(alarmTime = 3 to 25))
            }
        }
        composeTestRule.onNodeWithContentDescription("Drop-Down arrow").performClick()
        composeTestRule.onRoot().printToLog("TAG:")
        composeTestRule.onRoot().onChildAt(0).onChildAt(4).assertTextEquals("M")
        composeTestRule.onRoot().onChildAt(0).onChildAt(5).assertTextEquals("T")
        composeTestRule.onRoot().onChildAt(0).onChildAt(6).assertTextEquals("W")
        composeTestRule.onRoot().onChildAt(0).onChildAt(7).assertTextEquals("T")
        composeTestRule.onRoot().onChildAt(0).onChildAt(8).assertTextEquals("F")
        composeTestRule.onRoot().onChildAt(0).onChildAt(9).assertTextEquals("S")
        composeTestRule.onRoot().onChildAt(0).onChildAt(10).assertTextEquals("S")
    }

    @ExperimentalMaterialApi
    @Test
    fun testAlarmItemSound() {
        composeTestRule.setContent {
            ClockTheme {
                AlarmItem(AlarmEntity(alarmTime = 3 to 25))
            }
        }
        composeTestRule.onRoot().printToLog("TAG:")
        composeTestRule.onNodeWithContentDescription("Drop-Down arrow").performClick()
        composeTestRule.onRoot().onChildAt(0).onChildAt(11).assertHasClickAction()
    }

    @ExperimentalMaterialApi
    @Test
    fun testAlarmItemVibrate() {
        composeTestRule.setContent {
            ClockTheme {
                AlarmItem(AlarmEntity(alarmTime = 3 to 25))
            }
        }
        composeTestRule.onRoot().printToLog("TAG:")
        composeTestRule.onNodeWithContentDescription("Drop-Down arrow").performClick()
        composeTestRule.onRoot().onChildAt(0).onChildAt(12).assertTextEquals("Vibrate")
    }

    @ExperimentalMaterialApi
    @Test
    fun testAlarmItemGoogleAssistant() {
        composeTestRule.setContent {
            ClockTheme {
                AlarmItem(AlarmEntity(alarmTime = 3 to 25))
            }
        }
        composeTestRule.onRoot().printToLog("TAG:")
        composeTestRule.onNodeWithContentDescription("Drop-Down arrow").performClick()
        composeTestRule.onRoot().onChildAt(0).onChildAt(13).assertHasClickAction()
    }

    @ExperimentalMaterialApi
    @Test
    fun testAlarmItemDelete() {
        composeTestRule.setContent {
            ClockTheme {
                AlarmItem(AlarmEntity(alarmTime = 3 to 25))
            }
        }
        composeTestRule.onRoot().printToLog("TAG:")
        composeTestRule.onNodeWithContentDescription("Drop-Down arrow").performClick()
        composeTestRule.onRoot().onChildAt(0).onChildAt(14).assertHasClickAction()
    }

    @ExperimentalMaterialApi
    @Test
    fun testAlarmItemChangeShowDay() {
        composeTestRule.setContent {
            ClockTheme {
                AlarmItem(AlarmEntity(alarmTime = 3 to 25))
            }
        }
        composeTestRule.onRoot().printToLog("TAG:")
        composeTestRule.onNodeWithContentDescription("Drop-Down arrow").performClick()
        composeTestRule.onRoot().onChildAt(0).onChildAt(4).assertHasClickAction()
        composeTestRule.onRoot().onChildAt(0).onChildAt(5).assertHasClickAction()
        composeTestRule.onRoot().onChildAt(0).onChildAt(6).assertHasClickAction()
        composeTestRule.onRoot().onChildAt(0).onChildAt(7).assertHasClickAction()
        composeTestRule.onRoot().onChildAt(0).onChildAt(8).assertHasClickAction()
        composeTestRule.onRoot().onChildAt(0).onChildAt(9).assertHasClickAction()
        composeTestRule.onRoot().onChildAt(0).onChildAt(10).assertHasClickAction()
    }
}