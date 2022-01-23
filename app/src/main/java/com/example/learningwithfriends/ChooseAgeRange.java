package com.example.learningwithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseAgeRange extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_age_range);

        Button age_2_3_button = findViewById(R.id.ages_2_3_button);
        Button age_4_5_button = findViewById(R.id.ages_4_5_button);

        age_2_3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ChooseAgeRange.this, ChooseGames23.class);
                startActivity(intent);
            }
        });

        age_4_5_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ChooseAgeRange.this, ChooseGames45.class);
                startActivity(intent);
            }
        });
    }
}