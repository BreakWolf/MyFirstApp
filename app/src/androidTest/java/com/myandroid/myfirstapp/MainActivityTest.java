package com.myandroid.myfirstapp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * Created by break on 2017/3/21.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    public MainActivityTest(){

    }

    @Test
    public void checkMaleAge25(){
        selectGender("男");
        onView(withId(R.id.edtAge))
                .perform(typeText("25"), closeSoftKeyboard());
        onView(withId(R.id.btnDoSug))
                .perform(click());

        onView(withId(R.id.txtResult))
                .check(matches(withText(R.string.sug_not_hurry)));
    }

    @Test
    public void checkFemaleAge32(){
        selectGender("女");
        onView(withId(R.id.edtAge))
                .perform(typeText("32"), closeSoftKeyboard());
        onView(withId(R.id.btnDoSug))
                .perform(click());

        onView(withId(R.id.txtResult))
                .check(matches(withText(R.string.sug_get_married)));
    }


    private void selectGender(String gender){
        // 模擬人機操作
        // 1. 在spinner上點一下
        // 2. 在想要選的資料上再點一下
        onView(withId(R.id.spnGender))
                .perform(click());
        onData(allOf(is(instanceOf(String.class)), is(gender)))
                .perform(click());
    }
}
