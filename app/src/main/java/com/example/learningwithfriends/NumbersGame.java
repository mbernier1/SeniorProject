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
import com.example.learningwithfriends.R.mipmap.*;
import com.example.learningwithfriends.R.drawable.*;


import java.lang.reflect.Array;
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

    Button number_1;
    Button number_2;
    Button number_3;
    Button dots_image_1;
    Button dots_image_2;
    Button dots_image_3;

    /*private static final int[] BUTTON_IDS = {
            R.id.random_number_1,
            R.id.random_number_2,
            R.id.random_number_3,
            R.id.random_number_dots_1,
            R.id.random_number_dots_2,
            R.id.random_number_dots_3
    };*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_game);

        /*number_1 = findViewById(R.id.random_number_1);
        number_2 = findViewById(R.id.random_number_2);
        number_3 = findViewById(R.id.random_number_3);
        dots_image_1 = findViewById(R.id.random_number_dots_1);
        dots_image_2 = findViewById(R.id.random_number_dots_2);
        dots_image_3 = findViewById(R.id.random_number_dots_3);
*/
        //array of buttons to reduce code later
        Button buttons[] = new Button[3];
        buttons[0] = findViewById(R.id.random_number_1);
        buttons[1] = findViewById(R.id.random_number_2);
        buttons[2] = findViewById(R.id.random_number_3);

        Button buttons2[] = new Button[3];
        buttons2[0] = findViewById(R.id.random_number_dots_1);
        buttons2[1] = findViewById(R.id.random_number_dots_2);
        buttons2[2] = findViewById(R.id.random_number_dots_3);

        //initializing a game to play
        NumbersGameLogic startGame = new NumbersGameLogic();

        //randomizing the keys and then pulling the first three out to use for the game
        Object[] randomizedNumbersKeys = startGame.RandomKeyGenerator().toArray();
        Integer choice_1 = (Integer) randomizedNumbersKeys[0];
        Integer choice_2 = (Integer) randomizedNumbersKeys[1];
        Integer choice_3 = (Integer) randomizedNumbersKeys[2];

        //making a list of the chosen keys so I can scramble the at anytime
        //for display purposes
        List<Integer> randomNumbers = new ArrayList<Integer>();
        randomNumbers.add(choice_1);
        randomNumbers.add(choice_2);
        randomNumbers.add(choice_3);
        Collections.shuffle(randomNumbers);

        for(int i = 0, j = 2; i < 3; i++, j--){
            buttons[i].setBackgroundResource(randomNumbers.get(i));
            buttons2[i].setBackgroundResource(NumbersGameLogic.numbers.get(randomNumbers.get(j)));

            buttons[i].setText("cardback");
            buttons2[i].setText("cardback");

            buttons[i].setTextSize(0.0F);
            buttons2[i].setTextSize(0.0F);

            int finalI = i;
            buttons[i].setOnClickListener(view -> {
                if(buttons[finalI].getText() == "cardback"){

                }
            });
        }


















/*


        // setting background of buttons on the right
        dots_image_1.setBackgroundResource(NumbersGameLogic.numbers.get(randomNumbers.get(0)));
        dots_image_2.setBackgroundResource(NumbersGameLogic.numbers.get(randomNumbers.get(1)));
        dots_image_3.setBackgroundResource(NumbersGameLogic.numbers.get(randomNumbers.get(2)));

        // setting background of buttons on the right
        //shuffling the images so that there is less chance of the pairs
        //being right across from the match
        Collections.shuffle(randomNumbers);
        number_1.setBackgroundResource(randomNumbers.get(0));
        number_2.setBackgroundResource(randomNumbers.get(1));
        number_3.setBackgroundResource(randomNumbers.get(2));

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

        });*/

    }
}