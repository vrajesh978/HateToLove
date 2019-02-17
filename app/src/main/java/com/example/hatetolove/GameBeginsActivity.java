package com.example.hatetolove;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

import static android.widget.Toast.*;

public class GameBeginsActivity extends AppCompatActivity {

    public TextView destinationWord;
    public Button sourceWordLetter1;
    public Button sourceWordLetter2;
    public Button sourceWordLetter3;
    public Button sourceWordLetter4;
    public LinearLayout myLayout;
    public EditText editText;
    public Button submit;
    private static Context ctx;
    Integer x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_begins);
        destinationWord = (TextView) findViewById(R.id.destination_word);
        sourceWordLetter1 = (Button) findViewById(R.id.letter1);
        sourceWordLetter2 = (Button) findViewById(R.id.letter2);
        sourceWordLetter3 = (Button) findViewById(R.id.letter3);
        sourceWordLetter4 = (Button) findViewById(R.id.letter4);
        myLayout = (LinearLayout) findViewById(R.id.myLayout);
        editText = (EditText) findViewById(R.id.edittext);
        submit = (Button) findViewById(R.id.submit);
        ctx = getApplicationContext();
        init();
        x = 0;
    }
    protected void init(){
        WordUtils wu = new WordUtils(2339);
        int current_source = 0;

        wu.initWordList(ctx,"ulti.txt");
        wu.init(ctx,"connected_words.txt");

        List<String> wordsNamesList= wu.getWordList();
        Log.d("Size of WordList","Sizse = " + wordsNamesList.size());

        int number = (int) (Math.random() * ((2338-0+1)) + 0);
//        int number = generator.nextInt(2338 + 1 -0) + 0;
        int dest = number;
        destinationWord.setText(wordsNamesList.get(dest));
        //number = (int) (Math.random() * ((2338-0+1)) + 0);
        Random generator = new Random();
        number = generator.nextInt(2338 + 1 -0) + 0;
        while(dest==number){
            number = (int) (Math.random() * ((2338-0+1)) + 0);
        }
        int src = number;
        String s = wordsNamesList.get(src);
        sourceWordLetter1.setText(Character.toString(s.charAt(0)));
        sourceWordLetter2.setText(Character.toString(s.charAt(1)));
        sourceWordLetter3.setText(Character.toString(s.charAt(2)));
        sourceWordLetter4.setText(Character.toString(s.charAt(3)));
        current_source = src;

        Log.d("yes ", " "+src+" "+dest);
//        int temp = -1;
//        temp = wu.BFS(src,dest,2339);
//        while(temp!=dest) {
//            Log.d("yes ", " " + wordsNamesList.get(src) + " to " + wordsNamesList.get(dest));
//            Log.d("yes ", " " + wordsNamesList.get(temp));
//            temp = wu.BFS(temp,dest,2339);
//        }
        sourceWordLetter1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                x = 1;
                sourceWordLetter1.setBackgroundColor(Color.GREEN);
            }
        });
        sourceWordLetter2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                x = 2;
                sourceWordLetter2.setBackgroundColor(Color.GREEN);
            }
        });
        sourceWordLetter3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                x = 3;
                sourceWordLetter3.setBackgroundColor(Color.GREEN);
            }
        });
        sourceWordLetter4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                x = 4;
                sourceWordLetter4.setBackgroundColor(Color.GREEN);

            }
        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText = (EditText) findViewById(R.id.edittext);
                if(x == 1)
                    sourceWordLetter1.setText(editText.getText());
                else if(x ==2)
                    sourceWordLetter2.setText(editText.getText());
                else if(x ==3)
                    sourceWordLetter3.setText(editText.getText());
                else if(x ==4)
                    sourceWordLetter4.setText(editText.getText());
                editText.setText("");
            }
        });


//        if(submit!=null){
//            submit.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(ctx, "hr="+v.getId(), LENGTH_LONG).show();
//                    switch (v.getId()){
//                        case R.id.btn1:
//                            editText = (EditText) findViewById(R.id.editText1);
//                            sourceWordLetter1.setText(editText.getText());
//                            editText.setText("");
//                            break;
//                        case R.id.btn2:
//                            editText = (EditText) findViewById(R.id.editText2);
//                            sourceWordLetter2.setText(editText.getText());
//                            editText.setText("");
//                            break;
//                        case R.id.btn3:
//                            editText = (EditText) findViewById(R.id.editText3);
//                            sourceWordLetter3.setText(editText.getText());
//                            editText.setText("");
//                            break;
//                        case R.id.btn4:
//                            editText = (EditText) findViewById(R.id.editText4);
//                            sourceWordLetter4.setText(editText.getText());
//                            editText.setText("");
//                            break;
//                    }
//                }
//            });
//        }
    }

}


