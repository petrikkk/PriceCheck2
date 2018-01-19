package com.mobile.petrk.pricecheck2;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataAPI {
    //String BASE_URL = "https://min-api.cryptocompare.com/data/price/";
    @GET("/api/ticker")
//"?fsym=ETH&tsyms=BTC,USD,EUR"
    Call<BtcPrice2> getPrice();
}

