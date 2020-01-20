package com.example.a10751069_weatherapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LoginFragmentTest {

    /**
     * A valid email address passes 1.
     *
     * @throws Exception the exception
     */
    @Test
    public void aValidEmailAddressPasses1() throws Exception{
        LoginFragment lf = new LoginFragment();

        assertTrue(lf.isValidEmailAddress("johnappleseed@gmail.com"));
    }

    /**
     * An email address passes 2.
     *
     * @throws Exception the exception
     */
    @Test
    public void anEmailAddressPasses2()throws Exception{
        LoginFragment lf = new LoginFragment();
        assertTrue(lf.isValidEmailAddress("johnapplessed@gmail.co.uk"));
    }

    /**
     * An email address passes 3.
     *
     * @throws Exception the exception
     */
    @Test
    public void anEmailAddressPasses3()throws Exception{
        LoginFragment lf = new LoginFragment();
        assertTrue(lf.isValidEmailAddress("johnapplessed@gmail.gov.uk"));
    }

    /**
     * Invalid email.
     *
     * @throws Exception the exception
     */
    @Test
    public void InvalidEmail() throws Exception{
        LoginFragment lf = new LoginFragment();

        assertTrue(lf.isValidEmailAddress("johnapplessed@gmail"));
    }

    /**
     * Invalid email 2.
     *
     * @throws Exception the exception
     */
    @Test
    public void InvalidEmail2() throws Exception{
        LoginFragment lf = new LoginFragment();
        assertTrue(lf.isValidEmailAddress("johnapplesedgmail.com"));
    }
}