package com.mobile.petrk.pricecheck2;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class MainActivity extends AppCompatActivity {
    String BASE_URL = "https://www.bitstamp.net/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button button = findViewById(R.id.button1);
         button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    DataAPI dataAPI = retrofit.create(DataAPI.class);
                    Call<BtcPrice2> call = dataAPI.getPrice();
                    call.enqueue(new Callback<BtcPrice2>() {
                        @Override

                        public void onResponse(Call<BtcPrice2> call, Response<BtcPrice2> response) {
                            BtcPrice2 price = response.body();
                         //testovaci vypisy
                            System.out.println(price.getLast());
                            System.out.println(price.getHigh());
                            System.out.println(price.getLow());

                         //timestamp
                            Date date = new Date();
                            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                            String timestamp = (dateFormat.format(date));
                         //seskladani vypisu

                            StringBuilder sb = new StringBuilder();
                            sb.append("Aktuální cena:" + price.getLast() + "\n Denní minimum" + price.getLow() +
                             "\n Denní maximum: " + price.getHigh() + "\n Objem: " + price.getVolume() + "\n Čas: " +
                             timestamp);

                            TextView zobrazTextView = (TextView)findViewById(R.id.textView);
                            zobrazTextView.setText(sb.toString());
                                                   }

                        @Override
                        public void onFailure(Call<BtcPrice2> call, Throwable t) {
                            System.out.println("onFailure");
                            t.printStackTrace();
                        }
                    });


                }
         });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setContentView(R.layout.activity_main2);
            }
        });




    }
}