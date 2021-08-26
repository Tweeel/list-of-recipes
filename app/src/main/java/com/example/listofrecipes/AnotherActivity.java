package com.example.listofrecipes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    TextView mTitleTv , mDescTv;
    ImageView mImageTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        ActionBar actionBar = getSupportActionBar();

        mTitleTv = findViewById(R.id.title);
        mDescTv = findViewById(R.id.description);
        mImageTv = findViewById(R.id.imageView);

    }
}