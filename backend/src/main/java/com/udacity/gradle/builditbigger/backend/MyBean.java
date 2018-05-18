package com.udacity.gradle.builditbigger.backend;

import java.util.ArrayList;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private ArrayList<String> mQuesData;
    private ArrayList<String> mAnsData;

    public ArrayList<String> getQuesData() {
        return mQuesData;
    }

    public void setQuesData(ArrayList<String> data) {
        mQuesData = data;
    }

    public void setAnsData(ArrayList<String> data) {
        mAnsData = data;
    }

    public ArrayList<String> getAnsData() {
        return mAnsData;
    }
}