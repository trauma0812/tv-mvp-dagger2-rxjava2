package jp.co.nino.learning.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by tran.dinh.son on 9/29/2016.
 */
public class SharePref {

    public static final String PREFNAME = "VisionPreference";

    // put/get boolean
    public static void putBoolean(Context context, String key, boolean value) {
        if (context == null || key == null) {
            return;
        }
        SharedPreferences prefi = context.getSharedPreferences(PREFNAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefi.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        if (context == null || key == null) {
            return defaultValue;
        }
        SharedPreferences sp = context.getSharedPreferences(PREFNAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defaultValue);
    }

    // put/get string
    public static void putString(Context context, String key, String value) {
        if (context == null || key == null) {
            return;
        }
        SharedPreferences prefi = context.getSharedPreferences(PREFNAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefi.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public static String getString(Context context, String key, String defaultValue) {
        if (context == null || key == null) {
            return defaultValue;
        }
        SharedPreferences sp = context.getSharedPreferences(PREFNAME, Context.MODE_PRIVATE);
        return sp.getString(key, defaultValue);
    }


    public static void remove(Context context, String[] keys) {
        SharedPreferences prefi = context.getSharedPreferences(PREFNAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefi.edit();
        for (String key : keys) {
            editor.remove(key);
        }
        editor.apply();
    }
}
