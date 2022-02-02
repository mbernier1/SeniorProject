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
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class LettersGame  extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters_game);

        TextView letter_1 = findViewById(R.id.random_letter_1);
        TextView letter_2 = findViewById(R.id.random_letter_2);
        TextView letter_3 = findViewById(R.id.random_letter_3);
        ImageView imageView = findViewById(R.id.image_of_random_letter);

        //List<String> randomLetters = new ArrayList<>(letter_icons.values());
        //Collections.shuffle(randomLetters);
        //ImageView random_letter_image = findViewById(R.id.image_of_random_letter);

        LettersGameLogic.letter_icons.get(3);
        int count = 1;
        while(count<4) {

            LettersGameLogic startGame = new LettersGameLogic();

            //Object list of letters in random order
            Object[] randlet = startGame.RandomKeyGenerator().toArray();


            // string containing 1 letter form the object list
            String choice_1 = (String) randlet[0];
            //String choice_2 = (String) randlet[1];
            //String choice_3 = (String) randlet[2];
            int imageToDisplay;
            //imageView.setImageResource((int) hashMap.get("img"));

            //iterates through map looking for key from random list
            for (String key : LettersGameLogic.letter_icons.keySet()) {
                System.out.println("Key = " + key);
                System.out.println("Choice = " + choice_1);

                //once correct key is found, retrieves image to display
                if(key.equals(choice_1)){
                    System.out.println("Found the key");
                    System.out.println(LettersGameLogic.letter_icons);

                    //picture to display
                    //imageToDisplay = LettersGameLogic.letter_icons.get(key);
                    imageView.setImageResource(LettersGameLogic.letter_icons.get(key));
                } else{
                    System.out.println("Key Not Found");

                }
            }

/*
            Iterator iter = LettersGameLogic.letter_icons.keySet().iterator();
            int count2 = 0;
            if(count2 < 25) {
                for (int i = 0; i < LettersGameLogic.letter_icons.size(); i++) {
                    if (choice_1.equals(LettersGameLogic.GetSingleKey(i))) {
                        System.out.println("Letter Found");
                    } else {
                        System.out.println("Letter not found");
                    }
                }
            }*/





            letter_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();


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
                    Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();

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
                    Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();

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
            count++;
        }
    }
}