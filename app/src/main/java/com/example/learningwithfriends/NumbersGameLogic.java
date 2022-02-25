package com.example.learningwithfriends;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class NumbersGameLogic {

    public static HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();


    public NumbersGameLogic(){
        numbers.put(R.mipmap.ic_number_1_foreground, R.mipmap.ic_1_dot_foreground);
        numbers.put(R.mipmap.ic_number_2_foreground, R.mipmap.ic_2_dots_foreground);
        numbers.put(R.mipmap.ic_number_3_foreground, R.mipmap.ic_3_dots_foreground);
        numbers.put(R.mipmap.ic_number_4_foreground, R.mipmap.ic_4_dots_foreground);
        numbers.put(R.mipmap.ic_number_5_foreground, R.mipmap.ic_5_dots_foreground);
        numbers.put(R.mipmap.ic_number_6_foreground, R.mipmap.ic_6_dots_foreground);
        numbers.put(R.mipmap.ic_number_7_foreground, R.mipmap.ic_7_dots_foreground);
        numbers.put(R.mipmap.ic_number_8_foreground, R.mipmap.ic_8_dots_foreground);
        numbers.put(R.mipmap.ic_number_9_foreground, R.mipmap.ic_9_dots_foreground);
    }

    //randomizes the letters so each time the game is played different letters will used
    public List<Integer> RandomKeyGenerator()
    {
        List<Integer> randomNumbers = new ArrayList<>(numbers.keySet());
        Collections.shuffle(randomNumbers);

        return randomNumbers;
    }
}
