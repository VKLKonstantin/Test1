package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        textView=findViewById(R.id.textView2);
        Intent intent = getIntent();
        String actions = intent.getAction();

        if (actions.equals("action.time")) {
            textView.setText("time");

        } else if (actions.equals("action.date")) {
            textView.setText("date");
        }
    }
}