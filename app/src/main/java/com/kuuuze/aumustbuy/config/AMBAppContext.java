package com.kuuuze.aumustbuy.config;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.kuuuze.aumustbuy.net.NetWorkApi;

import retrofit2.Retrofit;

/**
 * Created by greyson on 5/12/17.
 */

public class AMBAppContext extends Application{
    private static AMBAppContext instance;
    private Context mContext;
    private Resources mResources;
    private Retrofit mRetrofit;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        init();
    }

    private void init() {
        mContext = AMBAppContext.getInstance().getApplicationContext();
        mResources = mContext.getResources();
        mRetrofit = NetWorkApi.getInstance().gradleRetrofit(this);

    }

    public static synchronized AMBAppContext getInstance() {
        return instance;
    }

    public synchronized Context getAppContext() {
        return mContext;
    }

    public synchronized Resources getmResources() {
        return mResources;
    }

    public synchronized Retrofit getRetrofit() {
        return mRetrofit;
    }
}
