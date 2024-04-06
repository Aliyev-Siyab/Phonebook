package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    @BeforeMethod
    public void ensurePrecondition() {

        // click on login link
        click(By.cssSelector("[href='/login']"));
        // enter email
        type(By.name("email"), "siyabtest1@gmail.com");
        // enter password
        type(By.name("password"), "Sa12345!");
        // click on Login button
        click(By.cssSelector("[name='login']"));
    }

    @Test
    public void addContactPositivTest(){
        //click Add link
        click(By.cssSelector("[href='/add']"));
        // enter name
        type(By.cssSelector("input:nth-child(1)"),"Siyab");
        // enter surname
        type(By.cssSelector("input:nth-child(2)"),"Aliyev");
        // enter phone
        type(By.cssSelector("input:nth-child(3)"),"1234567890");
        // enter email
        type(By.cssSelector("input:nth-child(4)"),"test@gmail.com");
        // enter adress
        type(By.cssSelector("input:nth-child(5)"),"Cologne");
        // enter description
        type(By.cssSelector("input:nth-child(6)"),"Nice");
        // click on Save button
        click(By.xpath("//div[@id='root']//button[b]"));
        // assert Contact is added by text
    }
}
