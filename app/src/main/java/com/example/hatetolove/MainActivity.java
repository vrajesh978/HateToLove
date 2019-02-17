package com.example.hatetolove;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
    public TextView destinationWord;
    public Button sourceWordLetter1;
    public Button sourceWordLetter2;
    public Button sourceWordLetter3;
    public Button sourceWordLetter4;
    private static Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        destinationWord = (TextView) findViewById(R.id.destination_word);
//        sourceWordLetter1 = (Button) findViewById(R.id.letter1);
//        sourceWordLetter2 = (Button) findViewById(R.id.letter2);
//        sourceWordLetter3 = (Button) findViewById(R.id.letter3);
//        sourceWordLetter4 = (Button) findViewById(R.id.letter4);
        //ctx = getApplicationContext();
        //init();
    }

//
//
//    protected void init(){
//        WordUtils wu = new WordUtils(2339);
//        int current_source = 0;
//
//        wu.initWordList(ctx,"ulti.txt");
//        wu.init(ctx,"connected_words.txt");
//
//        List<String> wordsNamesList= wu.getWordList();
//        Log.d("Size of WordList","Sizse = " + wordsNamesList.size());
//
//        Random generator = new Random();
//        int number = generator.nextInt(2338 + 1 -0) + 0;
//        int dest = number;
//        destinationWord.setText(wordsNamesList.get(dest));
//        number = generator.nextInt(2338 + 1 -0) + 0;
//        while(dest==number || !wu.checkWordInDict(number,dest)){
//            number = generator.nextInt(2338 + 1 -0) + 0;
//        }
//        int src = number;
////        sourceWordLetter1.setText(wordsNamesList.get(src).charAt(0));
////        sourceWordLetter2.setText(wordsNamesList.get(src).charAt(1));
////        sourceWordLetter3.setText(wordsNamesList.get(src).charAt(2));
////        sourceWordLetter4.setText(wordsNamesList.get(src).charAt(3));
//        current_source = src;
//
//        Log.d("yes ", " "+src+" "+dest);
////        int temp = -1;
////        temp = wu.BFS(src,dest,2339);
////        while(temp!=dest) {
////           EditText Log.d("yes ", " " + wordsNamesList.get(src) + " to " + wordsNamesList.get(dest));
////            Log.d("yes ", " " + wordsNamesList.get(temp));
////            temp = wu.BFS(temp,dest,2339);
////        }
//    }


    public void onClickBtnHome(View v)
    {
        Toast.makeText(this, "Clicked on Button", Toast.LENGTH_LONG).show();
        startActivity(new Intent(MainActivity.this, GameBeginsActivity.class));

    }
}
