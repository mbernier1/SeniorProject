package com.example.learningwithfriends;

import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ShapesGameLogic {

    public static HashMap<String, Integer> shapes = new HashMap<String, Integer>();

    public ShapesGameLogic()
    {
        //Button buttons = new ArrayList<Button>(button1, button2);
        shapes.put("A", R.mipmap.ic_shape_triangle_foreground);
        shapes.put("B", R.mipmap.ic_shape_rectangle_foreground);
        shapes.put("C", R.mipmap.ic_shape_square_foreground);
        shapes.put("D", R.mipmap.ic_shape_circle_foreground);
        shapes.put("E", R.mipmap.ic_shape_star_foreground);
        shapes.put("F", R.mipmap.ic_shape_diamond_foreground);
        shapes.put("G", R.mipmap.ic_shape_heart_foreground);
    }
    //randomizes the letters so each time the game is played different letters will used
    public List<String> RandomKeyGenerator()
    {
        List<String> randomShapes = new ArrayList<>(shapes.keySet());
        Collections.shuffle(randomShapes);

        return randomShapes;
    }
}
