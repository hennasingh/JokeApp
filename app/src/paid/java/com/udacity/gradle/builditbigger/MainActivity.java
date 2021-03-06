package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.artist.web.jokewizard.JokeActivity;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.loadingBar)
    ProgressBar mProgressBar;
    @BindView(R.id.jokeBtn)
    Button mJokeBtn;
    TellAJokeAsync jokeAsync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mProgressBar.setVisibility(View.INVISIBLE);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        mProgressBar.setVisibility(View.VISIBLE);
        mJokeBtn.setVisibility(View.INVISIBLE);
        jokeAsync = new TellAJokeAsync(this,
                new OnEventListener<ArrayList<ArrayList<String>>>() {
                    @Override
                    public void onSuccess(ArrayList<ArrayList<String>> jokeList) {

                        Intent jokeDisplay = new Intent(getApplicationContext(), JokeActivity.class);
                        ArrayList<String> jokeQues = jokeList.get(0);
                        ArrayList<String> jokeAns = jokeList.get(1);
                        jokeDisplay.putExtra(JokeActivity.JOKE_QUES, jokeQues);
                        jokeDisplay.putExtra(JokeActivity.JOKE_ANS, jokeAns);
                        startActivity(jokeDisplay);

                        mProgressBar.setVisibility(View.INVISIBLE);
                        mJokeBtn.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });
        jokeAsync.execute();

    }

}
