package com.myandroid.myfirstapp;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.NumberPicker;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
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
        selectAge(25);

        onView(withId(R.id.txtResult))
                .check(matches(withText("還不急。")));
    }

    @Test
    public void checkFemaleAge32(){
        selectGender("女");
        selectAge(32);

        onView(withId(R.id.txtResult))
                .check(matches(withText("趕快結婚！")));
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

    private void selectAge(int age){
        onView(withId(R.id.numAge))
                .perform(setNumber(age));

    }

    /// 看起來是沒有比較簡單的行為可以完成這個畫面操作測試
    public static ViewAction setNumber(final int num) {
        return new ViewAction() {

            /// 只用setValue無法觸發onValueChange，所以除了給他值之外，再讓他上下滾同樣的長度，讓他滾出來的長度不變，但是有觸發事件
            @Override
            public void perform(UiController uiController, View view) {
                NumberPicker np = (NumberPicker) view;
                np.setValue(num);

                np.scrollBy(0, -1 * 500);
                np.scrollBy(0, 500);
            }

            @Override
            public String getDescription() {
                return "Set the passed number into the NumberPicker";
            }

            @Override
            public Matcher<View> getConstraints() {
                return ViewMatchers.isAssignableFrom(NumberPicker.class);
            }
        };
    }
}
