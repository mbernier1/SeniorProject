package com.example.learningwithfriends;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;



public class LettersGame  extends AppCompatActivity {
    //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
    private final String KEY_INDEX = "index";


    GlobalVariables global = new GlobalVariables();
    private int count = global.GetCount();
    TextView letter_1;
    TextView letter_2;
    TextView letter_3;
    ImageView imageView;
    int m_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        count = getIntent().getIntExtra(KEY_INDEX, count);

        /*if (savedInstanceState != null){
            count = savedInstanceState.getInt(KEY_INDEX);
        }*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters_game);

        letter_1 = findViewById(R.id.random_letter_1);
        letter_2 = findViewById(R.id.random_letter_2);
        letter_3 = findViewById(R.id.random_letter_3);
        imageView = findViewById(R.id.image_of_random_letter);

        //int currentIndex =   savedInstanceState.getInt(KEY_INDEX) ? 0 : count;
        //count = currentIndex;


        if (count < 3) {

            LettersGameLogic startGame = new LettersGameLogic();

            //Object list of letters in random order
            Object[] randlet = startGame.RandomKeyGenerator().toArray();


            // strings containing first 3 letters from the randomized object list
            // of keys from the alphabet
            String choice_1 = (String) randlet[0];
            String choice_2 = (String) randlet[1];
            String choice_3 = (String) randlet[2];

            //setting image from first key of randomized object list
            imageView.setImageResource(LettersGameLogic.letter_icons.get(choice_1));

            //setting first letters to each choice
            //letter_1.setText(choice_1);
            //letter_2.setText(choice_2);
            //letter_3.setText(choice_3);

            //Random r = new Random();
            //int i = r.nextInt(3);

            List<String> choiceList = new ArrayList<>();
            choiceList.add(choice_1);
            choiceList.add(choice_2);
            choiceList.add(choice_3);

            Collections.shuffle(choiceList);
            String correctAnswer = choiceList.get(0);

            letter_1.setText(choiceList.get(0));
            letter_2.setText(choiceList.get(1));
            letter_3.setText(choiceList.get(2));

            letter_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();

                    if (letter_1.getText() == correctAnswer) {
                        Toast.makeText(LettersGame.this, "You got it right!!", Toast.LENGTH_SHORT).show();
                        count++;
                        global.SetCount(count);
                        //savedInstanceState.putInt(KEY_INDEX, count);

                        if (count == 3){
                            Intent intent = new Intent(LettersGame.this, ChooseGames23.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(LettersGame.this, "This is the current count " + count, Toast.LENGTH_LONG).show();
                            Toast.makeText(LettersGame.this, "This is the current global count " + global.GetCount(), Toast.LENGTH_LONG).show();

                        }
                        Intent intent = new Intent(LettersGame.this, LettersGame.class);
                        intent.putExtra(KEY_INDEX, count);
                        startActivity(intent);


                        //play sound
                        //restart game
                    } else {
                        onCreate(savedInstanceState);

                        Toast.makeText(LettersGame.this, "try again", Toast.LENGTH_LONG).show();
                    }
                /*
                check if choice is correct
                if correct
                    count++
                    play encouraging sound
                    move to next letter
                else
                    play buzzer
                    try again
                 */

                }
            });

            letter_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();
                    if (letter_2.getText() == correctAnswer) {
                        Toast.makeText(LettersGame.this, "You got it right!!", Toast.LENGTH_LONG).show();
                        count++;

                    } else {
                        Toast.makeText(LettersGame.this, "try again", Toast.LENGTH_LONG).show();

                    }

 /*
                check if choice is correct
                if correct
                    count++
                    play encouraging sound
                    move to next letter
                else
                    play buzzer
                    try again
                 */
                }
            });

            letter_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();
                    if (letter_3.getText() == correctAnswer) {
                        Toast.makeText(LettersGame.this, "You got it right!!", Toast.LENGTH_LONG).show();
                        count++;

                    } else {
                        Toast.makeText(LettersGame.this, "try again", Toast.LENGTH_LONG).show();

                    }

 /*
                check if choice is correct
                if correct
                    count++
                    play encouraging sound
                    move to next letter
                else
                    play buzzer
                    try again
                 */
                }
            });
            //count++;
        }
        else{
            Toast.makeText(this, "You have completed the game", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LettersGame.this, ChooseGames23.class);
            startActivity(intent);
        }



    }
/*
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("YourTextViewTextIdentifier", yourTextView.getText().toString());

        super.onSaveInstanceState(outState);
    }

    */

    @Override
    public void onSaveInstanceState (Bundle savedInstanceState) {

        savedInstanceState.putInt(KEY_INDEX, count);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        // get values from saved state
        count = savedInstanceState.getInt(KEY_INDEX);
        super.onRestoreInstanceState(savedInstanceState);
    }

}