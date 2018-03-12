package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class HomePage extends TestBase{
    @FindBy(xpath = "//td[contains(text(),'User: Kowser')]")
    @CacheLookup
    WebElement userNameLabel;
    @FindBy(xpath = ".//a[contains(text(),'Contacts')]" )
    WebElement contactsLink;
    @FindBy(xpath = "//a[contains(text(),'New Contact')]" )
    WebElement newContactsLink;
    @FindBy(xpath = ".//a[contains(text(),'Deals')]")
    WebElement dealsLink;
    @FindBy(xpath = ".//a[contains(text(),'Tasks')]")
    WebElement tasksLink;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    public String verifyHomePageTitle(){
        return driver.getTitle();
    }
    public boolean verifyUserName(){
       return userNameLabel.isDisplayed();
    }
    public ContactsPage clickOnContactsLink(){
        contactsLink.click();
        return new ContactsPage();
    }
    public DealsPage clickOnDealsLink(){
        dealsLink.click();
        return new DealsPage();
    }
    public TasksPage clickOnTasksLink(){
        tasksLink.click();
        return new TasksPage();
    }
    public void clickOnNewContactLink(){
        Actions action = new Actions(driver);
        action.moveToElement(contactsLink).build().perform();
        newContactsLink.click();

    }


}
