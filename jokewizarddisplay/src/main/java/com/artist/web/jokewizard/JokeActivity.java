package com.artist.web.jokewizard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE = "joke_received";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        TextView jokeText = findViewById(R.id.jokeDisplayQues);

        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            jokeText.setText(extras.getString(JOKE));
        }
    }
}
