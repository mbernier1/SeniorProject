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

    private SoundPool completedTaskPool;
    private int congrats, good_job;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        count = getIntent().getIntExtra(KEY_INDEX, count);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_game);

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

        if (count < 3) {

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

            for (int i = 0, j = 2; i < 3; i++, j--) {
                numberButtons[i].setBackgroundResource(randomNumbers.get(i));
                dotButtons[i].setBackgroundResource(NumbersGameLogic.numbers.get(randomNumbers.get(j)));

                numberButtons[i].setText("cardback");
                dotButtons[i].setText("cardback");
                numberButtons[i].setTextSize(0.0F);
                dotButtons[i].setTextSize(0.0F);
                int finalI = i;
                int finalJ = j;
                numberButtons[i].setOnClickListener(view -> {
                    if (numberButtons[finalI].getText() == "cardback" && !selected) {

                        numberButtons[finalI].setText(randomNumbers.get(finalI).toString());

                        if (numSelected == 0) {
                            lastSelected = finalI;
                        }
                        numSelected++;

                    } else if (numberButtons[finalI].getText() != "cardback") {

                        numberButtons[finalI].setText("cardback");
                        numSelected--;
                    }
                });

                dotButtons[i].setOnClickListener(view -> {
                    if (dotButtons[finalI].getText() == "cardback" && !selected) {

                        int dotString;

                        for (Map.Entry<Integer, Integer> entry : NumbersGameLogic.numbers.entrySet()) {

                            dotString = entry.getValue();
                            if (NumbersGameLogic.numbers.get(randomNumbers.get(finalJ)) == dotString) {
                                dotButtons[finalI].setText(entry.getKey().toString());
                            }
                        }
                        numSelected++;
                    } else if (dotButtons[finalI].getText() != "cardback") {

                        dotButtons[finalI].setText("cardback");
                        numSelected--;
                    }
                    if (numSelected == 2) {
                        selected = true;

                        String currentDotButton = (String) dotButtons[finalI].getText();
                        String lastSelectedNumberButton = (String) numberButtons[lastSelected].getText();

                        if (currentDotButton.equals(lastSelectedNumberButton)) {

                            dotButtons[finalI].setClickable(false);
                            numberButtons[lastSelected].setClickable(false);
                            selected = false;
                            numSelected = 0;
                            completedTaskPool.play(good_job, 1, 1, 0, 0, 1);
                            matches++;
                            System.out.println("matches = " + matches);

                            if (matches == 3) {
                                completedTaskPool.play(congrats, 1, 1, 0, 0, 1);
                                count++;
                                global.SetCount(count);

                                //make this work for safer coding practices
                                //savedInstanceState.putInt(KEY_INDEX, count);
                                //onCreate(savedInstanceState);

                                Intent intent = new Intent(NumbersGame.this, NumbersGame.class);
                                intent.putExtra(KEY_INDEX, count);
                                startActivity(intent);
                            }
                        }
                    } else if (numSelected == 0) {
                        selected = false;
                    }
                });
            }

        } else {
            completedTaskPool.play(congrats, 1, 1, 0, 0, 1);

            Intent intent = new Intent(NumbersGame.this, ChooseGames23.class);
            startActivity(intent);
        }
    }
}