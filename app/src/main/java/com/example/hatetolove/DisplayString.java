package com.example.hatetolove;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class DisplayString extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_string);
//        destinationWord = (TextView) findViewById(R.id.destination_word);
//        sourceWordLetter1 = (Button) findViewById(R.id.letter1);
//        sourceWordLetter2 = (Button) findViewById(R.id.letter2);
//        sourceWordLetter3 = (Button) findViewById(R.id.letter3);
//        sourceWordLetter4 = (Button) findViewById(R.id.letter4);
        //ctx = getApplicationContext();
        //init();
        Intent intent = getIntent();
        String message = intent.getStringExtra(GameBeginsActivity.extra);
        String[] msg = message.split("@");
        TextView tx = (TextView) findViewById(R.id.textView);
        tx.setMovementMethod(new ScrollingMovementMethod());
        String ne = new String();
        for(String s: msg)
             ne +=s+"\n";
        tx.setText(ne);
    }
}
