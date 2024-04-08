package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User().setEmail("siyabtest1@gmail.com")
                .setPassword("Sa12345!"));
        clickOnLoginButton();
    }

    @Test
    public void addContactPositivTest(){
        clickOnAddLink();
        fillAddContactForm(new Contact()
                .setName("Siyab")
                .setLastName("Aliyev")
                .setPhone("1234567890")
                .setEmail("test@gmail.com")
                .setAddress("Cologne")
                .setDescription("Nice"));
        clickOnSaveButton();
        // assert Contact is added by text
        Assert.assertTrue(isContactCreated("Siyab"));
    }

    @AfterMethod
    public void postCondition(){
        removeContact();
    }

}
