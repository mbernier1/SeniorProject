package com.example.learningwithfriends;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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
    boolean selected = false;
    int numSelected = 0;
    String lastSelected = "";

    ImageButton number_1;
    ImageButton number_2;
    ImageButton number_3;
    ImageButton dots_image_1;
    ImageButton dots_image_2;
    ImageButton dots_image_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_game);

        number_1 = findViewById(R.id.random_number_1);
        number_2 = findViewById(R.id.random_number_2);
        number_3 = findViewById(R.id.random_number_3);
        dots_image_1 = findViewById(R.id.random_number_dots_1);
        dots_image_2 = findViewById(R.id.random_number_dots_2);
        dots_image_3 = findViewById(R.id.random_number_dots_3);


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

        dots_image_1.setImageResource(NumbersGameLogic.numbers.get(randomNumbers.get(0)));
        dots_image_2.setImageResource(NumbersGameLogic.numbers.get(randomNumbers.get(1)));
        dots_image_3.setImageResource(NumbersGameLogic.numbers.get(randomNumbers.get(2)));

        Collections.shuffle(randomNumbers);
        number_1.setImageResource(randomNumbers.get(0));
        number_2.setImageResource(randomNumbers.get(1));
        number_3.setImageResource(randomNumbers.get(2));

        number_1.setContentDescription("unclicked");
        number_2.setContentDescription("unclicked");

        number_1.setOnClickListener(view -> {

            if(number_1.getContentDescription() != "clicked" && !selected) {
                number_1.setBackgroundColor(getResources().getColor(R.color.green));
                number_1.setContentDescription("clicked");
                //selected = true;

                if (numSelected == 0) {
                    lastSelected = number_1.getContentDescription().toString();
                }
                numSelected++;
            } else {//if(number_1.getContentDescription() == "clicked") {
                numSelected--;
                //selected = false;
                number_1.setBackgroundColor(getResources().getColor(R.color.black));
            }

            if(numSelected == 2){
                selected = true;
                if(number_1.getContentDescription() == lastSelected){
                    number_1.setClickable(false);
                    selected = false;
                    numSelected = 0;
                    lastSelected = "";
                    number_1.setContentDescription("unclicked");

                }
            }

        });

        number_2.setOnClickListener(view -> {
            //number_2.setContentDescription("clicked");

            if(number_2.getContentDescription() != "clicked" && !selected) {
                number_2.setBackgroundColor(getResources().getColor(R.color.green));
                number_2.setContentDescription("clicked");
                //selected = true;

                if (numSelected == 0) {
                    lastSelected = number_2.getContentDescription().toString();
                }

                numSelected++;
            } else if(number_2.getContentDescription() == "clicked") {
                numSelected--;
                //selected = false;
                number_2.setBackgroundColor(getResources().getColor(R.color.black));
            }

            if(numSelected == 2){
                selected = true;
                if(number_2.getContentDescription() == lastSelected){
                    number_2.setClickable(false);
                    selected = false;
                    numSelected = 0;
                    lastSelected = "";
                    number_2.setContentDescription("unclicked");

                }
            }

        });

    }
}