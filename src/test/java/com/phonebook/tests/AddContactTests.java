package com.phonebook.tests;

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import com.phonebook.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddContactTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginElementPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User().setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositivTest() {
        app.getContact().clickOnAddLink();
        app.getContact().fillAddContactForm(new Contact()
                .setName(ContactData.NAME)
                .setLastName(ContactData.LAST_NAME)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.CONTACT_MAIL)
                .setAddress(ContactData.ADDRESS)
                .setDescription(ContactData.DESC));
        app.getContact().clickOnSaveButton();
        // assert Contact is added by text
        Assert.assertTrue(app.getContact().isContactCreated(ContactData.NAME));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }



    @Test(dataProvider = "addNewContact",dataProviderClass = DataProviders.class)
    public void addContactPositivTestFromDataProvider(String name, String lastname, String phone,
                                                      String email, String address, String description) {
        app.getContact().clickOnAddLink();
        app.getContact().fillAddContactForm(new Contact()
                .setName(name)
                .setLastName(lastname)
                .setPhone(phone)
                .setEmail(email)
                .setAddress(address)
                .setDescription(description));
        app.getContact().clickOnSaveButton();
        // assert Contact is added by text
        Assert.assertTrue(app.getContact().isContactCreated(name));
    }


    @Test(dataProvider = "addNewContactFromCsvFile",dataProviderClass = DataProviders.class)
    public void addContactPositivTestFromDataProviderWithCsvFile(Contact contact) {
        app.getContact().clickOnAddLink();
        app.getContact().fillAddContactForm(contact);
        app.getContact().clickOnSaveButton();
        // assert Contact is added by text
        Assert.assertTrue(app.getContact().isContactCreated(contact.getName()));
    }

}
