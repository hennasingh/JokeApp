package com.artist.web.jokewizard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class JokeActivity extends AppCompatActivity {


    public static final String JOKE_QUES = "joke_ques";
    public static final String JOKE_ANS = "joke_ans";

    private ArrayList<String> mJokeQuestions, mJokeAnswers;
    TextView mJokeQues, mJokeAns;
    ImageButton mJokeAnsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);


        mJokeQues= findViewById(R.id.jokeDisplayQues);
        mJokeAns = findViewById(R.id.jokeDisplayAns);
        mJokeAnsBtn = findViewById(R.id.jokeAnsBtn);

        mJokeAns.setVisibility(View.INVISIBLE);
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            mJokeQuestions = extras.getStringArrayList(JOKE_QUES);
            mJokeAnswers = extras.getStringArrayList(JOKE_ANS);

            displayRandomJoke();

        }

    }

    private void displayRandomJoke() {
        Random rdnNum = new Random();
        int n = rdnNum.nextInt(10);
        String jokeQues = mJokeQuestions.get(n);
        String jokeAns = mJokeAnswers.get(n);
        displayData(jokeQues, jokeAns);
    }

    private void displayData(String jokeQues, String jokeAns) {

        mJokeQues.setText(jokeQues);
        mJokeAns.setText(jokeAns);
    }

    public void AnsToJoke(View view){

        mJokeAns.setVisibility(View.VISIBLE);

    }

    public void displayMoreJokes(View view) {
        mJokeAns.setVisibility(View.INVISIBLE);
        displayRandomJoke();

    }

}
