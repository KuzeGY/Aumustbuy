package com.kuuuze.aumustbuy.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kuuuze.aumustbuy.R;
import com.kuuuze.aumustbuy.entity.GetCurrentWeatherByGeoRes;
import com.kuuuze.aumustbuy.net.AMBNetService;
import com.kuuuze.aumustbuy.ui.base.BaseFragment;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;


import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by greyson on 5/12/17.
 */

public class Feature1Fragment extends BaseFragment {
    private TextView view1;
    private TextView view2;
    private TextView view3;
    private TextView view4;

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_feature1, container, false);
        view1 = view.findViewById(R.id.textView6);
        view2 = view.findViewById(R.id.textView7);
        view3 = view.findViewById(R.id.textView8);
        view4 = view.findViewById(R.id.textView9);
        return view;
    }

    @Override
    protected void initData() {
        handleAPIRequest();
    }

    private void handleAPIRequest() {
        Map<String, String> params = new HashMap<>();                                       // Store the params of the URL which is used to request corresponding data from server database
        params.put("lat", "-33.827");//-33.827292, 151.084968
        params.put("lon", "151.084");
        params.put("appid", getString(R.string.open_weather_Api_Key));
        mRetrofit.create(AMBNetService.class)
                .getCurrentWeatherData(params)
                .subscribeOn(Schedulers.io())
                .compose(this.<GetCurrentWeatherByGeoRes>bindToLifecycle())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetCurrentWeatherByGeoRes>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetCurrentWeatherByGeoRes weatherByGeoRes) {
                        showWeatherResult(weatherByGeoRes);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void showWeatherResult(GetCurrentWeatherByGeoRes weatherByGeoRes) {
        if (weatherByGeoRes != null) {
            view1.setText(Double.toString(weatherByGeoRes.getMain().getTemp() ));
            view2.setText(Double.toString(weatherByGeoRes.getMain().getTemp_max()));
            view3.setText(Double.toString(weatherByGeoRes.getMain().getTemp_min()));
            view4.setText(Double.toString(weatherByGeoRes.getMain().getHumidity()));
        }


    }
    @Override
    protected void initEvent() {

    }

    @Override
    protected void destroyView() {

    }
}
