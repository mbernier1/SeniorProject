package com.example.learningwithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ShapesGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes_game);

        ImageView imageView1 = findViewById(R.id.shape_image_1);
        ImageView imageView2 = findViewById(R.id.shape_image_2);
        ImageView imageView3 = findViewById(R.id.shape_image_3);
        ImageView imageView4 = findViewById(R.id.shape_image_4);
        ImageView imageView5 = findViewById(R.id.shape_image_5);
        ImageView imageView6 = findViewById(R.id.shape_image_6);


        LettersGameLogic startGame = new LettersGameLogic();

        //Object list of letters in random order
        Object[] randomizedShapes = startGame.RandomKeyGenerator().toArray();

        //List<Integer> randomShapes = new ArrayList<>(ShapesGameLogic.shapes.values());


        imageView1.setImageResource((Integer) randomizedShapes[0]);// .get(0));
        imageView2.setImageResource((Integer) randomizedShapes[1]);//.get(1));
        imageView3.setImageResource((Integer) randomizedShapes[2]);//.get(2));
        imageView4.setImageResource((Integer) randomizedShapes[3]);//.get(3));
        imageView5.setImageResource((Integer) randomizedShapes[4]);//.get(4));
        imageView6.setImageResource((Integer) randomizedShapes[5]);//.get(5));
    }
}