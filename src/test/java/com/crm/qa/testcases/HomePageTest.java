package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.*;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homepage;
    ContactsPage contactsPage;
    DealsPage dealsPage;
    TasksPage tasksPage;
    TestUtil testUtil;
    public HomePageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage(); // loginpage class object created
        testUtil = new TestUtil();
        homepage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }
    @Test(priority = 1)
    public void verifyHomePageTitle(){
        String homePageTitle = homepage.verifyHomePageTitle();
        Assert.assertEquals("CRMPRO",homePageTitle,"Title didnt match.");
    }
    @Test(priority = 2)
    public void userNameTest(){
        testUtil.switeToFrame();
        boolean flag = homepage.verifyUserName();
        Assert.assertTrue(flag);
    }
    @Test(priority = 3)
    public void contactsPageTest(){
        testUtil.switeToFrame();
        //homepage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
       contactsPage = homepage.clickOnContactsLink();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
