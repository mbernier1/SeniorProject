package com.example.learningwithfriends;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TextView test = findViewById(R.id.test_view);
        Button next_button = findViewById(R.id.next_button);

        next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, LoginScreen.class);
                startActivity(intent);
            }
        });


        HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();


        numbers.put(R.mipmap.ic_number_1_foreground, R.mipmap.ic_1_dot_foreground);
        numbers.put(R.mipmap.ic_number_2_foreground, R.mipmap.ic_2_dots_foreground);
        numbers.put(R.mipmap.ic_number_3_foreground, R.mipmap.ic_3_dots_foreground);
        numbers.put(R.mipmap.ic_number_4_foreground, R.mipmap.ic_4_dots_foreground);
        numbers.put(R.mipmap.ic_number_5_foreground, R.mipmap.ic_5_dots_foreground);
        numbers.put(R.mipmap.ic_number_6_foreground, R.mipmap.ic_6_dots_foreground);
        numbers.put(R.mipmap.ic_number_7_foreground, R.mipmap.ic_7_dots_foreground);
        numbers.put(R.mipmap.ic_number_8_foreground, R.mipmap.ic_8_dots_foreground);
        numbers.put(R.mipmap.ic_number_9_foreground, R.mipmap.ic_9_dots_foreground);

        // 1. for-each with Entry
        for (Map.Entry<Integer, Integer> entry : numbers.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }


// 2. for-each with key or value each (faster)
//iterating over keys only
        for (Integer key : numbers.keySet()) {
            System.out.println("Key = " + key);
        }

//iterating over values only
        for (Integer value : numbers.values()) {
            System.out.println("Value = " + value);
        }

    }
}