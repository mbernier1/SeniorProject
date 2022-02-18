package com.example.learningwithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ShapesGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes_game);


        LettersGameLogic startGame = new LettersGameLogic();

        //Object list of letters in random order
        Object[] randomizedShapes = startGame.RandomKeyGenerator().toArray();
    }
}