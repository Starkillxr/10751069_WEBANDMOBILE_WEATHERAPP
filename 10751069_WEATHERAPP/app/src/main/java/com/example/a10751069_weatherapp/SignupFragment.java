package com.example.a10751069_weatherapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * The type Signup fragment.
 */
public class SignupFragment extends Fragment {

    /**
     * Instantiates a new Signup fragment.
     */

    private String email;
    private String confirmEmail;
    private String password;
    private String confirmPassword;
    private Boolean validEmail;

    /**
     * Instantiates a new Signup fragment.
     */
    public SignupFragment(){

    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_signup,container,false);
    }

    /**
     * this is a method to check the signup credentials. if the email and password match confirmEmail and confirmPassword
     * they wil return true, if they do not they will return false.
     * <p>
     * there will be a toast in a later version that states whether the email or the password match
     * confirm email or confirm password or not.
     * <p>
     * Also checks to see if it's a valid email or not however, there is nothing there to check for a valid password.
     * To check for a valid password in a later version I would check to see if it included any numbers or special characters.
     * <p>
     * Also did not get round to fully implementing this into the application itself its currently just in the backend.
     *
     * @param email           the email
     * @param confirmEmail    the confirm email
     * @param password        the password
     * @param confirmPassword the confirm password
     * @return boolean
     */
    public boolean isValidLoginCredentials(String email, String confirmEmail, String password, String confirmPassword){

        if(email == confirmEmail & password == confirmPassword){
            if (email.indexOf(".com")> -1 & email.indexOf("@") > -1){
                validEmail = true;
                return true;
            }else if (email.indexOf(".co.uk") > -1& email.indexOf("@") > -1){
                validEmail = true;
                return true;
            }else if(email.indexOf(".gov.uk") > -1& email.indexOf("@") > -1){
                validEmail = true;
                return true;
            }else{
                validEmail = false;
                return false;
            }
        }else if (email == confirmEmail & password != confirmPassword){
            return false;
        }else if(email != confirmEmail & password == confirmPassword){
            return false;
        }else{
            return false;
        }
    }


}
