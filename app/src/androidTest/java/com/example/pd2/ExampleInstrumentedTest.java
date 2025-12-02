package com.example.pd2;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.pd2", appContext.getPackageName());
    }

    @Test
    public void testCharacterCount() {
        // Type text
        onView(withId(R.id.edUserInput))
                .perform(replaceText("12345"), closeSoftKeyboard());

        // Select "Number of characters" from Spinner
        onView(withId(R.id.spSelectionOp)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Number of characters"))).perform(click());

        // Click Count button
        onView(withId(R.id.button)).perform(click());

        // Check result
        onView(withId(R.id.tvCountResult)).check(matches(withText("5")));
    }

    @Test
    public void testWordCount() {
        // Type text
        onView(withId(R.id.edUserInput))
                .perform(replaceText("Hello world"), closeSoftKeyboard());

        // Select "Number of words" from Spinner
        onView(withId(R.id.spSelectionOp)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Number of words"))).perform(click());

        // Click Count button
        onView(withId(R.id.button)).perform(click());

        // Check result
        onView(withId(R.id.tvCountResult)).check(matches(withText("2")));
    }
}
