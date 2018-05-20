package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by User on 15-May-18.
 */

public class TellAJokeAsync extends AsyncTask<Void, Void, ArrayList<ArrayList<String>>> {

    private static final String LOCALHOST_IP_ADDRESS = "http://10.0.2.2:8080/_ah/api/";
    private static final String TAG = TellAJokeAsync.class.getSimpleName();
    private static MyApi sMyApiService = null;
    private Exception mException;
    private OnEventListener<ArrayList<ArrayList<String>>> mCallback;
    private Context mContext;


    public TellAJokeAsync(Context context, OnEventListener<ArrayList<ArrayList<String>>> callback) {
        mCallback = callback;
        mContext = context;
    }

    @Override
    protected ArrayList<ArrayList<String>> doInBackground(Void... params) {

        if(sMyApiService==null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(),null)
                    .setRootUrl(LOCALHOST_IP_ADDRESS)
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
            //return (new ArrayList<>(sMyApiService.tellJoke().execute().getData()));
            ArrayList<String> mJokeQues = new ArrayList<>(sMyApiService.tellJoke().execute().getQuesData());
            ArrayList<String> mJokeAns = new ArrayList<>(sMyApiService.tellJoke().execute().getAnsData());
            ArrayList<ArrayList<String>> jokeList = new ArrayList<>();
            jokeList.add(0, mJokeQues);
            jokeList.add(1, mJokeAns);
            return jokeList;

        }catch(IOException e){
            Log.e(TAG, "got an exception " + e.getMessage());
            mException = e;
            return null;
        }

    }

    @Override
    protected void onPostExecute(ArrayList<ArrayList<String>> jokeList) {
        if(mCallback!=null){
            if(mException == null){
                mCallback.onSuccess(jokeList);
            }else{
                mCallback.onFailure(mException);
            }
        }
    }
}
