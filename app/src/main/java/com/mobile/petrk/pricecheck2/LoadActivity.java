package com.mobile.petrk.pricecheck2;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        String file  ="history_data";
        System.out.println(getFilesDir().toString());

        FileInputStream fis;
        String content = "";

        try {
            fis = openFileInput(file);
            byte[] input = new byte[fis.available()];
            while (fis.read(input) != -1) {
            }
            content += new String(input);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Neco je spatne, soubor nenalezen.");
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Neco je spatne, IO Exception.");
        }


        TextView tv = (TextView)findViewById(R.id.textLoad);
        tv.append(content.toString());
    }

}
