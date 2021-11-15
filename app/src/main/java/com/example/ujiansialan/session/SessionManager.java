package com.example.ujiansialan.session;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context;

    public static final String PREF_NAME = "LoginSuccess";
    private static final String IS_FIRST_TIME_LAUNCH = "LoginCheck";

    public SessionManager(Context context) {
        preferences = context.getSharedPreferences(PREF_NAME, 0);
        editor = preferences.edit();
        this.context = context;
    }

    public void checkLogin(boolean isLogged){
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isLogged);
        editor.commit();
    }

    public boolean isLogged() {
        return preferences.getBoolean(IS_FIRST_TIME_LAUNCH, false);
    }
}
