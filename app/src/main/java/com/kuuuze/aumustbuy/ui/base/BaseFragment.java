package com.kuuuze.aumustbuy.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kuuuze.aumustbuy.config.AMBAppContext;
import com.trello.rxlifecycle2.components.RxFragment;

import retrofit2.Retrofit;

/**
 * Created by greyson on 5/12/17.
 */

public abstract class BaseFragment extends RxFragment{
    protected Context mContext;

    protected Retrofit mRetrofit = AMBAppContext.getInstance().getRetrofit();
    protected Resources mResources = AMBAppContext.getInstance().getResources();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initEvent();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        destroyView();
    }

    protected abstract View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) ;

    protected abstract void initData();

    protected abstract void initEvent();

    protected abstract void destroyView();

}
