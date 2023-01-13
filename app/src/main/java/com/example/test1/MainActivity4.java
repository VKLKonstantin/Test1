package com.example.test1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        editText = findViewById(R.id.plain_text_input);
        button = findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent data = new Intent();
        data.putExtra(MainActivity.ACCESS_MESSAGE, editText.getText().toString());
        setResult(RESULT_OK, data);
        finish();
    }
}