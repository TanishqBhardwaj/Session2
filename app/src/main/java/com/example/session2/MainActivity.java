package com.example.session2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView mTextView;
    private Button mButton;

    public static final String NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView);
        mButton = findViewById(R.id.button);
        mTextView.setText("Tanishq");

        mButton.setOnClickListener(view -> {

            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(NAME, mTextView.getText().toString());
            startActivity(intent);
        });
    }
}