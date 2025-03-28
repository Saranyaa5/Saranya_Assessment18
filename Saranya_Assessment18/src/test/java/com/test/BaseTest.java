package com.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	private static final ThreadLocal<WebDriver> localthread=new ThreadLocal<>();
	 public WebDriver getDriver(){
	      return localthread.get();
	  }
	@BeforeMethod
	public void beformethod() {
		 WebDriver driver=new ChromeDriver();
	     localthread.set(driver); 
	      driver.get("https://www.saucedemo.com/v1/index.html");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	  @AfterMethod
	  public void aftermethod() {
		if (getDriver()!=null) {
		  getDriver().quit();
		  localthread.remove();
		  }
	  }
}



