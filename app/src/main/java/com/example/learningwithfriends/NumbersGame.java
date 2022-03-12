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
        Button[] buttons = new Button[3];
        buttons[0] = findViewById(R.id.random_number_1);
        buttons[1] = findViewById(R.id.random_number_2);
        buttons[2] = findViewById(R.id.random_number_3);

        Button[] buttons2 = new Button[3];
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

        Toast.makeText(this, randomizedNumbersKeys[0].toString(), Toast.LENGTH_LONG).show();
        Toast.makeText(this, randomNumbers.get(0).toString(), Toast.LENGTH_LONG).show();
        Toast.makeText(this, randomNumbers.get(1), Toast.LENGTH_LONG).show();
        Toast.makeText(this, randomNumbers.get(2).toString(), Toast.LENGTH_LONG).show();
        Toast.makeText(this, randomizedNumbersKeys[0].toString(), Toast.LENGTH_LONG).show();

        int var = NumbersGameLogic.numbers.get(randomNumbers.get(2));
        int var2 = NumbersGameLogic.numbers.get(2);
        Toast.makeText(this, var + var2, Toast.LENGTH_SHORT).show();

        for(int i = 0, j = 2; i < 3; i++, j--){
            //buttons[i].setBackgroundResource(randomNumbers.get(i));
            buttons2[i].setBackgroundResource(NumbersGameLogic.numbers.get(randomNumbers.get(j)));

            //int var = NumbersGameLogic.numbers.get(randomNumbers.get(2));
            //int var2 = NumbersGameLogic.numbers.get(2);
            //Toast.makeText(this, var + var2, Toast.LENGTH_SHORT).show();

            buttons[i].setText("cardback");
            buttons2[i].setText("cardback");


            //buttons[i].setTextSize(0.0F);
            //buttons2[i].setTextSize(0.0F);

            int finalI = i;
            int finalJ = j;
            buttons[i].setOnClickListener(view -> {
                if((buttons[finalI].getText() == "cardback" && buttons2[finalI].getText() == "cardback") && !selected){

                    buttons[finalI].setText("cardfront");
                    //buttons2[finalI].setText("cardfront");

                    buttons[finalI].setBackgroundResource(randomNumbers.get(finalI));
                    //buttons2[finalI].setBackgroundResource(NumbersGameLogic.numbers.get(randomNumbers.get(finalJ)));

                    if(numSelected == 0){
                        lastSelected = finalI;
                    }
                    numSelected++;

                } else if(buttons[finalI].getText() != "cardback" && buttons2[finalI].getText() != "cardback") {

                    buttons[finalI].setBackgroundResource(R.mipmap.ic_ball);
                    buttons[finalI].setText("cardback");
                    buttons2[finalI].setText("cardback");
                    numSelected--;
                }


                if(numSelected == 2){
                    selected = true;
                    if(buttons2[NumbersGameLogic.numbers.get(randomNumbers.get(finalI))] == buttons[NumbersGameLogic.numbers.get(randomNumbers.get(lastSelected))]){
                        buttons2[finalI].setClickable(false);
                        buttons[lastSelected].setClickable(false);
                        selected = false;
                        numSelected = 0;
                        completedTaskPool.play(good_job, 1, 1, 0, 0, 1);

                        //lastSelected = -1;
                        matches++;
                        if(matches == 3)
                        {
                            Intent intent = new Intent(NumbersGame.this, NumbersGame.class);
                            //intent.putExtra(KEY_INDEX, count);
                            startActivity(intent);
                        }
                    }
                } else if (numSelected == 0){
                    selected = false;
                }
            });

            buttons2[i].setOnClickListener(view -> {
                 if (buttons2[finalI].getText() == "cardback" && !selected) {

                    buttons2[finalI].setText("cardfront");
                    buttons2[finalI].setBackgroundResource(NumbersGameLogic.numbers.get(randomNumbers.get(finalJ)));
                    numSelected++;

                 } else if(buttons2[finalI].getText() != "cardback"){

                    buttons2[finalI].setBackgroundResource(R.mipmap.ic_ball);
                    buttons2[finalI].setText("cardback");
                    numSelected--;

                }

                if(numSelected == 2){
                    selected = true;
                    if(buttons2[finalI].getText()  == buttons[(Integer) NumbersGameLogic.numbers.get(randomNumbers.get(lastSelected))]){
                        buttons2[finalI].setClickable(false);
                        buttons[lastSelected].setClickable(false);
                        selected = false;
                        numSelected = 0;
                        completedTaskPool.play(good_job, 1, 1, 0, 0, 1);

                        // lastSelected = -1;
                        matches++;
                        if(matches == 3)
                        {
                            completedTaskPool.play(congrats, 1, 1, 0, 0, 1);

                            Intent intent = new Intent(NumbersGame.this, NumbersGame.class);
                            //intent.putExtra(KEY_INDEX, count);
                            startActivity(intent);
                        }
                    }
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