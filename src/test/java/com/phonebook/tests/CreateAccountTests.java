package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CreateAccountTests extends TestBase {

    @Test(enabled = false)
    public void createNewAccountPositivTest() {
//        Random random = new Random();
//        int i = random.nextInt(1000)+1000;
//        type(By.name("email"), + i + "siyabtest1@gmail.com");
        // click on login link
        click(By.cssSelector("[href='/login']"));
        // enter email
        type(By.name("email"), "siyabtest1@gmail.com");
        // enter password
        type(By.name("password"), "Sa12345!");
        // click on Registration button
        click(By.cssSelector("[name='registration']"));
        // assert Sign Out is present
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }

    @Test
    public void createNewAccountWithExistedEmailNegativeTest() {
        // click on login link
        click(By.cssSelector("[href='/login']"));
        // enter email
        type(By.name("email"), "siyabtest1@gmail.com");
        // enter password
        type(By.name("password"), "Sa12345!");
        // click on Registration button
        click(By.cssSelector("[name='registration']"));
        // assert Alert is present
        Assert.assertTrue(isAlertPresent());

    }

}


// 1. id
// 1.2 className(css)
// 2. scc
// 3.xPath