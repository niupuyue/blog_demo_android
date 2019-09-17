package com.paulniu.library.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.paulniu.library.LibrariesCons;

/**
 * Coder: niupuyue
 * Date: 2019/9/17
 * Time: 18:19
 * Desc:
 * Version:
 */
public class SharedUtils {

    public static final String string_app_uuid = "app_uuid";

    public static void writeString(String name, String value) {
        try {
            SharedPreferences sharedPreferences = LibrariesCons.getContext().getSharedPreferences(name, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(name, value);
            editor.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String readString(String name) {

        String value;
        try {
            SharedPreferences sharedPreferences = LibrariesCons.getContext().getSharedPreferences(name, Context.MODE_PRIVATE);
            value = sharedPreferences.getString(name, "");
        } catch (Exception ex) {
            ex.printStackTrace();
            value = "";
        }

        return value;
    }

}
