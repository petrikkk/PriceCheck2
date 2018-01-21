package com.mobile.petrk.pricecheck2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;

public class SaveActivity extends AppCompatActivity {
    //private final String FILE_PATH = "data/save";
    final String filename = "history_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        //ziskani dat z predchozi aktivity
        String dataUlozeni = getIntent().getExtras().getString("data", "dummy value");

        //testovaci vypis
        System.out.println(dataUlozeni);
        System.out.println(getFilesDir().toString());
        //zobrazeni a editace v EditText boxu
        EditText zobrazTextView = (EditText) findViewById(R.id.editText);
        zobrazTextView.setText(dataUlozeni);


        //ulozeni dat z EditText boxu
        Button button = findViewById(R.id.buttonSave);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                FileOutputStream outputStream;

                try {
                    EditText saveTextView = (EditText) findViewById(R.id.editText);
                    outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                    outputStream.write(saveTextView.getText().toString().getBytes());
                    outputStream.close();
                } catch (Exception e) {
                    System.out.println("Neco je spatne, zapis se nezdaril.");
                    e.printStackTrace();

                } finally {
                    finish();
                }
            }
        });

    }


}
