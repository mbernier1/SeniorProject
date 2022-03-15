package com.example.learningwithfriends;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.SoundPool;
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
    int lastSelected = -1;
    int matches = 0;

    Button number_1;
    Button number_2;
    Button number_3;
    Button dots_image_1;
    Button dots_image_2;
    Button dots_image_3;

    private SoundPool completedTaskPool;
    private int congrats, good_job;


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
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        completedTaskPool = new SoundPool.Builder()
                .setMaxStreams(2)
                .setAudioAttributes(audioAttributes)
                .build();
        congrats = completedTaskPool.load(this, R.raw.congrats, 1);
        good_job = completedTaskPool.load(this, R.raw.good_job, 1);

        //array of buttons to reduce code later
        Button[] numberButtons = new Button[3];
        numberButtons[0] = findViewById(R.id.random_number_1);
        numberButtons[1] = findViewById(R.id.random_number_2);
        numberButtons[2] = findViewById(R.id.random_number_3);

        Button[] dotButtons = new Button[3];
        dotButtons[0] = findViewById(R.id.random_number_dots_1);
        dotButtons[1] = findViewById(R.id.random_number_dots_2);
        dotButtons[2] = findViewById(R.id.random_number_dots_3);

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

        //int var = NumbersGameLogic.numbers.get(randomNumbers.get(2));
        //int var2 = NumbersGameLogic.numbers.get(2);
        //Toast.makeText(this, var + var2, Toast.LENGTH_SHORT).show();

        for(int i = 0, j = 2; i < 3; i++, j--){
            numberButtons[i].setBackgroundResource(randomNumbers.get(i));
            dotButtons[i].setBackgroundResource(NumbersGameLogic.numbers.get(randomNumbers.get(j)));

            //randomNumbers.get(i) = gets they key
            //NumbersGameLogic.numbers.get(randomNumbers.get(j)) = gets the value of key(j)
            /*int keyTest1 = 0;

            for (Map.Entry<Integer, Integer> entry : NumbersGameLogic.numbers.entrySet()) {
                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                keyTest1 = entry.getValue();

                if(NumbersGameLogic.numbers.get(randomNumbers.get(j)) == keyTest1)
                {
                    dotButtons[i].setText(entry.getKey().toString());
                }
            }*/
            numberButtons[i].setText("cardback");
            dotButtons[i].setText("cardback");
            //buttons[i].setTextSize(0.0F);
            //buttons2[i].setTextSize(0.0F);
            int finalI = i;
            int finalJ = j;
            numberButtons[i].setOnClickListener(view -> {
                if(numberButtons[finalI].getText() == "cardback" && !selected){

                    numberButtons[finalI].setText(randomNumbers.get(finalI).toString());

                    if(numSelected == 0){
                        lastSelected = finalI;
                    }
                    numSelected++;

                } else if(numberButtons[finalI].getText() != "cardback" ) {

                    numberButtons[finalI].setText("cardback");
                    numSelected--;
                }
/*
                if(numSelected == 2){
                    selected = true;
                    int keyTest = 0;

                    /*for (Map.Entry<Integer, Integer> entry : NumbersGameLogic.numbers.entrySet()) {
                        System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                        keyTest = entry.getValue();

                        if (NumbersGameLogic.numbers.get(randomNumbers.get(finalJ)) == keyTest) {
                            dotButtons[finalI].setText(entry.getKey().toString());
                        }
                    }
                    System.out.println("this is the number buttons");
                    System.out.println("last selected " + lastSelected + " " + numberButtons[lastSelected].getText() +
                            " current dot button text " + dotButtons[finalI].getText());


                    if(numberButtons[lastSelected].getText() == dotButtons[finalI].getText() ) {


                        //if (dotButtons[finalI].getText().toString().equals(randomNumbers.get(lastSelected).toString())) {
                        dotButtons[finalI].setClickable(false);
                        numberButtons[lastSelected].setClickable(false);
                        selected = false;
                        numSelected = 0;
                        completedTaskPool.play(good_job, 1, 1, 0, 0, 1);
                        matches++;
                        if (matches == 3) {
                            completedTaskPool.play(congrats, 1, 1, 0, 0, 1);

                            Intent intent = new Intent(NumbersGame.this, NumbersGame.class);
                            //intent.putExtra(KEY_INDEX, count);
                            startActivity(intent);
                        }
                        //}
                    }

                    //if(buttons2[finalI].getText()  == buttons[(Integer) NumbersGameLogic.numbers.get(randomNumbers.get(lastSelected))]){
                } else if (numSelected == 0){
                    selected = false;
                }*/
            });

            dotButtons[i].setOnClickListener(view -> {
                 if (dotButtons[finalI].getText() == "cardback" && !selected) {

                     int dotString;

                     for (Map.Entry<Integer, Integer> entry : NumbersGameLogic.numbers.entrySet()) {
                         System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                         dotString = entry.getValue();

                         if(NumbersGameLogic.numbers.get(randomNumbers.get(finalJ)) == dotString)
                         {
                             dotButtons[finalI].setText(entry.getKey().toString());
                         }

                     }
                    //buttons2[finalI].setBackgroundResource(NumbersGameLogic.numbers.get(randomNumbers.get(finalJ)));
                    numSelected++;

                 } else if(dotButtons[finalI].getText() != "cardback"){

                     dotButtons[finalI].setText("cardback");
                     numSelected--;
                }

                if(numSelected == 2){
                    selected = true;
                    int keyTest = 0;

                    /*for (Map.Entry<Integer, Integer> entry : NumbersGameLogic.numbers.entrySet()) {
                        System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
                        keyTest = entry.getValue();

                        if (NumbersGameLogic.numbers.get(randomNumbers.get(finalJ)) == keyTest) {
                            dotButtons[finalI].setText(entry.getKey().toString());
                        }
                    }*/
                        System.out.println("last selected " + lastSelected + " " + numberButtons[lastSelected].getText() +
                                " current dot button text " + dotButtons[finalI].getText());


                        if(numberButtons[lastSelected].getText() == dotButtons[finalI].getText()) {


                            //if (dotButtons[finalI].getText().toString().equals(randomNumbers.get(lastSelected).toString())) {
                                dotButtons[finalI].setClickable(false);
                                numberButtons[lastSelected].setClickable(false);
                                selected = false;
                                numSelected = 0;
                                completedTaskPool.play(good_job, 1, 1, 0, 0, 1);
                                matches++;
                            System.out.println("matches = " + matches);

                            if (matches == 3) {
                                    completedTaskPool.play(congrats, 1, 1, 0, 0, 1);

                                    Intent intent = new Intent(NumbersGame.this, NumbersGame.class);
                                    //intent.putExtra(KEY_INDEX, count);
                                    startActivity(intent);
                            }
                            //}
                        }

                    //if(buttons2[finalI].getText()  == buttons[(Integer) NumbersGameLogic.numbers.get(randomNumbers.get(lastSelected))]){
                } else if (numSelected == 0){
                    selected = false;
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