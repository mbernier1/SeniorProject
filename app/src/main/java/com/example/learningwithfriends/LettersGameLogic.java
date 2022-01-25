package com.example.learningwithfriends;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LettersGameLogic {
    public HashMap<String, String> letter_icons = new HashMap<String, String>();

    public LettersGameLogic()
    {
        letter_icons.put("A", "APPLE");
        letter_icons.put("B", "BALL");
        letter_icons.put("C", "CAR");
        letter_icons.put("D", "DUCK");
        letter_icons.put("E", "ELEPHANT");
        letter_icons.put("F", "world");
        letter_icons.put("G", "world");
        letter_icons.put("H", "HIPPO");
        letter_icons.put("I", "ICE CREAM");
        letter_icons.put("J", "world");
        letter_icons.put("K", "world");
        letter_icons.put("L", "world");
        letter_icons.put("M", "MONKEY");
        letter_icons.put("N", "world");
        letter_icons.put("O", "world");
        letter_icons.put("P", "world");
        letter_icons.put("Q", "queen");
        letter_icons.put("R", "rocket");
        letter_icons.put("S", "world");
        letter_icons.put("T", "turtle");
        letter_icons.put("U", "umbrella");
        letter_icons.put("V", "world");
        letter_icons.put("W", "world");
        letter_icons.put("X", "xylaphone");
        letter_icons.put("Y", "YO-YO");
        letter_icons.put("Z", "ZEBRA");



    }
    //randomizes the letters so each time the game is played different letters will used
    public void RandomLetterGenerator()
    {
        List<String> randomLetters = new ArrayList<String>(letter_icons.values());
        int randomIndex = new Random().nextInt(randomLetters.size());
        String randomLetterForDisplay = randomLetters.get(randomIndex);
    }

    public Set<String> GetKeys() {
        return letter_icons.keySet();
    }
    public Collection<String> GetValues() {
        return letter_icons.values();
    }



    //  display icon
    //  announce letter
}
