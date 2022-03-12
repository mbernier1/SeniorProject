package com.example.learningwithfriends;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;



public class LettersGame  extends AppCompatActivity {
    //SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
    private final String KEY_INDEX = "index";


    GlobalVariables global = new GlobalVariables();
    int count = global.GetCount();
    TextView letter_1;
    TextView letter_2;
    TextView letter_3;
    ImageView imageView;

    private SoundPool completedTaskPool;
    private int congrats, good_job;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        count = getIntent().getIntExtra(KEY_INDEX, count);

        /*if (savedInstanceState != null){
            count = savedInstanceState.getInt(KEY_INDEX);
        }*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters_game);

        letter_1 = findViewById(R.id.random_letter_1);
        letter_2 = findViewById(R.id.random_letter_2);
        letter_3 = findViewById(R.id.random_letter_3);
        imageView = findViewById(R.id.image_of_random_letter);

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


        if (count < 3) {

            LettersGameLogic startGame = new LettersGameLogic();

            //Object list of letters in random order
            Object[] randlet = startGame.RandomKeyGenerator().toArray();

            // strings containing first 3 letters from the randomized object list
            // of keys from the alphabet
            String choice_1 = (String) randlet[0];
            String choice_2 = (String) randlet[1];
            String choice_3 = (String) randlet[2];

            Random r = new Random();
            int i = r.nextInt(3);

            List<String> choiceList = new ArrayList<>();
            choiceList.add(choice_1);
            choiceList.add(choice_2);
            choiceList.add(choice_3);
            Collections.shuffle(choiceList);

            String correctAnswer = choiceList.get(i);

            letter_1.setText(choiceList.get(2));
            letter_2.setText(choiceList.get(0));
            letter_3.setText(choiceList.get(1));
            imageView.setImageResource(LettersGameLogic.letter_icons.get(correctAnswer));

            letter_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (letter_1.getText() == correctAnswer) {
                        Toast.makeText(LettersGame.this, "You got it right!!", Toast.LENGTH_SHORT).show();
                        count++;
                        global.SetCount(count);

                        completedTaskPool.play(good_job, 1, 1, 0, 0, 1);

                        Intent intent = new Intent(LettersGame.this, LettersGame.class);
                        intent.putExtra(KEY_INDEX, count);
                        startActivity(intent);

                    } else {
                        Toast.makeText(LettersGame.this, "try again", Toast.LENGTH_LONG).show();
                        MediaPlayer mediaPlayer = MediaPlayer.create(LettersGame.this, R.raw.oops_try_again);
                        mediaPlayer.start();
                    }
                }
            });

            letter_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (letter_2.getText() == correctAnswer) {
                        Toast.makeText(LettersGame.this, "You got it right!!", Toast.LENGTH_SHORT).show();
                        count++;
                        global.SetCount(count);

                        completedTaskPool.play(good_job, 1, 1, 0, 0, 1);

                        Intent intent = new Intent(LettersGame.this, LettersGame.class);
                        intent.putExtra(KEY_INDEX, count);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LettersGame.this, "try again", Toast.LENGTH_LONG).show();
                        MediaPlayer mediaPlayer = MediaPlayer.create(LettersGame.this, R.raw.oops_try_again);
                        mediaPlayer.start();
                    }
                }
            });

            letter_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (letter_3.getText() == correctAnswer) {
                        Toast.makeText(LettersGame.this, "You got it right!!", Toast.LENGTH_SHORT).show();
                        count++;
                        global.SetCount(count);

                        completedTaskPool.play(good_job, 1, 1, 0, 0, 1);


                        Intent intent = new Intent(LettersGame.this, LettersGame.class);
                        intent.putExtra(KEY_INDEX, count);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LettersGame.this, "try again", Toast.LENGTH_LONG).show();
                        MediaPlayer mediaPlayer = MediaPlayer.create(LettersGame.this, R.raw.oops_try_again);
                        mediaPlayer.start();
                    }
                }
            });
        }
        else{
            completedTaskPool.play(congrats, 1, 1, 0, 0, 1);

            Intent intent = new Intent(LettersGame.this, ChooseGames23.class);
            startActivity(intent);
        }
    }

    @Override
    public void onSaveInstanceState (Bundle savedInstanceState) {

        savedInstanceState.putInt(KEY_INDEX, count);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        // get values from saved state
        count = savedInstanceState.getInt(KEY_INDEX);
        super.onRestoreInstanceState(savedInstanceState);
    }
}