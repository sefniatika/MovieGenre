package com.example.oneuse.filmpopuler;

import android.app.Application;

/**
 * Created by ONEUSE on 30/10/2017.
 */


public class FilmPopulerApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
//            Stetho.initializeWithDefaults(this);
        }
    }
}
