package com.example.a10751069_weatherapp;

/**
 * Learnt this from https://www.androidhive.info/2014/09/android-json-parsing-using-volley/
 * It's esseentially a singleton class that initializes all the core volley objects
 */

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * The type App controller.
 */
public class AppController extends Application {
    /**
     * The constant TAG.
     */
// used in original method for parsing JSON using Volley
    public static final String TAG = AppController.class.getSimpleName();

    private RequestQueue mRequestQueue;

    private static AppController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    /**
     * Get instance app controller.
     *
     * @return the app controller
     */
    public static synchronized AppController getInstance() {
        return mInstance;
    }

    /**
     * Gets request queue.
     *
     * @return the request queue
     */
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    /**
     * Add to request queue.
     *
     * @param <T> the type parameter
     * @param req the req
     * @param tag the tag
     */
    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    /**
     * Add to request queue.
     *
     * @param <T> the type parameter
     * @param req the req  This method is used to add any JSON requests to a queue.
     */
    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    /**
     * This method is used to cancel any pending JSON volley requests.
     *
     * @param tag the tag
     */
    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}