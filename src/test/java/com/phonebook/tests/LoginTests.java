package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void loginPositivTest(){
        // click on login link
        clickOnLoginLink();
        // enter email
        fillLoginRegisterForm(new User().setEmail("siyabtest1@gmail.com")
                .setPassword("Sa12345!"));
        // click on Login button
        clickOnLoginButton();
        // assert Sign Out button is present
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeTestWithOutEmail(){
        // click on login link
        clickOnLoginLink();
        // enter email
        fillLoginRegisterForm( new User().setPassword("Sa12345!"));
        // click on Login button
        clickOnLoginButton();
        // assert Sign Out button is present
        Assert.assertTrue(isAlertPresent());
    }
}
