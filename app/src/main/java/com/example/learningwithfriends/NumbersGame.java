package com.example.learningwithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NumbersGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_game);

        TextView number_1 = findViewById(R.id.random_number_1);
        TextView number_2 = findViewById(R.id.random_number_2);
        TextView number_3 = findViewById(R.id.random_number_3);

        ImageView image_1 = findViewById(R.id.random_number_image_1);
        ImageView image_2 = findViewById(R.id.random_number_image_2);
        ImageView image_3 = findViewById(R.id.random_number_image_3);

        NumbersGameLogic startGame = new NumbersGameLogic();

        Object[] randomizedNumbers = startGame.RandomKeyGenerator().toArray();

        // strings containing first 3 letters form the randomized object list
        // of keys from the alphabet
        Integer choice_1 = (Integer) randomizedNumbers[0];
        Integer choice_2 = (Integer) randomizedNumbers[1];
        Integer choice_3 = (Integer) randomizedNumbers[2];
        //String choice_4 = (String) randomizedColors[3];
        //String choice_5 = (String) randomizedColors[4];
        //String choice_6 = (String) randomizedColors[5];

        //assigning each color to an imageview
        image_1.setImageResource(NumbersGameLogic.numbers.get(choice_1));
        image_2.setImageResource(NumbersGameLogic.numbers.get(choice_2));
        image_3.setImageResource(NumbersGameLogic.numbers.get(choice_3));
        //color_4.setImageResource(ColorsGameLogic.colors.get(choice_4));
        //color_5.setImageResource(ColorsGameLogic.colors.get(choice_5));
        //color_6.setImageResource(ColorsGameLogic.colors.get(choice_6));

        /*number_1.setText(NumbersGameLogic.numbers.get(choice_1));
        number_2.setText(NumbersGameLogic.numbers.get(choice_2));
        number_3.setText(NumbersGameLogic.numbers.get(choice_3));
*/
        Integer correctAnswer = (Integer) randomizedNumbers[0];

    }
}