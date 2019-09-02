package com.redtechtut.agrochem;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("rv9LITBTSt4i5fiae3kP7Z9LyyO4wg91eWdHvnLX")
                // if defined
                .clientKey("UgscViGiIrjGvoqzaAdTO1As3HILjDRcIr2w3lUr")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
