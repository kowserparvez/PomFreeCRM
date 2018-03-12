package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase{
    LoginPage loginPage;
    HomePage homepage;
    ContactsPage contactsPage;
    DealsPage dealsPage;
    TasksPage tasksPage;
    TestUtil testUtil;
    String sheetName = "contacts";
    public ContactsPageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage(); // loginpage class object created
        testUtil = new TestUtil();
        homepage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        testUtil.switeToFrame();
        contactsPage= homepage.clickOnContactsLink();

    }
    @Test(priority = 1)
    public void verifyContactsPageLabel(){
       Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contacts label is missing");
    }
    @Test(priority = 2)
    public void selectContactsTest(){
        contactsPage.selectContctsByName("Tim Bean");

    }
    @DataProvider (name = "one")
    public Object[][] getTestData(){
        Object data [][]=TestUtil.getTestData(sheetName);
        return data;
    }
    @Test(dataProvider = "one", priority = 3, enabled = false)
    public void validateCreateNewContacts(String title, String firstname, String lastname, String company){
        homepage.clickOnNewContactLink();
        //testUtil.switeToFrame();
        contactsPage.createNewContact(title,firstname,lastname,company);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
