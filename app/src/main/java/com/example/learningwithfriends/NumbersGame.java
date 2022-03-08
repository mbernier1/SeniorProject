package com.example.learningwithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class NumbersGame extends AppCompatActivity {

    GlobalVariables global = new GlobalVariables();
    private final String KEY_INDEX = "index";
    int count = global.GetCount();
    boolean clicked; // = global.GetClicked();
    int numSelected; // = global.GetNumCicked();
    String lastSelected; // = global.GetLastClicked();

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

        //if(count < 3)

        NumbersGameLogic startGame = new NumbersGameLogic();

        Object[] randomizedNumbersKeys = startGame.RandomKeyGenerator().toArray();

        Integer choice_1 = (Integer) randomizedNumbersKeys[0];
        Integer choice_2 = (Integer) randomizedNumbersKeys[1];
        Integer choice_3 = (Integer) randomizedNumbersKeys[2];

        List<Integer> randomNumbers = new ArrayList<Integer>();
        randomNumbers.add(choice_1);
        randomNumbers.add(choice_2);
        randomNumbers.add(choice_3);
        Collections.shuffle(randomNumbers);

        //assigning each number to an imageview
        image_1.setImageResource(NumbersGameLogic.numbers.get(randomNumbers.get(0)));
        image_2.setImageResource(NumbersGameLogic.numbers.get(randomNumbers.get(1)));
        image_3.setImageResource(NumbersGameLogic.numbers.get(randomNumbers.get(2)));

        Collections.shuffle(randomNumbers);

        number_1.setImageResource(randomNumbers.get(0));
        number_2.setImageResource(randomNumbers.get(1));
        number_3.setImageResource(randomNumbers.get(2));

        String correctAnswer = randomNumbers.get(0).toString();

        number_1.setContentDescription(randomNumbers.get(0).toString());
        number_2.setContentDescription(randomNumbers.get(1).toString());
        number_3.setContentDescription(randomNumbers.get(2).toString());

        image_1.setContentDescription(randomNumbers.get(2).toString());
        image_2.setContentDescription(randomNumbers.get(0).toString());
        image_3.setContentDescription(randomNumbers.get(1).toString());


        number_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //global.SetClicked(true);
                clicked = true;
                Drawable highlight = getResources().getDrawable(R.drawable.highlight);
                number_1.setBackground(highlight);
                //global.SetLastClicked(number_1.getContentDescription().toString());

                if(numSelected == 0){

                    lastSelected = number_1.getContentDescription().toString();
                    Toast.makeText(NumbersGame.this, "last checked is " + lastSelected, Toast.LENGTH_LONG).show();

                }
                //global.SetNumClicked( numSelected + 1);
                numSelected++;

                Toast.makeText(NumbersGame.this, "the current numSelected is " + numSelected, Toast.LENGTH_SHORT).show();


                if (numSelected == 2) {
                    if (number_1.getContentDescription().toString().equals(lastSelected)) {

                        count++;
                        global.SetCount(count);

                        Toast.makeText(NumbersGame.this, "That's correct!", Toast.LENGTH_LONG).show();
                        //Toast.makeText(LettersGame.this, "This is the current global count " + global.GetCount(), Toast.LENGTH_LONG).show();


                        //Intent intent = new Intent(NumbersGame.this, NumbersGame.class);
                        //intent.putExtra(KEY_INDEX, count);
                        //startActivity(intent);

                        numSelected = 0;
                        //play sound
                        //restart game
                    } else {
                        Toast.makeText(NumbersGame.this, "try again", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        number_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();

                //global.SetClicked(true);
                clicked = true;
                Drawable highlight = getResources().getDrawable(R.drawable.highlight);
                number_2.setBackground(highlight);
                //global.SetLastClicked(number_1.getContentDescription().toString());

                if(numSelected == 0){

                    lastSelected = number_2.getContentDescription().toString();
                }
                //global.SetNumClicked( numSelected + 1);
                numSelected++;

                Toast.makeText(NumbersGame.this, "the current numSelected is " + numSelected, Toast.LENGTH_SHORT).show();


                if (numSelected == 2) {
                    if (number_2.getContentDescription().toString().equals(lastSelected)) {


                        count++;
                        global.SetCount(count);
                        Toast.makeText(NumbersGame.this, "That's correct!", Toast.LENGTH_LONG).show();

                        //Toast.makeText(LettersGame.this, "This is the current count " + count, Toast.LENGTH_LONG).show();
                        //Toast.makeText(LettersGame.this, "This is the current global count " + global.GetCount(), Toast.LENGTH_LONG).show();


                        //Intent intent = new Intent(NumbersGame.this, NumbersGame.class);
                        //intent.putExtra(KEY_INDEX, count);
                        //startActivity(intent);

                        numSelected = 0;

                        //play sound
                        //restart game
                    } else {
                        Toast.makeText(NumbersGame.this, "try again", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        number_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();
//global.SetClicked(true);
                clicked = true;
                Drawable highlight = getResources().getDrawable(R.drawable.highlight);
                number_3.setBackground(highlight);
                //global.SetLastClicked(number_1.getContentDescription().toString());

                if (numSelected == 0) {

                    lastSelected = number_3.getContentDescription().toString();
                }
                //global.SetNumClicked( numSelected + 1);
                numSelected++;

                Toast.makeText(NumbersGame.this, "the current numSelected is " + numSelected, Toast.LENGTH_SHORT).show();


                if (numSelected == 2) {
                    if (number_3.getContentDescription().toString().equals(lastSelected)) {


                        count++;
                        global.SetCount(count);
                        Toast.makeText(NumbersGame.this, "That's correct!", Toast.LENGTH_LONG).show();

                        //Toast.makeText(LettersGame.this, "This is the current count " + count, Toast.LENGTH_LONG).show();
                        //Toast.makeText(LettersGame.this, "This is the current global count " + global.GetCount(), Toast.LENGTH_LONG).show();


                        //Intent intent = new Intent(NumbersGame.this, NumbersGame.class);
                        //intent.putExtra(KEY_INDEX, count);
                        //startActivity(intent);

                        numSelected = 0;
                        lastSelected = "";
                        //play sound
                        //restart game
                    } else {
                        Toast.makeText(NumbersGame.this, "try again", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        image_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();

                //global.SetClicked(true);
                clicked = true;
                Drawable highlight = getResources().getDrawable(R.drawable.highlight);
                image_1.setBackground(highlight);

                //global.SetLastClicked(number_1.getContentDescription().toString());

                if(numSelected == 0){

                    lastSelected = image_1.getContentDescription().toString();
                }
                //global.SetNumClicked( numSelected + 1);
                numSelected++;

                Toast.makeText(NumbersGame.this, "the current numSelected is " + numSelected, Toast.LENGTH_SHORT).show();


                if (numSelected == 2) {
                    if (image_1.getContentDescription().toString().equals(lastSelected)) {

                        Toast.makeText(NumbersGame.this, "That's correct!", Toast.LENGTH_LONG).show();


                        count++;
                        global.SetCount(count);

                        //Toast.makeText(LettersGame.this, "This is the current count " + count, Toast.LENGTH_LONG).show();
                        //Toast.makeText(LettersGame.this, "This is the current global count " + global.GetCount(), Toast.LENGTH_LONG).show();


                        //Intent intent = new Intent(NumbersGame.this, NumbersGame.class);
                        //intent.putExtra(KEY_INDEX, count);
                        //startActivity(intent);

                        numSelected = 0;

                        //play sound
                        //restart game
                    } else {
                        Toast.makeText(NumbersGame.this, "try again", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        image_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();

                //global.SetClicked(true);
                clicked = true;
                Drawable highlight = getResources().getDrawable(R.drawable.highlight);
                image_2.setBackground(highlight);
                //global.SetLastClicked(number_1.getContentDescription().toString());

                if(numSelected == 0){

                    lastSelected = image_2.getContentDescription().toString();
                }
                //global.SetNumClicked( numSelected + 1);
                numSelected++;

                Toast.makeText(NumbersGame.this, "the current numSelected is " + numSelected, Toast.LENGTH_SHORT).show();


                if (numSelected == 2) {
                    if (image_2.getContentDescription().toString().equals(lastSelected)) {


                        Toast.makeText(NumbersGame.this, "That's correct!", Toast.LENGTH_LONG).show();

                        count++;
                        global.SetCount(count);

                        //Toast.makeText(LettersGame.this, "This is the current count " + count, Toast.LENGTH_LONG).show();
                        //Toast.makeText(LettersGame.this, "This is the current global count " + global.GetCount(), Toast.LENGTH_LONG).show();


                        //Intent intent = new Intent(NumbersGame.this, NumbersGame.class);
                        //intent.putExtra(KEY_INDEX, count);
                        //startActivity(intent);

                        numSelected = 0;

                        //play sound
                        //restart game
                    } else {
                        Toast.makeText(NumbersGame.this, "try again", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        image_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();

                //global.SetClicked(true);
                clicked = true;
                Drawable highlight = getResources().getDrawable(R.drawable.highlight);
                image_3.setBackground(highlight);
                //global.SetLastClicked(number_1.getContentDescription().toString());

                if(numSelected == 0){

                    lastSelected = image_3.getContentDescription().toString();

                }
                //global.SetNumClicked( numSelected + 1);
                numSelected++;

                Toast.makeText(NumbersGame.this, "the current numSelected is " + numSelected, Toast.LENGTH_SHORT).show();


                if (numSelected == 2) {
                    if (image_3.getContentDescription().toString().equals(lastSelected)) {

                        Toast.makeText(NumbersGame.this, "That's correct!", Toast.LENGTH_LONG).show();


                        count++;
                        global.SetCount(count);

                        //Toast.makeText(LettersGame.this, "This is the current count " + count, Toast.LENGTH_LONG).show();
                        //Toast.makeText(LettersGame.this, "This is the current global count " + global.GetCount(), Toast.LENGTH_LONG).show();


                        //Intent intent = new Intent(NumbersGame.this, NumbersGame.class);
                        //intent.putExtra(KEY_INDEX, count);
                        //startActivity(intent);

                        numSelected = 0;

                        //play sound
                        //restart game
                    } else {
                        Toast.makeText(NumbersGame.this, "try again", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}