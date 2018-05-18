package com.udacity.gradle.builditbigger.backend;

import java.util.ArrayList;
import java.util.HashMap;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private HashMap<String, ArrayList<String>> myData;

    public HashMap<String, ArrayList<String>> getData() {
        return myData;
    }

    public void setData(HashMap<String, ArrayList<String>> data) {
        myData = data;
    }
}