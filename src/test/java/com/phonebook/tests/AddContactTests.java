package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {
        if(!app.getUser().isLoginElementPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail("siyabtest1@gmail.com")
                .setPassword("Sa12345!"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositivTest(){
        app.getContact().clickOnAddLink();
        app.getContact().fillAddContactForm(new Contact()
                .setName("Siyab")
                .setLastName("Aliyev")
                .setPhone("1234567890")
                .setEmail("test@gmail.com")
                .setAddress("Cologne")
                .setDescription("Nice"));
        app.getContact().clickOnSaveButton();
        // assert Contact is added by text
        Assert.assertTrue(app.getContact().isContactCreated("Siyab"));
    }

    @AfterMethod
    public void postCondition(){
        app.getContact().removeContact();
    }

}
