package com.example.a10751069_weatherapp;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A test unit testing the SignupFragment and the logic behind the validLoginCredentials method
 *
 * Should pass the first three Tests and Fail the Rest of them.
 */
public class SignupFragmentTest {

    private SignupFragment sf;

    @Before
    public void setUp(){
        sf = new SignupFragment();
    }
    @Test
    public void validLoginCredentials() throws Exception{
        assertTrue(sf.isValidLoginCredentials("johnappleseed@gmail.com","johnappleseed@gmail.com","1234","1234"));
    }
    @Test
    public void validLoginCredentials1() throws Exception{
        assertTrue(sf.isValidLoginCredentials("johnappleseed@gmail.co.uk","johnappleseed@gmail.co.uk","1234","1234"));
    }
    @Test
    public void validLoginCredentials2() throws Exception{
        assertTrue(sf.isValidLoginCredentials("johnappleseed@gmail.gov.uk", "johnappleseed@gmail.gov.uk", "1234", "1234"));
    }
    @Test
    public void invalidCredentials() throws Exception{
        assertTrue(sf.isValidLoginCredentials("johnappleseed@gmail","johnappleseed@gmail","1234","1234"));
    }
    @Test
    public void invalidCredentials1() throws Exception{
        assertTrue(sf.isValidLoginCredentials("johnappleseedgmail.com","johnappleseedgmail.com","1234","1234"));
    }
    @Test
    public void emailsNotMatching() throws Exception{
        assertTrue(sf.isValidLoginCredentials("johnappleseed@gmail.com","johnappleseed@gmail.co.uk","1234","1234"));
    }
    @Test
    public void passwordsNotMatching() throws Exception{
        assertTrue(sf.isValidLoginCredentials("johnappleseed@gmail.com","johnappleseed@gmail.com","1234","12345"));
    }
}
