package com.example.test1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "lifecycle";

    Button time, date, extra, inputButton;
    TextView textView;
    static final String ACCESS_MESSAGE="ACCESS_MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);

        time = findViewById(R.id.button_time);
        date = findViewById(R.id.button_date);
        extra = findViewById(R.id.button_extra);
        inputButton = findViewById(R.id.inputButton);
        textView = findViewById(R.id.textView);

        time.setOnClickListener(this);
        date.setOnClickListener(this);
        extra.setOnClickListener(this);
        inputButton.setOnClickListener(this);
    }

    ActivityResultLauncher<Intent> resultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            if (result.getResultCode() == Activity.RESULT_OK) {
                                Intent intent = result.getData();
                                String accessMessage = intent.getStringExtra(ACCESS_MESSAGE);
                                textView.setText(accessMessage);
                            }
                        }
                    }
            );

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.button_time:
                intent = new Intent("action.time");
                startActivity(intent);
                break;
            case R.id.button_date:
                intent = new Intent("action.date");
                startActivity(intent);
                break;
            case R.id.button_extra:
                intent = new Intent(this, MainActivity3.class);
                intent.putExtra("key", "LLL");
                startActivity(intent);
                break;
            case R.id.inputButton:
//                intent = new Intent(this, MainActivity4.class);
//                getResult.launch(intent)
//                startActivityForResult(intent, 1);
//                ActivityResultLauncher<String> mGetContent =
//                        registerForActivityResult(new ActivityResultContracts.GetContent(),
//                                new ActivityResultCallback<Uri>() {
//                                    @Override
//                                    public void onActivityResult(Uri uri) {
//                                        textView.setText(uri.);
//                                    }
//                                });
//                mGetContent.launch("");
                resultLauncher.launch(new Intent(this, MainActivity4.class));
                break;
        }
    }










     /*
    public void onSecondActivity (View view){
     Intent intent = new Intent(this, TestActivity2.class);
     startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");

    }
         */


}