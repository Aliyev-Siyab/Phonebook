package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.getUser().isLoginElementPresent()){
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test(enabled = false)
    public void createNewAccountPositivTest() {
//        Random random = new Random();
//       int i = random.nextInt(1000)+1000;
//        type(By.name("email"), + i + "siyabtest1@gmail.com");
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail("siyabtest1@gmail.com")
                .setPassword("Sa12345!"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());
    }

    @Test
    public void createNewAccountWithExistedEmailNegativeTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail("siyabtest1@gmail.com")
                .setPassword("Sa12345!"));
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

}


// 1. id
// 1.2 className(css)
// 2. scc
// 3.xPath