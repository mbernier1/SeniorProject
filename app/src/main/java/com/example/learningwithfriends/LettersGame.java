package com.example.learningwithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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


    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters_game);

        TextView letter_1 = findViewById(R.id.random_letter_1);
        TextView letter_2 = findViewById(R.id.random_letter_2);
        TextView letter_3 = findViewById(R.id.random_letter_3);
        ImageView imageView = findViewById(R.id.image_of_random_letter);

        if(count < 3) {

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

            List<String> choiceList = new ArrayList<>();
            choiceList.add(choice_1);
            choiceList.add(choice_2);
            choiceList.add(choice_3);

            Random r = new Random();
            int i = r.nextInt(3);

            Collections.shuffle(choiceList);
            String correctAnswer = choiceList.get(0);

            letter_1.setText(choiceList.get(0));
            letter_2.setText(choiceList.get(1));
            letter_3.setText(choiceList.get(2));

            letter_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();

                    if (letter_1.getText() == correctAnswer)
                    {
                        Toast.makeText(LettersGame.this, "You got it right!!", Toast.LENGTH_LONG).show();
                        count++;

                        //play sound
                        //restart game
                    }
                    else{
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
                    if (letter_2.getText() == correctAnswer)
                    {
                        Toast.makeText(LettersGame.this, "You got it right!!", Toast.LENGTH_LONG).show();
                        count++;

                    }
                    else{
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
                    if (letter_3.getText() == correctAnswer)
                    {
                        Toast.makeText(LettersGame.this, "You got it right!!", Toast.LENGTH_LONG).show();
                        count++;
                    }
                    else{
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
        }

    }
/*
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("YourTextViewTextIdentifier", yourTextView.getText().toString());

        super.onSaveInstanceState(outState);
    }
    */

}