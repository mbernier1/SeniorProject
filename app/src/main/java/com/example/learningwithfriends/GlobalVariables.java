package com.example.learningwithfriends;

import android.app.Application;

public class GlobalVariables extends Application {

    private int m_count = 0;

    public int GetCount() {
        return m_count;
    }

    public void SetCount(int count) {
        m_count = count;
    }
}
