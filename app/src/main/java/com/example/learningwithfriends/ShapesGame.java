package com.example.learningwithfriends;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
        ImageView imageView7 = findViewById(R.id.shape_image_7);
        ImageView imageView8 = findViewById(R.id.shape_image_8);

        ShapesGameLogic startGame = new ShapesGameLogic();

        //Object list of letters in random order
        Object[] randomizedShapes = startGame.RandomKeyGenerator().toArray();

        //frist 4 shapes from randomized list of shapes
        String choice_1 = (String) randomizedShapes[0];
        String choice_2 = (String) randomizedShapes[1];
        String choice_3 = (String) randomizedShapes[2];
        String choice_4 = (String) randomizedShapes[3];

        //add choices to a list to reshuffle them dor display
        List<String> randomShapes = new ArrayList<String>();
        randomShapes.add(choice_1);
        randomShapes.add(choice_2);
        randomShapes.add(choice_3);
        randomShapes.add(choice_4);
        Collections.shuffle(randomShapes);

        //setting random image to imageviews
        imageView1.setImageResource(ShapesGameLogic.shapes.get(randomShapes.get(0)));
        imageView3.setImageResource(ShapesGameLogic.shapes.get(randomShapes.get(1)));
        imageView5.setImageResource(ShapesGameLogic.shapes.get(randomShapes.get(2)));
        imageView7.setImageResource(ShapesGameLogic.shapes.get(randomShapes.get(3)));

        //adding a little more randomizing to the views
        Collections.shuffle(randomShapes);

        imageView2.setImageResource(ShapesGameLogic.shapes.get(randomShapes.get(2)));
        imageView4.setImageResource(ShapesGameLogic.shapes.get(randomShapes.get(0)));
        imageView6.setImageResource(ShapesGameLogic.shapes.get(randomShapes.get(3)));
        imageView8.setImageResource(ShapesGameLogic.shapes.get(randomShapes.get(1)));
    }
}