package com.artist.web.jokewizard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView mJokeQues = findViewById(R.id.jokeDisplayQues);
        TextView mJokeAns = findViewById(R.id.jokeDisplayAns);
        ImageButton mJokeAnsBtn = findViewById(R.id.jokeAnsBtn);

        Bundle extras = getIntent().getExtras();

    }
}
