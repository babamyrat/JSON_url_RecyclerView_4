package com.example.json_url_recyclerview_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ProfileActivity extends AppCompatActivity {
    TextView textView, textView2, textView3;
    ImageView imageView;
    String name, species, gender,img;
    Intent intent;
    ExampleItem exampleItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        intent = getIntent();
        exampleItem = intent.getParcelableExtra("Example Item");

        name = exampleItem.getName();
        species = exampleItem.getSpecies();
        gender = exampleItem.getGender();
        img = exampleItem.getImg();


        imageView = findViewById(R.id.imageView2);


        try {
            // using Glide
            Glide.with(this)
                    .load(img)
                    .into(imageView);
        } catch (Exception ignored) {

        }



        textView = findViewById(R.id.textView);
        textView.setText(name);

        textView2 = findViewById(R.id.textView2);
        textView2.setText(species);

        textView3 = findViewById(R.id.textView3);
        textView3.setText(gender);



    }
}