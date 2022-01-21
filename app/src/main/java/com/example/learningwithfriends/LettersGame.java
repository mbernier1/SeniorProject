package com.example.learningwithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LettersGame extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters_game);

        TextView letter_1 = findViewById(R.id.random_letter_1);
        TextView letter_2 = findViewById(R.id.random_letter_2);
        TextView letter_3 = findViewById(R.id.random_letter_3);

        ImageView random_letter_image = findViewById(R.id.image_of_random_letter);

        letter_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LettersGame.this,"This is a test", Toast.LENGTH_LONG).show();

                /*
                check if choice is correct
                if correct
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
                Toast.makeText(LettersGame.this,"This is a test", Toast.LENGTH_LONG).show();

 /*
                check if choice is correct
                if correct
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
                Toast.makeText(LettersGame.this,"This is a test", Toast.LENGTH_LONG).show();

 /*
                check if choice is correct
                if correct
                    play encouraging sound
                    move to next letter
                else
                    play buzzer
                    try again
                 */
            }
        });

    }
}