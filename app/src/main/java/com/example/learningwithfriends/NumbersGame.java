package com.example.learningwithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NumbersGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_game);

        ImageView number_1 = findViewById(R.id.random_number_1);
        ImageView number_2 = findViewById(R.id.random_number_2);
        ImageView number_3 = findViewById(R.id.random_number_3);

        ImageView image_1 = findViewById(R.id.random_number_dots_1);
        ImageView image_2 = findViewById(R.id.random_number_dots_2);
        ImageView image_3 = findViewById(R.id.random_number_dots_3);

        NumbersGameLogic startGame = new NumbersGameLogic();

        Object[] randomizedNumbersKeys = startGame.RandomKeyGenerator().toArray();
        Object[] randomizedNumbersValues = startGame.RandomValueGenerator().toArray();

        // strings containing first 3 letters form the randomized object list
        // of keys from the alphabet
        Integer choice_1 = (Integer) randomizedNumbersKeys[0];
        Integer choice_2 = (Integer) randomizedNumbersKeys[1];
        Integer choice_3 = (Integer) randomizedNumbersKeys[2];

        //assigning each color to an imageview
        image_1.setImageResource(NumbersGameLogic.numbers.get(choice_1));
        image_2.setImageResource(NumbersGameLogic.numbers.get(choice_2));
        image_3.setImageResource(NumbersGameLogic.numbers.get(choice_3));



        // value whose key is to be searched
        Integer value = 3;

        // iterate each entry of hashmap
        for(Map.Entry<Integer, Integer> entry: NumbersGameLogic.numbers.entrySet()) {

            // if give value is equal to value from entry
            // print the corresponding key
            if(entry.getValue() == value) {
                System.out.println("The key for value " + value + " is " + entry.getKey());
                break;
            }
        }


/*      number_1.setImageResource(choiceList.get(0));
        number_2.setImageResource(choiceList.get(1));
        number_3.setImageResource(choiceList.get(2));
        Integer correctAnswer = (Integer) randomizedNumbers[0];
*/
    }
}