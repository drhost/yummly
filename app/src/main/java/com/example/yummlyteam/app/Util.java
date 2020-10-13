package com.example.yummlyteam.app;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class Util {

    public static boolean isNetworkConnectionAvailable(Context context) {
        boolean isNetworkConnectionAvailable = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            isNetworkConnectionAvailable = (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED);
        }
        return isNetworkConnectionAvailable;
    }

    public static String timeFormatter(Integer timeInSeconds) {
        int min = timeInSeconds / 60;
        if (min >= 60) {
            int hour = min/60;
            int minutes = min % 60;
            return minutes == 0 ? hour + "h" : hour + "h " + minutes + "m";
        }
        return min + "m";

    }

}
