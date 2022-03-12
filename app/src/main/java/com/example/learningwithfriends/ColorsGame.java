package com.example.learningwithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ColorsGame extends AppCompatActivity {

    private final String KEY_INDEX = "index";
    GlobalVariables global = new GlobalVariables();
    int count = global.GetCount();

    ImageView color_1;
    ImageView color_2;
    ImageView color_3;
    ImageView color_4;
    ImageView color_5;
    ImageView color_6;

    Button playSound;

    private SoundPool colorSoundPool;
    private int blue, green,orange, pink, purple, yellow;

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

        playSound = findViewById(R.id.start_sound);

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        colorSoundPool = new SoundPool.Builder()
                .setMaxStreams(6)
                .setAudioAttributes(audioAttributes)
                .build();
        blue = colorSoundPool.load(this, R.raw.blue, 1);
        green = colorSoundPool.load(this, R.raw.green, 1);
        orange = colorSoundPool.load(this, R.raw.orange, 1);
        pink = colorSoundPool.load(this, R.raw.pink, 1);
        purple = colorSoundPool.load(this, R.raw.purple, 1);
        yellow = colorSoundPool.load(this, R.raw.yellow, 1);

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

            playSound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PlaySound(correctAnswer);
                }
            });

            Toast.makeText(ColorsGame.this, "here is the answer "
                    + correctAnswer, Toast.LENGTH_LONG).show();

            color_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (color_1.getContentDescription() == correctAnswer) {
                        Toast.makeText(ColorsGame.this, "That is Correct", Toast.LENGTH_LONG).show();
                        count++;
                        global.SetCount(count);

                        Intent intent = new Intent(ColorsGame.this, ColorsGame.class);
                        intent.putExtra(KEY_INDEX, count);
                        startActivity(intent);

                    } else {
                        Toast.makeText(ColorsGame.this, "try again", Toast.LENGTH_LONG).show();
                        MediaPlayer mediaPlayer = MediaPlayer.create(ColorsGame.this, R.raw.oops_try_again);
                        mediaPlayer.start();
                    }
                }
            });

            color_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (color_2.getContentDescription() == correctAnswer) {
                        Toast.makeText(ColorsGame.this, "That is Correct", Toast.LENGTH_LONG).show();
                        count++;
                        global.SetCount(count);
                        MediaPlayer mediaPlayer = MediaPlayer.create(ColorsGame.this, R.raw.congrats);
                        mediaPlayer.start();

                        Intent intent = new Intent(ColorsGame.this, ColorsGame.class);
                        intent.putExtra(KEY_INDEX, count);
                        startActivity(intent);

                    } else {
                        Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                        MediaPlayer mediaPlayer = MediaPlayer.create(ColorsGame.this, R.raw.oops_try_again);
                        mediaPlayer.start();
                    }
                }
            });

            color_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (color_3.getContentDescription() == correctAnswer) {
                        Toast.makeText(ColorsGame.this, "That is Correct", Toast.LENGTH_LONG).show();
                        count++;
                        global.SetCount(count);
                        MediaPlayer mediaPlayer = MediaPlayer.create(ColorsGame.this, R.raw.congrats);
                        mediaPlayer.start();

                        Intent intent = new Intent(ColorsGame.this, ColorsGame.class);
                        intent.putExtra(KEY_INDEX, count);
                        startActivity(intent);

                    } else {
                        Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                        MediaPlayer mediaPlayer = MediaPlayer.create(ColorsGame.this, R.raw.oops_try_again);
                        mediaPlayer.start();
                    }
                }
            });

            color_4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (color_4.getContentDescription() == correctAnswer) {
                        Toast.makeText(ColorsGame.this, "That is Correct", Toast.LENGTH_LONG).show();
                        count++;
                        global.SetCount(count);
                        MediaPlayer mediaPlayer = MediaPlayer.create(ColorsGame.this, R.raw.congrats);
                        mediaPlayer.start();

                        Intent intent = new Intent(ColorsGame.this, ColorsGame.class);
                        intent.putExtra(KEY_INDEX, count);
                        startActivity(intent);

                    } else {
                        Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                        MediaPlayer mediaPlayer = MediaPlayer.create(ColorsGame.this, R.raw.oops_try_again);
                        mediaPlayer.start();
                    }
                }
            });

            color_5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (color_5.getContentDescription() == correctAnswer) {
                        Toast.makeText(ColorsGame.this, "That is Correct", Toast.LENGTH_LONG).show();
                        count++;
                        global.SetCount(count);
                        MediaPlayer mediaPlayer = MediaPlayer.create(ColorsGame.this, R.raw.congrats);
                        mediaPlayer.start();

                        Intent intent = new Intent(ColorsGame.this, ColorsGame.class);
                        intent.putExtra(KEY_INDEX, count);
                        startActivity(intent);

                    } else {
                        Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                        MediaPlayer mediaPlayer = MediaPlayer.create(ColorsGame.this, R.raw.oops_try_again);
                        mediaPlayer.start();
                    }
                }
            });

            color_6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (color_6.getContentDescription() == correctAnswer) {
                        Toast.makeText(ColorsGame.this, "That is Correct", Toast.LENGTH_LONG).show();
                        count++;
                        global.SetCount(count);
                        MediaPlayer mediaPlayer = MediaPlayer.create(ColorsGame.this, R.raw.congrats);
                        mediaPlayer.start();

                        Intent intent = new Intent(ColorsGame.this, ColorsGame.class);
                        intent.putExtra(KEY_INDEX, count);
                        startActivity(intent);

                    } else {
                        Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                        MediaPlayer mediaPlayer = MediaPlayer.create(ColorsGame.this, R.raw.oops_try_again);
                        mediaPlayer.start();
                    }
                }
            });
        } else {
            Intent intent = new Intent(ColorsGame.this, ChooseGames23.class);
            startActivity(intent);
        }
    }

    public void PlaySound(String sound){
        switch(sound){
            case "blue":
                colorSoundPool.play(blue, 1, 1, 0, 0, 1);
                break;
            case "green":
                colorSoundPool.play(green, 1, 1, 0, 0, 1);
                break;
            case "orange":
                colorSoundPool.play(orange, 1, 1, 0, 0, 1);
                break;
            case "pink":
                colorSoundPool.play(pink, 1, 1, 0, 0, 1);
                break;
            case "purple":
                colorSoundPool.play(purple, 1, 1, 0, 0, 1);
                break;
            case "yellow":
                colorSoundPool.play(yellow, 1, 1, 0, 0, 1);
                break;
        }
    }
}