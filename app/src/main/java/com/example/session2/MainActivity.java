package com.example.session2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static final String TAG = "MainActivity";
    private TextView mTextView;
    private Button mButton;
    private FrameLayout mFrameLayout;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    public static final String NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mTextView = findViewById(R.id.textView);
//        mButton = findViewById(R.id.button);
        mFrameLayout = findViewById(R.id.frame_layout);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        toolbar = findViewById(R.id.toolbar);

        navigationView.setNavigationItemSelectedListener(MainActivity.this);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, toolbar
                , R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //it's instance ties together drawer layout and toolbar
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();//setting up hamburger icon

//        mTextView.setText("Tanishq");

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                new BlankFragment()).commit();

//        mButton.setOnClickListener(view -> {
//
//            Intent intent = new Intent(this, SecondActivity.class);
//            intent.putExtra(NAME, mTextView.getText().toString());
//            startActivity(intent);
//        });


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home :
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,
                        new HomeFragment()).commit();
                break;

            case R.id.profile:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}