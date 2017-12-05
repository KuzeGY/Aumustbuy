package com.kuuuze.aumustbuy.ui.base;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.kuuuze.aumustbuy.config.AMBAppContext;
import com.trello.rxlifecycle2.components.RxActivity;

import retrofit2.Retrofit;

/**
 * Created by greyson on 5/12/17.
 */

public abstract class BaseActivity extends RxActivity{
    protected Retrofit mRetrofit = AMBAppContext.getInstance().getRetrofit();
    protected Resources mResources = AMBAppContext.getInstance().getResources();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initEvent();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    protected  <T extends View> T findView(int id) {
        return (T) findViewById(id);
    }

    protected abstract int getLayoutRes();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initEvent();

    protected abstract void destroyView();
}
