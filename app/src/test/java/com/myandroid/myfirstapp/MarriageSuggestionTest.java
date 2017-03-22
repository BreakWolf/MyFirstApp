package com.myandroid.myfirstapp;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;

/**
 * Created by break on 2017/3/21.
 */

public class MarriageSuggestionTest {
    @Test
    public void getSuggestion(){
        MarriageSuggestion sug = new MarriageSuggestion();
        String s = sug.getSuggestion("男", 25);
        assertEquals(s, "還不急。");
        s = sug.getSuggestion("男", 30);
        assertEquals(s, "開始找對象。");
        s = sug.getSuggestion("男", 34);
        assertEquals(s, "趕快結婚！");
        s = sug.getSuggestion("女", 24);
        assertEquals(s, "還不急。");
        s = sug.getSuggestion("女", 29);
        assertEquals(s, "開始找對象。");
        s = sug.getSuggestion("女", 31);
        assertEquals(s, "趕快結婚！");

    }
}
