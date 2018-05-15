package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import com.artist.web.jokestore.JokeTeller;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;
import java.lang.ref.WeakReference;

/**
 * Created by User on 15-May-18.
 */

public class TellAJoke extends AsyncTask<String, Void, JokeTeller> {

    private OnEventListener<JokeTeller> mCallback;
    private WeakReference<MainActivity> appReference;
    public Exception mException;
    private static MyApi sMyApiService = null;
    private static final String TAG = TellAJoke.class.getSimpleName();


    public TellAJoke(OnEventListener<JokeTeller> callback, MainActivity context) {
        mCallback = callback;
        appReference = new WeakReference<>(context);
    }

    @Override
    protected JokeTeller doInBackground(String... strings) {

        if(sMyApiService==null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(),null)
                    .setRootUrl("http://192.168.0.66:8080/_ah/api/");
            sMyApiService = builder.build();
        }
        String question = strings[0];
        String answer = strings[1];

        try{
            return sMyApiService.tellJoke(question, answer);
        }catch(IOException e){
            Log.e(TAG, "got an exception " + e.getMessage());
        }

        return null;
    }
}
