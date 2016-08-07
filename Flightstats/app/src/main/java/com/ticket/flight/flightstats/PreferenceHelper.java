package com.ticket.flight.flightstats;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Алексей Бут on 08.10.2015.
 */
public class PreferenceHelper {
    public static final String SPLASH_KEY_NO_VISION = "splash_key_no_vision";

    private static PreferenceHelper instanse;
    private Context context;
    private SharedPreferences preferences;

    private PreferenceHelper() {
    }

    public static PreferenceHelper getInstanse() {
        if (instanse == null) {
            instanse = new PreferenceHelper();

        }
        return instanse;
    }
    public  void  init (Context context) {
        this.context = context;
        preferences = context.getSharedPreferences("preferences", Context.MODE_PRIVATE);
    }

    public void putBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();


    }

    public boolean getBoolean(String key) {
        return preferences.getBoolean(key, false);
    }
}
