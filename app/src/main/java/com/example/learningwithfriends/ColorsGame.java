package com.example.learningwithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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


    }
}