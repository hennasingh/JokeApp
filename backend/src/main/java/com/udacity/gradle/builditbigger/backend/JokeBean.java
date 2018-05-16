package com.udacity.gradle.builditbigger.backend;

import java.util.ArrayList;

/**
 * Created by User on 15-May-18.
 */

public class JokeBean {

    private ArrayList<String> mJokeQuestions;
    private ArrayList<String> mJokeAnswers;
    private ArrayList<ArrayList<String>> mJokeList;


    public ArrayList<String> getJokeQuestions() {
        return mJokeQuestions;
    }

    public void setJokeQuestions(ArrayList<String> jokeQuestions) {
        mJokeQuestions = jokeQuestions;
    }

    public ArrayList<String> getJokeAnswers() {
        return mJokeAnswers;
    }

    public void setJokeAnswers(ArrayList<String> jokeAnswers) {
        mJokeAnswers = jokeAnswers;
    }

    public void setJokeList(ArrayList<ArrayList<String>> jokeList){
        mJokeList = jokeList;

    }

    public ArrayList<ArrayList<String>> getJokeList(){
        return mJokeList;
    }
}
