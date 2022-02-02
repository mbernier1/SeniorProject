package com.example.learningwithfriends;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class LettersGameLogic {

    public static HashMap<String, Integer> letter_icons = new HashMap<String, Integer>();

    public LettersGameLogic()
    {
        letter_icons.put("A", R.drawable.ic_3_dots_background);
        /*letter_icons.put("B", "BALL");
        letter_icons.put("C", "CAR");
        letter_icons.put("D", "DUCK");
        letter_icons.put("E", "ELEPHANT");
        letter_icons.put("F", "FRISBEE");
        letter_icons.put("G", "GIRAFFE");
        letter_icons.put("H", "HIPPO");
        letter_icons.put("I", "ICE CREAM");
        letter_icons.put("J", "JOKER");
        letter_icons.put("K", "KITE");
        letter_icons.put("L", "LLAMA");
        letter_icons.put("M", "MONKEY");
        letter_icons.put("N", "NERD");
        letter_icons.put("O", "OWL");
        letter_icons.put("P", "PEOPLE");
        letter_icons.put("Q", "QUEEN");
        letter_icons.put("R", "ROCKET");
        letter_icons.put("S", "SNAKE");
        letter_icons.put("T", "TURTLE");
        letter_icons.put("U", "UMBRELLA");
        letter_icons.put("V", "VIOLIN");
        letter_icons.put("W", "WORLD");
        letter_icons.put("X", "XYLOPHONE");
        letter_icons.put("Y", "YO-YO");
        letter_icons.put("Z", "ZEBRA");*/
    }
    //randomizes the letters so each time the game is played different letters will used
    public List<String> RandomKeyGenerator()
    {
        List<String> randomLetters = new ArrayList<>(letter_icons.keySet());
        Collections.shuffle(randomLetters);

        //List<String> randomIcons = new ArrayList<>(letter_icons.values());
        //Collections.shuffle(randomLetters);
        //HashMap<String, String> randomMap = new HashMap<String, String>(randomLetters, randomIcons);

        return randomLetters;
        //int randomIndex = new Random().nextInt(randomLetters.size());
        //String randomLetterForDisplay = randomLetters.get(randomIndex);
    }

    public Set<String> GetKeys() {
        return letter_icons.keySet();
    }
    /*public Collection<String> GetValues() {
        return letter_icons.values();
    }

    public static String GetSingleKey(int key) {

        return letter_icons.get(key);
    }
*/
    public int sizeOfAlphabet() {return letter_icons.size(); }

    //  display icon
    //  announce letter
}
