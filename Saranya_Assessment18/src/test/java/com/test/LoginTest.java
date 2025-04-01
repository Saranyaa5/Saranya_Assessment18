package com.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.pages.LoginPage;
import com.utils.DataProviderClass;
import com.utils.ListenerClass;

@Listeners(ListenerClass.class)
public class LoginTest extends BaseTest {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviderClass.class)
	public void loginFunctionalityTest(String username, String password,String testcaseName) throws InterruptedException {
	    LoginPage loginPage = new LoginPage(getDriver());
	    loginPage.performLogin(username, password);
	    
	    String emptyUserError ="Epic sadface: Username is required";
	    String emptyPassError="Epic sadface: Password is required";
	    String invalidCredsError ="Epic sadface: Username and password do not match any user in this service";
	    //String actualError=loginPage.geterrorMessage();
	    String sccess ="login success";
	    if (testcaseName.equals("no_user")) {
	    	String actualError=loginPage.geterrorMessage();
	    	System.out.println("actual message: "+actualError);
	        Assert.assertEquals(actualError, emptyUserError,"Empty username validation failed");
	    }
	    else if (testcaseName.equals("no_pass")) {
	    	String actualError=loginPage.geterrorMessage();
	    	System.out.println("actual message: "+actualError);
	        Assert.assertEquals(actualError, emptyPassError,"Empty password validation failed");
	    }
	    else if (testcaseName.equals("invalid"))
	    {
	    	String actualError=loginPage.geterrorMessage();
	    	System.out.println("actual message: "+actualError);
	        Assert.assertEquals(actualError, invalidCredsError,"Invalid credentials validation failed");
	    }
	    else {
	    	String heading=loginPage.getHeading();
	        Assert.assertTrue(heading.equals("Products"),"Password correct but login failed");
	    }
	}

}