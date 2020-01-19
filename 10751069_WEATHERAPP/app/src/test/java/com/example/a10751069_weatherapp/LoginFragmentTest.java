package com.example.a10751069_weatherapp;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LoginFragmentTest {

    @Test
    public void aValidEmailAddressPasses1() throws Exception{
        LoginFragment lf = new LoginFragment();

        assertTrue(lf.isValidEmailAddress("johnappleseed@gmail.com"));
    }

    @Test
    public void anEmailAddressPasses2()throws Exception{
        LoginFragment lf = new LoginFragment();
        assertTrue(lf.isValidEmailAddress("johnapplessed@gmail.co.uk"));
    }

    @Test
    public void anEmailAddressPasses3()throws Exception{
        LoginFragment lf = new LoginFragment();
        assertTrue(lf.isValidEmailAddress("johnapplessed@gmail.gov.uk"));
    }

    @Test
    public void localPartTest() throws Exception{
        LoginFragment lf = new LoginFragment();
        assertEquals(1,lf.getLocalPartLength("a@b.com"));
    }

    @Test
    public void InvalidEmail() throws Exception{
        LoginFragment lf = new LoginFragment();

        assertTrue(lf.isValidEmailAddress("johnapplessed@gmail"));
    }

    @Test
    public void InvalidEmail2() throws Exception{
        LoginFragment lf = new LoginFragment();
        assertTrue(lf.isValidEmailAddress("johnapplesedgmail.com"));
    }
}