package com.example.hatetolove;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public TextView destination_word;
    public EditText source_word;
    public TextView notification_word;
    private static Context ctx;
//    public AssetManager assetManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        destination_word = findViewById(R.id.destinaton_word);
        source_word = findViewById(R.id.source_word);
        notification_word = findViewById(R.id.notifaction_word);
//        assetManager = getAssets();
        ctx = getApplicationContext();
        init();
    }



    protected void init(){

        WordUtils wu = new WordUtils(2339);
        int current_source;

        wu.initWordList(ctx,"ulti.txt");
        wu.init(ctx,"connected_words.txt");

        List<String> wordsNamesList= wu.getWordList();
        Log.d("Size of WordList","Sizse = " + wordsNamesList.size());

        Random generator = new Random();
        int number = generator.nextInt(2338 + 1 -0) + 0;
        int dest = number;
        destination_word.setText(wordsNamesList.get(dest));
        number = generator.nextInt(2338 + 1 -0) + 0;
        while(dest==number || !wu.checkWordInDict(number,dest)){
            number = generator.nextInt(2338 + 1 -0) + 0;
        }
        int src = number;
        current_source = src;

        Log.d("yes ", " "+src+" "+dest);
        int temp = -1;
        temp = wu.BFS(src,dest,2339);
        while(temp!=dest) {
            Log.d("yes ", " " + wordsNamesList.get(src) + " to " + wordsNamesList.get(dest));
            Log.d("yes ", " " + wordsNamesList.get(temp));
            temp = wu.BFS(temp,dest,2339);
        }
        source_word.setText(wordsNamesList.get(src));

    }


    public void onClickBtnHome(View v)
    {
        Toast.makeText(this, "Clicked on Button", Toast.LENGTH_LONG).show();
        startActivity(new Intent(MainActivity.this, GameBeginsActivity.class));

    }
}
