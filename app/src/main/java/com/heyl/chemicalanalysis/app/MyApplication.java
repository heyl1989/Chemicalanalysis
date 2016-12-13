package com.heyl.chemicalanalysis.app;

import android.app.Application;

/**
 * Created by heyl on 2016/12/4.
 */

public class MyApplication extends Application {

    private static MyApplication mInstance;

    public static MyApplication getInstance(){
        return mInstance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

}
