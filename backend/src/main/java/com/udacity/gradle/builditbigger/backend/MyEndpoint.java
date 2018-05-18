package com.udacity.gradle.builditbigger.backend;

import com.artist.web.jokestore.JokeTeller;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.ArrayList;
import java.util.HashMap;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);

        return response;
    }*/

    /**A endpoint method that gives joke back from java library*/
    @ApiMethod(name = "tellJoke")
    public JokeBean tellJoke(){
        JokeTeller mJoke = new JokeTeller();

        HashMap<String, ArrayList<String>> jokeMap= mJoke.getJokeMap();

        MyBean myBean = new MyBean();
        myBean.setData(jokeMap);

        JokeBean jokeBean = new JokeBean();
        jokeBean.setBean(myBean);

        return jokeBean;

    }


}
