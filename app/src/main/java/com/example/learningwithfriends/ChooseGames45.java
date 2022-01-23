package com.example.learningwithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseGames45 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_games45);

        Button shapes_game_button = findViewById(R.id.shapes_game_button);
        Button family_members_game_button = findViewById(R.id.family_members_game_button);
        Button body_parts_game_button = findViewById(R.id.body_parts_game_button);

        shapes_game_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ChooseGames45.this, ShapesGame.class);
                startActivity(intent);
            }
        });

        family_members_game_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ChooseGames45.this, FamilyMembersGame.class);
                startActivity(intent);
            }
        });

        body_parts_game_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(ChooseGames45.this, BodyPartsGame.class);
                startActivity(intent);
            }
        });
    }
}