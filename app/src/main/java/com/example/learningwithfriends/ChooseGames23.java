package com.example.learningwithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseGames23 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_games23);

        Button letters_game_button = findViewById(R.id.letters_game_button);
        Button number_game_button = findViewById(R.id.numbers_game_button);
        Button colors_game_button = findViewById(R.id.colors_game_button);

        letters_game_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ChooseGames23.this, LettersGame.class);
                startActivity(intent);
            }
        });

        number_game_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ChooseGames23.this, NumbersGame.class);
                startActivity(intent);
            }
        });

        colors_game_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ChooseGames23.this, ColorsGame.class);
                startActivity(intent);
            }
        });
    }
}