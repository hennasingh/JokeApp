package com.artist.web.jokewizard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class JokeActivity extends AppCompatActivity {


    public static final String JOKE_LIST = "joke_data";
    TextView mJokeQues, mJokeAns;
    ImageButton mJokeAnsBtn, mAnotherJoke;

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
            ArrayList<String> jokeList = extras.getStringArrayList(JOKE_LIST);
            String jokeQues = jokeList.get(0);
            String jokeAns = jokeList.get(1);
            displayData(jokeQues, jokeAns);
        }

    }

    private void displayData(String jokeQues, String jokeAns) {

        mJokeQues.setText(jokeQues);
        mJokeAns.setText(jokeAns);
    }

    public void AnsToJoke(View view){

        mJokeAns.setVisibility(View.VISIBLE);

    }


}
