package com.myandroid.myfirstapp;

/**
 * Created by break on 2017/3/21.
 */

public class MarriageSuggestion {
    public String getSuggestion(String gender, int age){
        String rtn = "";
        if(gender.equals("男")) {
            if(age < 28){
                rtn += "還不急。";
            }
            else if(age > 33){
                rtn += "趕快結婚！";
            }
            else{
                rtn += "開始找對象。";
            }
        }else{
            if(age < 25){
                rtn += "還不急。";
            }
            else if(age > 30){
                rtn += "趕快結婚！";
            }
            else{
                rtn += "開始找對象。";
            }
        }

        return rtn;
    }

}
