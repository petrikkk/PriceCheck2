package com.mobile.petrk.pricecheck2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by petrk on 21.01.2018.
 */

public class RetrofitCreator {
    String BASE_URL = "https://www.bitstamp.net/";

    public Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

}
