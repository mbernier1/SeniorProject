package com.example.learningwithfriends;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class LettersGameLogic {

    public static HashMap<String, Integer> letter_icons = new HashMap<String, Integer>();

    public LettersGameLogic()
    {
        letter_icons.put("A", R.mipmap.ic_apple);
        letter_icons.put("B", R.mipmap.ic_ball);
        letter_icons.put("C", R.mipmap.ic_car);
        letter_icons.put("D", R.mipmap.ic_duck);
        letter_icons.put("E", R.mipmap.ic_elephant);
        letter_icons.put("F", R.mipmap.ic_fish);
        letter_icons.put("G", R.mipmap.ic_grapes);
        letter_icons.put("H", R.mipmap.ic_hat);
        letter_icons.put("I", R.mipmap.ic_ice_cream);
        letter_icons.put("J", R.mipmap.ic_jam);
        letter_icons.put("K", R.mipmap.ic_kite);
        letter_icons.put("L", R.mipmap.ic_lollipop);
        letter_icons.put("M", R.mipmap.ic_monkey);
        letter_icons.put("N", R.mipmap.ic_nest);
        letter_icons.put("O", R.mipmap.ic_orange);
        letter_icons.put("P", R.mipmap.ic_penguin);
        letter_icons.put("Q", R.mipmap.ic_queen);
        letter_icons.put("R", R.mipmap.ic_rocket);
        letter_icons.put("S", R.mipmap.ic_star);
        letter_icons.put("T", R.mipmap.ic_turtle);
        letter_icons.put("U", R.mipmap.ic_umbrella);
        letter_icons.put("V", R.mipmap.ic_violin);
        letter_icons.put("W", R.mipmap.ic_watermelon);
        letter_icons.put("X", R.mipmap.ic_xylophone);
        letter_icons.put("Y", R.mipmap.ic_yo_yo);
        letter_icons.put("Z", R.mipmap.ic_zebra);
    }

    //randomizes the letters so each time the game is played different letters will used
    public List<String> RandomKeyGenerator()
    {
        List<String> randomLetters = new ArrayList<>(letter_icons.keySet());
        Collections.shuffle(randomLetters);

        return randomLetters;
    }
}
