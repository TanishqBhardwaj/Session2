package com.example.session2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView mTextView;
    private Button mButton;
    private FrameLayout mFrameLayout;

    public static final String NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView);
        mButton = findViewById(R.id.button);
        mFrameLayout = findViewById(R.id.frame_layout);

        mTextView.setText("Tanishq");

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                new BlankFragment()).commit();

        mButton.setOnClickListener(view -> {

            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(NAME, mTextView.getText().toString());
            startActivity(intent);
        });


    }
}