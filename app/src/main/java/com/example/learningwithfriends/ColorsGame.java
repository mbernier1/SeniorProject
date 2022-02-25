package com.example.learningwithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ColorsGame extends AppCompatActivity {

    private final String KEY_INDEX = "index";
    GlobalVariables global = new GlobalVariables();
    private int count = global.GetCount();

    ImageView color_1;
    ImageView color_2;
    ImageView color_3;
    ImageView color_4;
    ImageView color_5;
    ImageView color_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        count = getIntent().getIntExtra(KEY_INDEX, count);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors_game);

        color_1 = findViewById(R.id.color1);
        color_2 = findViewById(R.id.color2);
        color_3 = findViewById(R.id.color3);
        color_4 = findViewById(R.id.color4);
        color_5 = findViewById(R.id.color5);
        color_6 = findViewById(R.id.color6);

        if (count < 3) {
            ColorsGameLogic startGame = new ColorsGameLogic();

            Object[] randomizedColors = startGame.RandomKeyGenerator().toArray();

            //make second array for color images/strings
            // strings containing first 3 letters form the randomized object list

            // of keys from the alphabet
            String choice_1 = (String) randomizedColors[0];
            String choice_2 = (String) randomizedColors[1];
            String choice_3 = (String) randomizedColors[2];
            String choice_4 = (String) randomizedColors[3];
            String choice_5 = (String) randomizedColors[4];
            String choice_6 = (String) randomizedColors[5];

            color_1.setContentDescription(choice_1);
            color_2.setContentDescription(choice_2);
            color_3.setContentDescription(choice_3);
            color_4.setContentDescription(choice_4);
            color_5.setContentDescription(choice_5);
            color_6.setContentDescription(choice_6);

            //assigning each color to an imageview
            color_1.setImageResource(ColorsGameLogic.colors.get(choice_1));
            color_2.setImageResource(ColorsGameLogic.colors.get(choice_2));
            color_3.setImageResource(ColorsGameLogic.colors.get(choice_3));
            color_4.setImageResource(ColorsGameLogic.colors.get(choice_4));
            color_5.setImageResource(ColorsGameLogic.colors.get(choice_5));
            color_6.setImageResource(ColorsGameLogic.colors.get(choice_6));

            List<String> choiceList = new ArrayList<>();
            choiceList.add(choice_1);
            choiceList.add(choice_2);
            choiceList.add(choice_3);
            choiceList.add(choice_4);
            choiceList.add(choice_5);
            choiceList.add(choice_6);

            Collections.shuffle(choiceList);
            String correctAnswer = choiceList.get(0);

            /*Toast.makeText(ColorsGame.this, "here is the color btn description "
                    + color_1.getContentDescription()
                    + color_2.getContentDescription()
                    + color_3.getContentDescription()
                    + color_4.getContentDescription()
                    + color_5.getContentDescription()
                    + color_6.getContentDescription(), Toast.LENGTH_LONG).show();
*/
            Toast.makeText(ColorsGame.this, "here is the answer "
                    + correctAnswer, Toast.LENGTH_LONG).show();

            color_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();

                    if (color_1.getContentDescription() == correctAnswer) {
                        Toast.makeText(ColorsGame.this, "That is Correct", Toast.LENGTH_LONG).show();
                        count++;
                        global.SetCount(count);

                        //Toast.makeText(LettersGame.this, "This is the current count " + count, Toast.LENGTH_LONG).show();
                        //Toast.makeText(LettersGame.this, "This is the current global count " + global.GetCount(), Toast.LENGTH_LONG).show();


                        Intent intent = new Intent(ColorsGame.this, ColorsGame.class);
                        intent.putExtra(KEY_INDEX, count);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ColorsGame.this, "try again", Toast.LENGTH_LONG).show();
                    }
                }
            });

            color_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(ColorsGame.this, "this is a color 2", Toast.LENGTH_LONG).show();
                    if (color_2.getContentDescription() == correctAnswer) {
                        Toast.makeText(ColorsGame.this, "That is Correct", Toast.LENGTH_LONG).show();
                        count++;
                        global.SetCount(count);

                        //Toast.makeText(LettersGame.this, "This is the current count " + count, Toast.LENGTH_LONG).show();
                        //Toast.makeText(LettersGame.this, "This is the current global count " + global.GetCount(), Toast.LENGTH_LONG).show();


                        Intent intent = new Intent(ColorsGame.this, ColorsGame.class);
                        intent.putExtra(KEY_INDEX, count);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                    }
                }
            });

            color_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(ColorsGame.this, "this is a color 3", Toast.LENGTH_LONG).show();
                    if (color_3.getContentDescription() == correctAnswer) {
                        Toast.makeText(ColorsGame.this, "That is Correct", Toast.LENGTH_LONG).show();
                        count++;
                        global.SetCount(count);

                        //Toast.makeText(LettersGame.this, "This is the current count " + count, Toast.LENGTH_LONG).show();
                        //Toast.makeText(LettersGame.this, "This is the current global count " + global.GetCount(), Toast.LENGTH_LONG).show();


                        Intent intent = new Intent(ColorsGame.this, ColorsGame.class);
                        intent.putExtra(KEY_INDEX, count);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                    }
                }
            });

            color_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(ColorsGame.this, "this is a color 4", Toast.LENGTH_LONG).show();
                    if (color_4.getContentDescription() == correctAnswer) {
                        Toast.makeText(ColorsGame.this, "That is Correct", Toast.LENGTH_LONG).show();
                        count++;
                        global.SetCount(count);

                        //Toast.makeText(LettersGame.this, "This is the current count " + count, Toast.LENGTH_LONG).show();
                        //Toast.makeText(LettersGame.this, "This is the current global count " + global.GetCount(), Toast.LENGTH_LONG).show();


                        Intent intent = new Intent(ColorsGame.this, ColorsGame.class);
                        intent.putExtra(KEY_INDEX, count);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                    }
                }
            });

            color_5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Toast.makeText(ColorsGame.this, "this is a color 5", Toast.LENGTH_LONG).show();

                    if (color_5.getContentDescription() == correctAnswer) {
                        Toast.makeText(ColorsGame.this, "That is Correct", Toast.LENGTH_LONG).show();
                        count++;
                        global.SetCount(count);

                        //Toast.makeText(LettersGame.this, "This is the current count " + count, Toast.LENGTH_LONG).show();
                        //Toast.makeText(LettersGame.this, "This is the current global count " + global.GetCount(), Toast.LENGTH_LONG).show();


                        Intent intent = new Intent(ColorsGame.this, ColorsGame.class);
                        intent.putExtra(KEY_INDEX, count);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                    }
                }
            });

            color_6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Toast.makeText(ColorsGame.this, "this is a color 5", Toast.LENGTH_LONG).show();

                    if (color_6.getContentDescription() == correctAnswer) {
                        Toast.makeText(ColorsGame.this, "That is Correct", Toast.LENGTH_LONG).show();
                        count++;
                        global.SetCount(count);

                        //Toast.makeText(LettersGame.this, "This is the current count " + count, Toast.LENGTH_LONG).show();
                        //Toast.makeText(LettersGame.this, "This is the current global count " + global.GetCount(), Toast.LENGTH_LONG).show();


                        Intent intent = new Intent(ColorsGame.this, ColorsGame.class);
                        intent.putExtra(KEY_INDEX, count);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }else{
            Intent intent = new Intent(ColorsGame.this, ChooseGames23.class);
            startActivity(intent);
        }
    }
}