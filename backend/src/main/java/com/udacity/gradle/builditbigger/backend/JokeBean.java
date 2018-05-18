package com.udacity.gradle.builditbigger.backend;

/**
 * Created by User on 15-May-18.
 */

public class JokeBean {

   private MyBean mJokeMap;


     void setBean(MyBean jokeMap){
        mJokeMap = jokeMap;

    }

    public MyBean getBean(){
        return mJokeMap;
    }
}
