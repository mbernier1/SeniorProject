package com.example.learningwithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
            Object[] keys = startGame.GetKeys().toArray();
            Object[] values = startGame.GetValues().toArray();

            Object[] randlet = startGame.RandomKeyGenerator().toArray();

            Object[] randKeys = startGame.GetKeys().toArray();
            Object[] randValues = startGame.GetValues().toArray();
            startGame.GetValues();

            //count += 1;

            for (int i = 0; i<randlet.length; i++){

                System.out.println(randlet[i]);
            }
            String str = randlet[25].toString();


            System.out.println(randlet[3]);
            System.out.println(str);
            System.out.println(startGame);

            for (int i = 0; i < 26; i++) {
                System.out.println(Arrays.toString(keys));
                System.out.println(Arrays.toString(values));
                i++;
            }
            for (int i = 0; i < 26; i++) {
                System.out.println(Arrays.toString(randKeys));
                System.out.println(Arrays.toString(randValues));
                i++;
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
            count++;
        }
    }
}