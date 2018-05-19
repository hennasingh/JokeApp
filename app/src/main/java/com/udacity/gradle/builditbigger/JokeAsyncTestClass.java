package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * Created by User on 19-May-18.
 * based on http://marksunghunpark.blogspot.ie/2015/05/how-to-test-asynctask-in-android.html
 */

@RunWith(AndroidJUnit4.class)
public class JokeAsyncTestClass extends ApplicationTestCase<Application> {

    private static final String JOKE_NULL = "Joke is null";
    private static final String JOKE_EMPTY = "Joke is empty";
    private static final String ERROR_FETCHING_JOKE = "Error fetching the joke!";
    private ArrayList<String> jokeResult;


    private CountDownLatch mSignal;

    public JokeAsyncTestClass(){
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        //to indicate when task is complete
        mSignal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        mSignal.countDown();
    }

    @Test
    public void testAsynJokeFetchTask() throws InterruptedException {


           new TellAJokeAsync(InstrumentationRegistry.getTargetContext(),
                new OnEventListener<ArrayList<String>>() {
                    @Override
                    public void onSuccess(ArrayList<String> object) {
                        jokeResult = object;
                        mSignal.countDown();
                    }

                    @Override
                    public void onFailure(Exception e) {
                        fail(ERROR_FETCHING_JOKE);
                    }
                }).execute();
                mSignal.await();

                assertNotNull(JOKE_NULL, jokeResult);
                assertTrue(JOKE_EMPTY, !jokeResult.isEmpty());

    }
}
