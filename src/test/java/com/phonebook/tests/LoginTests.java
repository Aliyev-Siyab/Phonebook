package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void loginPositivTest(){
        // click on login link
        click(By.cssSelector("[href='/login']"));
        // enter email
        type(By.name("email"), "siyabtest1@gmail.com");
        // enter password
        type(By.name("password"), "Sa12345!");
        // click on Login button
        click(By.cssSelector("[name='login']"));
        // assert Sign Out button is present
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }
}
