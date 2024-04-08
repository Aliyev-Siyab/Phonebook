package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User().setEmail("siyabtest1@gmail.com")
                .setPassword("Sa12345!"));
        clickOnLoginButton();

        clickOnAddLink();
        fillAddContactForm(new Contact()
                .setName("Siyab")
                .setLastName("Aliyev")
                .setPhone("1234567890")
                .setEmail("test@gmail.com")
                .setAddress("Cologne")
                .setDescription("Nice"));
        clickOnSaveButton();
    }

    @Test
    public void deleteContactPositivTest() {
        int sizeBefore = sizeOfContacts();
        removeContact();

        pause(500);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }

}
