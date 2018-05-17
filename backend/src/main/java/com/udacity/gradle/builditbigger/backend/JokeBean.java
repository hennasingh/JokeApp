package com.udacity.gradle.builditbigger.backend;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by User on 15-May-18.
 */

public class JokeBean {

   private HashMap<String, ArrayList<String>> mJokeMap;


     void setJokeList(HashMap<String, ArrayList<String>> jokeMap){
        mJokeMap = jokeMap;

    }

    public HashMap<String, ArrayList<String>> getJokeList(){
        return mJokeMap;
    }
}
