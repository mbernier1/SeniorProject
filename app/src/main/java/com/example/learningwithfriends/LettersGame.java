package com.example.learningwithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;


public class LettersGame  extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters_game);

        TextView letter_1 = findViewById(R.id.random_letter_1);
        TextView letter_2 = findViewById(R.id.random_letter_2);
        TextView letter_3 = findViewById(R.id.random_letter_3);
        TextView test = findViewById(R.id.test_view);


        //ImageView random_letter_image = findViewById(R.id.image_of_random_letter);

        int count = 1;
        while(count<4) {

            LettersGameLogic startGame = new LettersGameLogic();
            startGame.RandomLetterGenerator();
            //count += 1;
            for ( String str : startGame)
                System.out.println( str );
            }
            Object[] keys = LettersGameLogic.letter_icons.keySet().toArray();
            for (int i = 0; i<keys.length; i++){
                //Toast.makeText(LettersGame.this, LettersGameLogic.letter_icons.get(i), Toast.LENGTH_LONG).show();
                //test = LettersGameLogic.letter_icons.get(i);

                System.out.println(keys[i]);
            }
            /*

            HashMap <Integer,Integer> hm = new HashMap<Integer,Integer>();

            Set<Integer> keys = hm.keySet();  //get all keys
            for(Integer i: keys)
            {
                System.out.println(hm.get(i));
            }
             */
            /*
            for (Map.Entry<String,String> entry : map.entrySet()) {
              String key = entry.getKey();
              String value = entry.getValue();
              // do stuff
            }
             */

            letter_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();


                /*
                check if choice is correct
                if correct
                    count++
                    play encouraging sound
                    move to next letter
                else
                    play buzzer
                    try again
                 */

                }
            });

            letter_2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();

 /*
                check if choice is correct
                if correct
                    count++
                    play encouraging sound
                    move to next letter
                else
                    play buzzer
                    try again
                 */
                }
            });

            letter_3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(LettersGame.this, "This is a test", Toast.LENGTH_LONG).show();

 /*
                check if choice is correct
                if correct
                    count++
                    play encouraging sound
                    move to next letter
                else
                    play buzzer
                    try again
                 */
                }
            });
        }
    }
}