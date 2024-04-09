package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginElementPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }
    @Test
    public void loginPositivTest(){
        // click on login link
        app.getUser().clickOnLoginLink();
        // enter email
        app.getUser().fillLoginRegisterForm(new User().setEmail("siyabtest1@gmail.com")
                .setPassword("Sa12345!"));
        // click on Login button
        app.getUser().clickOnLoginButton();
        // assert Sign Out button is present
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeTestWithOutEmail(){
        // click on login link
        app.getUser().clickOnLoginLink();
        // enter email
        app.getUser().fillLoginRegisterForm( new User().setPassword("Sa12345!"));
        // click on Login button
        app.getUser().clickOnLoginButton();
        // assert Sign Out button is present
        Assert.assertTrue(app.getUser().isAlertPresent());
    }
}
