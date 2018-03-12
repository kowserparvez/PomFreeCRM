package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase{
    //Page Factory OR Object Repo
    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath= "//input[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath= "//button[contains(text(),'Sign Up')]")
    WebElement signUpBtn;

    @FindBy(xpath= ".//img[@class='img-responsive']")
    WebElement crmLogo;

    //Constructor to initializing the page object
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
    //Methods
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }
    public boolean validatePageLogo(){
        return crmLogo.isDisplayed();
    }
    public HomePage login(String un,String pwd){
        username.sendKeys(un);
        password.sendKeys(pwd);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginBtn);
        return new HomePage();
    }




}
