package com.example.json_url_recyclerview_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView = findViewById(R.id.textView);

        String username = "Username not set";

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            username = extras.getString("name");
        }

        textView.setText(username);

    }
}