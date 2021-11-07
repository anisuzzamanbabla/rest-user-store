package com.example.restuserstore.util;

/**
 * @author : anisuzzaman
 * @created : 7/11/21, Sunday
 **/
public class NumberCheck {
    public static boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
