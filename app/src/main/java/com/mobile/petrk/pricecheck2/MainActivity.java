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




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    //vytvoreni instance retrofitu a stazeni dat pres API
                    RetrofitCreator rc = new RetrofitCreator();
                    DataAPI dataAPI = rc.getRetrofit().create(DataAPI.class);
                    Call<BtcPrice2> call = dataAPI.getPrice();
                    call.enqueue(new Callback<BtcPrice2>() {
                        @Override

                        public void onResponse(Call<BtcPrice2> call, Response<BtcPrice2> response) {
                            BtcPrice2 price = response.body();
                            //vypis aktualni ceny do TextView
                            TextView zobrazTextView = (TextView)findViewById(R.id.textView);
                            zobrazTextView.setText(price.getLast().toString());
                        }

                        @Override
                        public void onFailure(Call<BtcPrice2> call, Throwable t) {
                            System.out.println("onFailure");
                            t.printStackTrace();
                        }
                    });


                }
         });
        //tlacitko a jeho listener pro vytvoreni novew aktivity pro vypis detailu
        Button button2 = findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });




    }
}