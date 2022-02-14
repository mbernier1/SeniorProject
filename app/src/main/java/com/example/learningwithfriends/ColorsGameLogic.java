package com.example.learningwithfriends;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ColorsGameLogic {

    public static HashMap<String, Integer> colors = new HashMap<String, Integer>();


    public ColorsGameLogic() {
        colors.put("blue", R.mipmap.ic_color_blue);
        colors.put("purple", R.mipmap.ic_color_purple);
        colors.put("green", R.mipmap.ic_color_green);
        colors.put("pink", R.mipmap.ic_color_pink);
        colors.put("yellow", R.mipmap.ic_color_yellow);
        colors.put("orange", R.mipmap.ic_color_orange);
    }

    //randomizes the letters so each time the game is played different letters will used
    public List<String> RandomKeyGenerator()
    {
        List<String> randomColors = new ArrayList<>(colors.keySet());
        Collections.shuffle(randomColors);

        return randomColors;
    }
}
