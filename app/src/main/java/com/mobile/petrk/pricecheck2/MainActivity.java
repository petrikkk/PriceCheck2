package com.mobile.petrk.pricecheck2;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    String BASE_URL = "https://www.bitstamp.net/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DataAPI dataAPI = retrofit.create(DataAPI.class);
        Call<BtcPrice2> call = dataAPI.getPrice();
        call.enqueue(new Callback<BtcPrice2>() {

            @Override
            public void onResponse(Call<BtcPrice2> call, Response<BtcPrice2> response) {
                BtcPrice2 price = response.body();
                System.out.println(price.getLast());
                System.out.println(price.getHigh());
                System.out.println(price.getLow());
                TextView zobrazTextView = (TextView)findViewById(R.id.textView);
                zobrazTextView.setText(price.getLast());

            }

            @Override
            public void onFailure(Call<BtcPrice2> call, Throwable t) {
                System.out.println("onFailure");
                t.printStackTrace();
            }
        });

    }
}