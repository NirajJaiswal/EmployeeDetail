package com.example.employeedetail.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class Util
{
    public static String loadJSONContent(Context context, String filename) {
        String jsonStr = null;
        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonStr = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            LoggerUtils.exception(ex.getMessage());
        }
        return jsonStr;
    }
}
