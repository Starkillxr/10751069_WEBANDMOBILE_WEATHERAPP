package com.example.a10751069_weatherapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * The type Login fragment.
 */
public class LoginFragment extends Fragment {
    private String email;
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

    /**#
     * Checks to see if the email is valid, then returns either true or false.
     * @param email
     * @return
     */
    public boolean isValidEmailAddress(String email){

        if (email.indexOf(".com")> -1 & email.indexOf("@") > -1){
            return true;
        }else if (email.indexOf(".co.uk") > -1& email.indexOf("@") > -1){
            return true;
        }else if(email.indexOf(".gov.uk") > -1& email.indexOf("@") > -1){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Method to return the length of the local part of the email address which is the part that is before the
     * "@" in the email address
     * @param email
     * @return
     */
    public int getLocalPartLength(String email){
        int start = email.indexOf("@");
        String localPart = email.substring(0, start);
        return localPart.length();
    }
}