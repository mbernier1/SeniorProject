package com.example.learningwithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NumbersGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_game);

        TextView number_1 = findViewById(R.id.random_number_1);
        TextView number_2 = findViewById(R.id.random_number_2);
        TextView number_3 = findViewById(R.id.random_number_3);

        ImageView image_1 = findViewById(R.id.random_number_image_1);
        ImageView image_2 = findViewById(R.id.random_number_image_2);
        ImageView image_3 = findViewById(R.id.random_number_image_3);
    }
}