package com.example.learningwithfriends;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class NumbersGameLogic {

    public static HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();


    public NumbersGameLogic(){
        numbers.put(R.mipmap.ic_number_1, R.mipmap.ic_1_dot);
        numbers.put(R.mipmap.ic_number_2, R.mipmap.ic_2_dots);
        numbers.put(R.mipmap.ic_number_3, R.mipmap.ic_3_dots);
        numbers.put(R.mipmap.ic_number_4, R.mipmap.ic_4_dots);
        numbers.put(R.mipmap.ic_number_5, R.mipmap.ic_5_dots);
        numbers.put(R.mipmap.ic_number_6, R.mipmap.ic_6_dots);
        numbers.put(R.mipmap.ic_number_7, R.mipmap.ic_7_dots);
        numbers.put(R.mipmap.ic_number_8, R.mipmap.ic_8_dots);
        numbers.put(R.mipmap.ic_number_9, R.mipmap.ic_9_dots);


    }

    //randomizes the letters so each time the game is played different letters will used
    public List<Integer> RandomKeyGenerator()
    {
        List<Integer> randomNumbers = new ArrayList<>(numbers.keySet());
        Collections.shuffle(randomNumbers);

        return randomNumbers;
    }

    public List<Integer> RandomValueGenerator()
    {
        List<Integer> randomNumbers = new ArrayList<>(numbers.values());
        Collections.shuffle(randomNumbers);

        return randomNumbers;
    }
}
