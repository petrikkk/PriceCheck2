package com.mobile.petrk.pricecheck2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {
    Container cnt = new Container();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RetrofitCreator rc = new RetrofitCreator();
        DataAPI dataAPI = rc.getRetrofit().create(DataAPI.class);
        Call<BtcPrice2> call = dataAPI.getPrice();
        call.enqueue(new Callback<BtcPrice2>() {
            @Override
            public void onResponse(Call<BtcPrice2> call, Response<BtcPrice2> response) {
                BtcPrice2 price = response.body();
                //timestamp
                Date date = new Date();
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String timestamp = (dateFormat.format(date));

                //seskladani vypisu
                StringBuilder sb = new StringBuilder();
                sb.append("Aktuální cena:" + price.getLast() + "\n Denní minimum" + price.getLow() +
                        "\n Denní maximum: " + price.getHigh() + "\n Objem: " + price.getVolume() +
                        "\n Otvírací cena: " + price.getOpen() + "\n Ask: " + price.getAsk() +
                        "\n Bid: " + price.getBid() + "\n Čas: " + timestamp);

                //vypis detailu trhu do TextView
                TextView zobrazTextView = (TextView) findViewById(R.id.textViewDetails);
                zobrazTextView.setText(sb.toString());

                //predani dat do "prepravky"

                cnt.setDetails(sb.toString());
            }

            @Override
            public void onFailure(Call<BtcPrice2> call, Throwable t) {
                System.out.println("onFailure");
                t.printStackTrace();
            }
        });

        Button button2 = findViewById(R.id.buttonBack);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button button3 = findViewById(R.id.buttonSave);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, SaveActivity.class);
                intent.putExtra("data", cnt.getDetails());
                startActivity(intent);
                finish();
            }
        });

        Button button4 = findViewById(R.id.buttonLoad);
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, LoadActivity.class);
                intent.putExtra("data", cnt.getDetails());
                startActivity(intent);
                finish();
            }
        });


    }
}
