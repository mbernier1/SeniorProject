package com.example.learningwithfriends;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShapesGame extends AppCompatActivity {

    Button imageView1;
    Button imageView2;
    Button imageView3;
    Button imageView4;
    Button imageView5;
    Button imageView6;
    Button imageView7;
    Button imageView8;

    String choice_1;
    String choice_2;
    String choice_3;
    String choice_4;

    int numClicked = 0;
    boolean clicked = false;
    int lastClicked = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes_game);

        imageView1 = findViewById(R.id.shape_image_1);
        imageView2 = findViewById(R.id.shape_image_2);
        imageView3 = findViewById(R.id.shape_image_3);
        imageView4 = findViewById(R.id.shape_image_4);
        imageView5 = findViewById(R.id.shape_image_5);
        imageView6 = findViewById(R.id.shape_image_6);
        imageView7 = findViewById(R.id.shape_image_7);
        imageView8 = findViewById(R.id.shape_image_8);

        ShapesGameLogic startGame = new ShapesGameLogic();

        //Object list of letters in random order
        Object[] randomizedShapes = startGame.RandomKeyGenerator().toArray();

        //first 4 shapes from randomized list of shapes
        choice_1 = (String) randomizedShapes[0];
        choice_2 = (String) randomizedShapes[1];
        choice_3 = (String) randomizedShapes[2];
        choice_4 = (String) randomizedShapes[3];

        //add choices to a list to reshuffle them dor display
        List<String> randomShapes = new ArrayList<String>();
        randomShapes.add(choice_1);
        randomShapes.add(choice_2);
        randomShapes.add(choice_3);
        randomShapes.add(choice_4);
        Collections.shuffle(randomShapes);

        //setting random image to imageviews
        //imageView1.setBackgroundResource(ShapesGameLogic.shapes.get(randomShapes.get(0)));
        imageView1.setForeground(getDrawable(ShapesGameLogic.shapes.get(randomShapes.get(0))));// (ShapesGameLogic.shapes.get(randomShapes.get(0)));
        imageView3.setForeground(getDrawable(ShapesGameLogic.shapes.get(randomShapes.get(1))));
        imageView5.setForeground(getDrawable(ShapesGameLogic.shapes.get(randomShapes.get(2))));
        imageView7.setForeground(getDrawable(ShapesGameLogic.shapes.get(randomShapes.get(3))));

        //adding a little more randomizing to the views
        Collections.shuffle(randomShapes);

        imageView2.setForeground(getDrawable(ShapesGameLogic.shapes.get(randomShapes.get(2))));
        imageView4.setForeground(getDrawable(ShapesGameLogic.shapes.get(randomShapes.get(0))));
        imageView6.setForeground(getDrawable(ShapesGameLogic.shapes.get(randomShapes.get(3))));
        imageView8.setForeground(getDrawable(ShapesGameLogic.shapes.get(randomShapes.get(1))));

        imageView1.setText("unclicked");

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                Drawable highlight = getResources().getDrawable(R.drawable.highlight);
                imageView1.setBackground(highlight);
                imageView1.setText("hello");
                //imageView1.setTextSize(0.0F);
                numClicked++;
                clicked = true;
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                Drawable highlight = getResources().getDrawable( R.drawable.highlight);
                imageView2.setBackground(highlight);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                Drawable highlight = getResources().getDrawable( R.drawable.highlight);
                imageView3.setBackground(highlight);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                Drawable highlight = getResources().getDrawable( R.drawable.highlight);
                imageView4.setBackground(highlight);
            }
        });

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                Drawable highlight = getResources().getDrawable( R.drawable.highlight);
                imageView5.setBackground(highlight);
            }
        });

        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                Drawable highlight = getResources().getDrawable( R.drawable.highlight);
                imageView6.setBackground(highlight);
            }
        });

        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                Drawable highlight = getResources().getDrawable( R.drawable.highlight);
                imageView7.setBackground(highlight);
            }
        });

        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(ColorsGame.this, "this is a color 1", Toast.LENGTH_LONG).show();
                Drawable highlight = getResources().getDrawable( R.drawable.highlight);
                imageView8.setBackground(highlight);
            }
        });
    }
}