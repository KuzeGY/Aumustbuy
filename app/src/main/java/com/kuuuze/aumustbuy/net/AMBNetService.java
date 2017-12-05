package com.kuuuze.aumustbuy.net;

import com.kuuuze.aumustbuy.entity.GetCurrentWeatherByGeoRes;

import java.util.Map;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by greyson on 5/12/17.
 */

public interface AMBNetService {
    /**
     * SafePlace Request
     */
    @GET("weather?")
    Observable<GetCurrentWeatherByGeoRes> getCurrentWeatherData(@QueryMap Map<String, String> params);


}
