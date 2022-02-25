package com.example.learningwithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NumbersGame extends AppCompatActivity {

    private final String KEY_INDEX = "index";
    GlobalVariables global = new GlobalVariables();
    private int count = global.GetCount();

    ImageView number_1;
    ImageView number_2;
    ImageView number_3;
    ImageView image_1;
    ImageView image_2;
    ImageView image_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_game);

        number_1 = findViewById(R.id.random_number_1);
        number_2 = findViewById(R.id.random_number_2);
        number_3 = findViewById(R.id.random_number_3);

        image_1 = findViewById(R.id.random_number_dots_1);
        image_2 = findViewById(R.id.random_number_dots_2);
        image_3 = findViewById(R.id.random_number_dots_3);

        NumbersGameLogic startGame = new NumbersGameLogic();

        Object[] randomizedNumbersKeys = startGame.RandomKeyGenerator().toArray();

        Integer choice_1 = (Integer) randomizedNumbersKeys[0];
        Integer choice_2 = (Integer) randomizedNumbersKeys[1];
        Integer choice_3 = (Integer) randomizedNumbersKeys[2];

        //assigning each number to an imageview
        image_1.setImageResource(NumbersGameLogic.numbers.get(choice_1));
        image_2.setImageResource(NumbersGameLogic.numbers.get(choice_2));
        image_3.setImageResource(NumbersGameLogic.numbers.get(choice_3));

        number_1.setImageResource(choice_1);
        number_2.setImageResource(choice_2);
        number_3.setImageResource(choice_3);
        Integer correctAnswer = (Integer) randomizedNumbersKeys[0];

        number_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();

                if (number_1.getId() == correctAnswer) {
                    Toast.makeText(NumbersGame.this, "You got it right!!", Toast.LENGTH_SHORT).show();
                    count++;
                    global.SetCount(count);

                    //Toast.makeText(LettersGame.this, "This is the current count " + count, Toast.LENGTH_LONG).show();
                    //Toast.makeText(LettersGame.this, "This is the current global count " + global.GetCount(), Toast.LENGTH_LONG).show();


                    Intent intent = new Intent(NumbersGame.this, NumbersGame.class);
                    intent.putExtra(KEY_INDEX, count);
                    startActivity(intent);


                    //play sound
                    //restart game
                } else {
                    Toast.makeText(NumbersGame.this, "try again", Toast.LENGTH_LONG).show();
                }
            }
        });

        number_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();

                if (number_2.getId() == correctAnswer) {
                    Toast.makeText(NumbersGame.this, "You got it right!!", Toast.LENGTH_SHORT).show();
                    count++;
                    global.SetCount(count);

                    //Toast.makeText(LettersGame.this, "This is the current count " + count, Toast.LENGTH_LONG).show();
                    //Toast.makeText(LettersGame.this, "This is the current global count " + global.GetCount(), Toast.LENGTH_LONG).show();


                    Intent intent = new Intent(NumbersGame.this, NumbersGame.class);
                    intent.putExtra(KEY_INDEX, count);
                    startActivity(intent);


                    //play sound
                    //restart game
                } else {
                    Toast.makeText(NumbersGame.this, "try again", Toast.LENGTH_LONG).show();
                }
            }
        });

        number_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();

                if (number_3.getId() == correctAnswer) {
                    Toast.makeText(NumbersGame.this, "You got it right!!", Toast.LENGTH_SHORT).show();
                    count++;
                    global.SetCount(count);

                    //Toast.makeText(LettersGame.this, "This is the current count " + count, Toast.LENGTH_LONG).show();
                    //Toast.makeText(LettersGame.this, "This is the current global count " + global.GetCount(), Toast.LENGTH_LONG).show();


                    Intent intent = new Intent(NumbersGame.this, NumbersGame.class);
                    intent.putExtra(KEY_INDEX, count);
                    startActivity(intent);


                    //play sound
                    //restart game
                } else {
                    Toast.makeText(NumbersGame.this, "try again", Toast.LENGTH_LONG).show();
                }
            }
        });

        image_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();

                if (image_1.getId() == correctAnswer) {
                    Toast.makeText(NumbersGame.this, "You got it right!!", Toast.LENGTH_SHORT).show();
                    count++;
                    global.SetCount(count);

                    //Toast.makeText(LettersGame.this, "This is the current count " + count, Toast.LENGTH_LONG).show();
                    //Toast.makeText(LettersGame.this, "This is the current global count " + global.GetCount(), Toast.LENGTH_LONG).show();


                    Intent intent = new Intent(NumbersGame.this, NumbersGame.class);
                    intent.putExtra(KEY_INDEX, count);
                    startActivity(intent);


                    //play sound
                    //restart game
                } else {
                    Toast.makeText(NumbersGame.this, "try again", Toast.LENGTH_LONG).show();
                }
            }
        });

        image_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();

                if (image_2.getId() == correctAnswer) {
                    Toast.makeText(NumbersGame.this, "You got it right!!", Toast.LENGTH_SHORT).show();
                    count++;
                    global.SetCount(count);

                    //Toast.makeText(LettersGame.this, "This is the current count " + count, Toast.LENGTH_LONG).show();
                    //Toast.makeText(LettersGame.this, "This is the current global count " + global.GetCount(), Toast.LENGTH_LONG).show();


                    Intent intent = new Intent(NumbersGame.this, NumbersGame.class);
                    intent.putExtra(KEY_INDEX, count);
                    startActivity(intent);


                    //play sound
                    //restart game
                } else {
                    Toast.makeText(NumbersGame.this, "try again", Toast.LENGTH_LONG).show();
                }
            }
        });

        image_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();

                if (image_3.getId() == correctAnswer) {
                    Toast.makeText(NumbersGame.this, "You got it right!!", Toast.LENGTH_SHORT).show();
                    count++;
                    global.SetCount(count);

                    //Toast.makeText(LettersGame.this, "This is the current count " + count, Toast.LENGTH_LONG).show();
                    //Toast.makeText(LettersGame.this, "This is the current global count " + global.GetCount(), Toast.LENGTH_LONG).show();


                    Intent intent = new Intent(NumbersGame.this, NumbersGame.class);
                    intent.putExtra(KEY_INDEX, count);
                    startActivity(intent);


                    //play sound
                    //restart game
                } else {
                    Toast.makeText(NumbersGame.this, "try again", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}