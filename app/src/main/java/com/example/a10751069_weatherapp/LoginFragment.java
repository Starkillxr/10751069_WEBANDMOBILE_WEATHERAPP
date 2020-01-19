package com.example.myweatherapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * The type Login fragment.
 */
public class LoginFragment extends Fragment {

    /**
     * Instantiates a new Login fragment.
     */
    public LoginFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * When setting "attachToRoot" to false it will stop the view from attaching to their parent
     * (including them in the parent hierarchy)
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }
}
