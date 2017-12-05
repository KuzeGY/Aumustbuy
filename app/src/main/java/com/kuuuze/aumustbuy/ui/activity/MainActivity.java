package com.kuuuze.aumustbuy.ui.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kuuuze.aumustbuy.R;
import com.kuuuze.aumustbuy.ui.base.BaseActivity;
import com.kuuuze.aumustbuy.ui.base.BaseFragment;
import com.kuuuze.aumustbuy.ui.fragment.Feature1Fragment;
import com.kuuuze.aumustbuy.ui.fragment.Feature2Fragment;
import com.kuuuze.aumustbuy.ui.fragment.Feature3Fragment;
import com.kuuuze.aumustbuy.ui.fragment.Feature4Fragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    private FragmentManager mFragmentManager;
    private List<BaseFragment> mFragmentList = new ArrayList<>();
    private Feature1Fragment mFeature1Fragment;
    private Feature2Fragment mFeature2Fragment;
    private Feature3Fragment mFeature3Fragment;
    private Feature4Fragment mFeature4Fragment;
    private int mCurrentIndex;

    private View mBtFeature1;
    private View mBtFeature2;
    private View mBtFeature3;
    private View mBtFeature4;
    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mBtFeature1 = findView(R.id.main_feature1);
        mBtFeature2 = findView(R.id.main_bt2);
        mBtFeature3 = findView(R.id.main_bt3);
        mBtFeature4 = findView(R.id.main_bt4);
    }

    @Override
    protected void initData() {
        mFragmentManager = getFragmentManager();
        mFeature1Fragment = new Feature1Fragment();
        mFeature2Fragment = new Feature2Fragment();
        mFeature3Fragment = new Feature3Fragment();
        mFeature4Fragment = new Feature4Fragment();
        mFragmentList.add(mFeature1Fragment);
        mFragmentList.add(mFeature2Fragment);
        mFragmentList.add(mFeature3Fragment);
        mFragmentList.add(mFeature4Fragment);
        checkCurrentFragment();
    }

    private void checkCurrentFragment() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String str = null;
        if (str == null) {
            str = "feature1";
        }
        switch (str) {
            case "feature1":
                mFragmentManager.beginTransaction().add(R.id.fl_main, mFeature1Fragment, "1").commitAllowingStateLoss();
                mCurrentIndex = 0;
                mBtFeature1.setSelected(true);
                break;
            case "feature2":
                mFragmentManager.beginTransaction().add(R.id.fl_main, mFeature2Fragment, "2").commitAllowingStateLoss();
                mCurrentIndex = 1;
                mBtFeature2.setSelected(true);
                break;
            case "feature3":
                mFragmentManager.beginTransaction().add(R.id.fl_main, mFeature3Fragment, "3").commitAllowingStateLoss();
                mCurrentIndex = 2;
                mBtFeature3.setSelected(true);
                break;
            case "feature4":
                mFragmentManager.beginTransaction().add(R.id.fl_main, mFeature4Fragment, "4").commitAllowingStateLoss();
                mCurrentIndex = 3;
                mBtFeature4.setSelected(true);
                break;
        }
    }

    @Override
    protected void initEvent() {
        mBtFeature1.setOnClickListener(this);
        mBtFeature2.setOnClickListener(this);
        mBtFeature3.setOnClickListener(this);
        mBtFeature4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int index = 0;
        mBtFeature1.setSelected(false);
        mBtFeature2.setSelected(false);
        mBtFeature3.setSelected(false);
        mBtFeature4.setSelected(false);
        switch (view.getId()) {
            case R.id.main_feature1:
                index = 0;
                mBtFeature1.setSelected(true);
                break;
            case R.id.main_bt2:
                index = 1;
                mBtFeature2.setSelected(true);
                break;
            case R.id.main_bt3:
                index = 2;
                mBtFeature3.setSelected(true);
                break;
            case R.id.main_bt4:
                index = 3;
                mBtFeature4.setSelected(true);
                break;
        }
        if (index == mCurrentIndex) {
            return;
        }
        BaseFragment baseFragment = mFragmentList.get(index);
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        if (baseFragment.isAdded()) {
            fragmentTransaction.show(baseFragment);
        } else {
            fragmentTransaction.add(R.id.fl_main, baseFragment, index  + "");
            fragmentTransaction.show(baseFragment);
        }
        fragmentTransaction.setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.hide(mFragmentList.get(mCurrentIndex));
        fragmentTransaction.commitAllowingStateLoss();
        mCurrentIndex = index;
    }

    @Override
    protected void destroyView() {

    }
}
