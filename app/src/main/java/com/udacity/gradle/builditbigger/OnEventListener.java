package com.udacity.gradle.builditbigger;

/**
 * Created by User on 15-May-18.
 */

public interface OnEventListener<T> {

    void onSuccess(T object);
    void onFailure(Exception e);

}
