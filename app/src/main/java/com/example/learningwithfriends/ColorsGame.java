package com.example.learningwithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ColorsGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors_game);

        ImageView color_1 = findViewById(R.id.color1);
        ImageView color_2 = findViewById(R.id.color2);
        ImageView color_3 = findViewById(R.id.color3);
        ImageView color_4 = findViewById(R.id.color4);
        ImageView color_5 = findViewById(R.id.color5);
        //ImageView color_6 = findViewById(R.id.color6);


        List<Integer> Colors = new ArrayList<>();
        Colors.add(R.mipmap.ic_color_blue);
        Colors.add(R.mipmap.ic_color_purple);
        Colors.add(R.mipmap.ic_color_green);
        Colors.add(R.mipmap.ic_color_pink);
        Colors.add(R.mipmap.ic_color_yellow);
        //Colors.add(R.mipmap.ic_color_blue);

        Collections.shuffle(Colors);

        color_1.setImageResource(Colors.get(0));

        color_2.setImageResource(Colors.get(1));

        color_3.setImageResource(Colors.get(2));

        color_4.setImageResource(Colors.get(3));

        color_5.setImageResource(Colors.get(4));

        Collections.shuffle(Colors);
        Integer correctAnswer = Colors.get(0);


        color_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();

                if(color_1.getImageAlpha() == correctAnswer) {
                    Toast.makeText(ColorsGame.this, "That is Correct", Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                }
            }
        });

        color_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(ColorsGame.this, "this is a color 2", Toast.LENGTH_LONG).show();
                if(color_2.getImageAlpha() == correctAnswer) {
                    Toast.makeText(ColorsGame.this, "That is Correct", Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                }
            }
        });

        color_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(ColorsGame.this, "this is a color 3", Toast.LENGTH_LONG).show();
                if(color_3.getImageAlpha() == correctAnswer) {
                    Toast.makeText(ColorsGame.this, "That is Correct", Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                }
            }
        });

        color_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(ColorsGame.this, "this is a color 4", Toast.LENGTH_LONG).show();
                if(color_4.getImageAlpha() == correctAnswer) {
                    Toast.makeText(ColorsGame.this, "That is Correct", Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                }
            }
        });

        color_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(ColorsGame.this, "this is a color 5", Toast.LENGTH_LONG).show();

                if(color_5.getImageAlpha() == correctAnswer) {
                    Toast.makeText(ColorsGame.this, "That is Correct", Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}