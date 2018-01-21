package com.mobile.petrk.pricecheck2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class SaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        //ziskani dat z predchozi aktivity
        String dataUlozeni = getIntent().getExtras().getString("data", "dummy value");
        //testovaci vypis
        System.out.println(dataUlozeni);

        EditText zobrazTextView = (EditText) findViewById(R.id.editText);
        zobrazTextView.setText(dataUlozeni);

    }

}
