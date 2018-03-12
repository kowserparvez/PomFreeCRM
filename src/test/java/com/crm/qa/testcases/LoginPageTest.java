package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase{
    LoginPage loginpage;
    HomePage homepage;
    public LoginPageTest(){
        super();
    }
    @BeforeMethod
    public void setUp(){
        initialization();
        loginpage = new LoginPage(); // loginpage class object created
    }
    @Test(priority = 1)
    public void loginPageTitleTest(){
        String title = loginpage.validateLoginPageTitle();
        Assert.assertEquals("#1 Free CRM for Any Business: Online Customer Relationship Software",title,"Title didnt match.");
    }
    @Test(priority = 2)
    public void crmLogoTest(){
        boolean flag =loginpage.validatePageLogo();
        Assert.assertTrue(flag);
    }
    @Test(priority = 3)
    public void loginTest(){
        homepage = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }





}
