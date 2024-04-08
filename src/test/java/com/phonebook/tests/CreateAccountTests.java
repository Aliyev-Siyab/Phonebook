package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test(enabled = false)
    public void createNewAccountPositivTest() {
//        Random random = new Random();
//       int i = random.nextInt(1000)+1000;
//        type(By.name("email"), + i + "siyabtest1@gmail.com");
        clickOnLoginLink();
        fillLoginRegisterForm(new User().setEmail("siyabtest1@gmail.com")
                .setPassword("Sa12345!"));
        clickOnRegistrationButton();
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test
    public void createNewAccountWithExistedEmailNegativeTest() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User().setEmail("siyabtest1@gmail.com")
                .setPassword("Sa12345!"));
        clickOnRegistrationButton();
        Assert.assertTrue(isAlertPresent());
    }

}


// 1. id
// 1.2 className(css)
// 2. scc
// 3.xPath