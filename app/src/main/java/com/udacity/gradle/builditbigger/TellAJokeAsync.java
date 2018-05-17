package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import com.artist.web.jokestore.JokeTeller;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by User on 15-May-18.
 */

public class TellAJokeAsync extends AsyncTask<Void, Void, HashMap<String, ArrayList<String>>> {

    private OnEventListener<HashMap<String, ArrayList<String>>> mCallback;
    private WeakReference<MainActivity> appReference;
    public Exception mException;
    private static MyApi sMyApiService = null;
    private static final String TAG = TellAJokeAsync.class.getSimpleName();



    public TellAJokeAsync(MainActivity context, OnEventListener<HashMap<String, ArrayList<String>>> callback) {
        mCallback = callback;
        appReference = new WeakReference<>(context);
    }

    @Override
    protected HashMap<String, ArrayList<String>> doInBackground(Void... params) {

        if(sMyApiService==null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(),null)
                    .setRootUrl("http://127.0.0.1:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                @Override
                public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest)
                        throws IOException {
                    abstractGoogleClientRequest.setDisableGZipContent(true);
                }
            });

            sMyApiService = builder.build();
        }

        try{
            return sMyApiService.tellJoke().execute().getJokeList();
        }catch(IOException e){
            Log.e(TAG, "got an exception " + e.getMessage());
            return null;
        }


    }

    @Override
    protected void onPostExecute(HashMap<String, ArrayList<String>> stringArrayListHashMap) {
        super.onPostExecute(stringArrayListHashMap);
    }
}
