package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//div[@class='pricebar']//button[contains(text(),'ADD TO CART')]")
    
    private WebElement addToCartButton;
    @FindBy(xpath="//a[contains(@class,'shopping_cart_link')]")
    private WebElement cartIcon;
    @FindBy(xpath="//button[contains(text(),'REMOVE')]")
    private WebElement removeButton;
    
    @FindBy(xpath="//a[@class='btn_action checkout_button']")
    private WebElement checkoutButton;

    @FindBy(css="#cart_contents_container>div>div.cart_footer>a.btn_secondary")
    private WebElement continueShoppingButton;
   
    @FindBy(css="input.btn_primary.cart_button")
    private WebElement continueButton;

    public void clickContinue() {
        continueButton.click();
    }

    @FindBy(id="first-name")
    private WebElement firstNameInput;

    @FindBy(id="last-name")
    private WebElement lastNameInput;

    @FindBy(id="postal-code")
    private WebElement zipCodeInput;
    @FindBy(css="a.btn_action.cart_button[href='./checkout-complete.html']")
    private WebElement finishButton;

    public void addToCart() {
        addToCartButton.click();
    }

    public void goToCart() {
        cartIcon.click();
    }

    public void removeItem() {
        removeButton.click();
    }

    public void proceedToCheckout() {
        checkoutButton.click();
    }

    public void continueShopping() {
        continueShoppingButton.click();
    }
    @FindBy(xpath="//h2[@class='complete-header']")
    private WebElement orderConfirmationMessage;
    public void finishOrder() {
        finishButton.click();
    }
    public boolean isOrderSuccessful() {
        return orderConfirmationMessage.isDisplayed();
    }
    public void enterCheckoutDetails(String firstName,String lastName,String zip) {
    	
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            
            wait.until(ExpectedConditions.visibilityOf(firstNameInput));     
            firstNameInput.sendKeys(firstName);
        
        lastNameInput.sendKeys(lastName);
        zipCodeInput.sendKeys(zip);
    }

}



