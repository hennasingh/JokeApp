package com.udacity.gradle.builditbigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.loadingBar)
    ProgressBar mProgressBar;
    @BindView(R.id.jokeBtn)
    Button mJokeBtn;

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
        TellAJokeAsync jokeAsync = new TellAJokeAsync(this,
                new OnEventListener<ArrayList<String>>() {
                    @Override
                    public void onSuccess(ArrayList<String> jokeList) {

                        Intent jokeDisplay = new Intent(getApplicationContext(), JokeActivity.class);
                        jokeDisplay.putExtra(JokeActivity.JOKE_LIST, jokeList);
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
