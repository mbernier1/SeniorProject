package com.example.learningwithfriends;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ShapesGameLogic {

    public static HashMap<String, Integer> shapes = new HashMap<String, Integer>();

    public ShapesGameLogic()
    {
        shapes.put("A", R.mipmap.ic_shape_triangle);
        shapes.put("B", R.mipmap.ic_shape_rectangle);
        shapes.put("C", R.mipmap.ic_shape_square);
        shapes.put("D", R.mipmap.ic_shape_circle);
        shapes.put("E", R.mipmap.ic_shape_star);
        shapes.put("F", R.mipmap.ic_shape_diamond);
        shapes.put("G", R.mipmap.ic_shape_heart);
    }
    //randomizes the letters so each time the game is played different letters will used
    public List<String> RandomKeyGenerator()
    {
        List<String> randomShapes = new ArrayList<>(shapes.keySet());
        Collections.shuffle(randomShapes);

        return randomShapes;
    }
}
