package com.example.hatetolove;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.init();
        setContentView(R.layout.activity_main);
    }

    protected void init(){
        try {
            WordUtils wu = new WordUtils("/com/example/hatetolove/Connected_Words.txt", "/com/example/hatetolove/ulti.txt");
            Log.d("init","Here");
            TextView destination_word = (TextView) findViewById(R.id.destinaton_word);
            EditText source_word = (EditText) findViewById(R.id.source_word);
            TextView notification_word = (TextView) findViewById(R.id.notifaction_word);
            ArrayList<String> wordsNamesList= wu.getWordList();
            Random generator = new Random();
            int number = generator.nextInt(2338 + 1 -0) + 0;
            int dest = number;
            destination_word.setText(wordsNamesList.get(dest));
            number = generator.nextInt(2338 + 1 -0) + 0;
            while(dest==number){
                number = generator.nextInt(2338 + 1 -0) + 0;
            }
            int src = number;
            source_word.setText(wordsNamesList.get(src));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
