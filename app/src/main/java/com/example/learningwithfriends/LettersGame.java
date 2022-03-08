package com.example.learningwithfriends;

import androidx.annotation.NonNull;
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

        //int currentIndex =   savedInstanceState.getInt(KEY_INDEX) ? 0 : count;
        //count = currentIndex;


        if (count < 3) {

            LettersGameLogic startGame = new LettersGameLogic();

            //Object list of letters in random order
            Object[] randlet = startGame.RandomKeyGenerator().toArray();


            // strings containing first 3 letters from the randomized object list
            // of keys from the alphabet
            String choice_1 = (String) randlet[0];
            String choice_2 = (String) randlet[1];
            String choice_3 = (String) randlet[2];

            //setting image from first key of randomized object list

            Random r = new Random();
            int i = r.nextInt(3);

            List<String> choiceList = new ArrayList<>();
            choiceList.add(choice_1);
            choiceList.add(choice_2);
            choiceList.add(choice_3);
            Collections.shuffle(choiceList);

            String correctAnswer = choiceList.get(i);

            //List<String> i = 3 > choiceList.size() ? choiceList.subList(0, choiceList.size()) : choiceList.subList(0, 3);

            Toast.makeText(this, "random str i = " + correctAnswer
                    + "  choice 1 from ranlet = " + choiceList.get(0)
                    + "  choice 1 from ranlet = " + choiceList.get(1)
                    + "  choice 1 from ranlet = " + choiceList.get(2), Toast.LENGTH_LONG).show();

            letter_1.setText(choiceList.get(2));
            letter_2.setText(choiceList.get(0));
            letter_3.setText(choiceList.get(1));
            imageView.setImageResource(LettersGameLogic.letter_icons.get(correctAnswer));

            letter_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();

                    if (letter_1.getText() == correctAnswer) {
                        Toast.makeText(LettersGame.this, "You got it right!!", Toast.LENGTH_SHORT).show();
                        count++;
                        global.SetCount(count);

                        //Toast.makeText(LettersGame.this, "This is the current count " + count, Toast.LENGTH_LONG).show();
                        //Toast.makeText(LettersGame.this, "This is the current global count " + global.GetCount(), Toast.LENGTH_LONG).show();


                        Intent intent = new Intent(LettersGame.this, LettersGame.class);
                        intent.putExtra(KEY_INDEX, count);
                        startActivity(intent);


                        //play sound
                        //restart game
                    } else {
                        Toast.makeText(LettersGame.this, "try again", Toast.LENGTH_LONG).show();
                    }
                }
            });

            letter_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();
                    if (letter_2.getText() == correctAnswer) {
                        Toast.makeText(LettersGame.this, "You got it right!!", Toast.LENGTH_SHORT).show();
                        count++;
                        global.SetCount(count);

                        //Toast.makeText(LettersGame.this, "This is the current count " + count, Toast.LENGTH_LONG).show();
                        //Toast.makeText(LettersGame.this, "This is the current global count " + global.GetCount(), Toast.LENGTH_LONG).show();


                        Intent intent = new Intent(LettersGame.this, LettersGame.class);
                        intent.putExtra(KEY_INDEX, count);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LettersGame.this, "try again", Toast.LENGTH_LONG).show();
                    }
                }
            });

            letter_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();
                    if (letter_3.getText() == correctAnswer) {
                        Toast.makeText(LettersGame.this, "You got it right!!", Toast.LENGTH_SHORT).show();
                        count++;
                        global.SetCount(count);

                        //Toast.makeText(LettersGame.this, "This is the current count " + count, Toast.LENGTH_LONG).show();
                        //Toast.makeText(LettersGame.this, "This is the current global count " + global.GetCount(), Toast.LENGTH_LONG).show();


                        Intent intent = new Intent(LettersGame.this, LettersGame.class);
                        intent.putExtra(KEY_INDEX, count);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LettersGame.this, "try again", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
        else{
            Toast.makeText(this, "You have completed the game", Toast.LENGTH_SHORT).show();
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