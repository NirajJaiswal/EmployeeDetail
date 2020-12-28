package com.example.employeedetail.utils;

import android.util.Log;

public class LoggerUtils
{
    public static void warning(String message) {

            Log.v("Warning", ""+message);

    }

    public static void info(String message) {

            Log.i("Info", ""+message);

    }

    public static void error(String message) {

            Log.e("Error", "" + message);

    }

    public static void exception(String message) {

            Log.e("Exception", "" + message);

    }

    public static void exception(String message, Exception ex){

            Log.e("My KP Meds", " Message - " + message + " Exception - " + ex.getMessage());

    }
}
