package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;
    
    @FindBy(xpath="//h3[@data-test='error']")
    private WebElement error_message ;
    public String geterrorMessage() {
    	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
          
          wait.until(ExpectedConditions.visibilityOf(error_message));     
          
        return error_message.getText();
    }
    @FindBy(xpath="//div[@id='inventory_filter_container']//div")
    private WebElement loggedin;
    
    public String getHeading() {
    	return loggedin.getText();
    }
    

    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickLoginButton() {
        loginButton.click();
    }
    

    public void performLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
       
        
    }
}
