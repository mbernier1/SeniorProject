package com.example.learningwithfriends;

import android.app.Application;

public class GlobalVariables extends Application {

    private int m_count = 0;
    private boolean m_clicked = false;
    private int m_numClicked = 0;
    private  String m_lastClicked;

    public int GetCount() {
        return m_count;
    }
    public void SetCount(int count) {
        m_count = count;
    }

    public boolean GetClicked() {return m_clicked; }
    public void SetClicked(boolean clicked) { m_clicked = clicked; }

    public int GetNumCicked() {
        return m_numClicked;
    }
    public void SetNumClicked(int count) {
        m_numClicked = count;
    }

    public String GetLastClicked() {
        return m_lastClicked;
    }
    public void SetLastClicked(String count) {
        m_lastClicked = count;
    }
}
