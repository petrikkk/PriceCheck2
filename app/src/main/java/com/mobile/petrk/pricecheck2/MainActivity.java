package com.mobile.petrk.pricecheck2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    String BASE_URL = "https://min-api.cryptocompare.com/data/price";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void testMethod() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DataAPI dataAPI = retrofit.create(DataAPI.class);
        Call<BtcPrice> call = dataAPI.getPrice();
        call.enqueue(new Callback() {

            @Override
            public void onResponse(Call call, Response response) {

            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });


        }
    }
}
