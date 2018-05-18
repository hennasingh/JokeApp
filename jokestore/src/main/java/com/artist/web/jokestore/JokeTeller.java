package com.artist.web.jokestore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class JokeTeller {

    private static final String[] JOKE_QUESTIONS = {
            "Why did Johnny throw the clock out of the window? ",
            "What happens to a frog's car when it breaks down? ",
            "I submitted 10 puns to a joke-writing competition. How many of them made to the finals? ",
            "Can a kangaroo jump higher than the Empire State Building? ",
            "What did the duck say when it bought the lipstick? ",
            "Which country's capital has the fastest growing population? ",
            "Why was the baby strawberry crying? ",
            "Why shouldn't you write with a broken pencil? ",
            "What do you call a belt with a watch on it? ",
            "What do you call bears with no ears? "
    };

    private static final String[] JOKE_ANSWERS = {
            "Because he wanted to see time fly! ",
            "It gets Toad away ",
            "Sadly, no pun in ten did ",
            "Of course! The Empire State Building can't jump? ",
            "Put it on my bill ",
            "Ireland. Everyday its Dublin",
            "Because his mom and dad were in a jam ",
            "Because it's pointless ",
            "A waist of time ",
            "B "
    };

    private static ArrayList<String> mJokeQuestions;
    private static ArrayList<String> mJokeAnswers;


    public JokeTeller() {
        mJokeQuestions = new ArrayList<>(Arrays.asList(JOKE_QUESTIONS));
        mJokeAnswers = new ArrayList<>(Arrays.asList(JOKE_ANSWERS));

    }


   public ArrayList<String> generateJokeQuestions(){
       Random rdnNum = new Random();
       int n = rdnNum.nextInt(10);
       String jokeQues = mJokeQuestions.get(n);
       String jokeAns = mJokeAnswers.get(n);
       ArrayList<String> jokeList = new ArrayList<>();
       jokeList.add(0,jokeQues);
       jokeList.add(1,jokeAns);

       return jokeList;
   }

    public  ArrayList<String> getJokeQuestions() {
        return mJokeQuestions;
    }

    public  ArrayList<String> getJokeAnswers() {
        return mJokeAnswers;
    }
}
