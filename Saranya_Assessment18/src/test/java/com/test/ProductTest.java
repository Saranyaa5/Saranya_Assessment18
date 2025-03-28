package com.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.utils.ListenerClass;

@Listeners(ListenerClass.class)
public class ProductTest extends BaseTest {

    LoginPage loginPage;
    ProductPage productPage;

    @BeforeMethod
    public void LocalBefore() {
        loginPage = new LoginPage(getDriver());
        loginPage.performLogin("standard_user","secret_sauce");
    }
    @Test
    public void completeShoppingFlow() {
        productPage = new ProductPage(getDriver());
        productPage.addToCart();
        productPage.goToCart();
        Assert.assertTrue(getDriver().getCurrentUrl().contains("cart"),"Not in cart");
        productPage.removeItem();
        productPage.proceedToCheckout();
        productPage.enterCheckoutDetails("SARANYA","A","637103");
        productPage.clickContinue();
        productPage.finishOrder();
        Assert.assertTrue(productPage.isOrderSuccessful(),"Order not successful");
    }
}
