package com.BaseClass;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.common.CommonActions;
import com.qa.common.CommonWaits;
import com.qa.pages.HomePage;
import com.qa.reports.LoggerClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static CommonWaits waits;
	public static CommonActions cm;
	public static JavascriptExecutor jsExecutor;
	public static HomePage hp;


	
	@BeforeMethod
	public void setUp() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		LoggerClass.log("Broswer is launching>>>>>>");
		driver.manage().window().maximize();
		driver.get("https://www.supplyhouse.com/");
		//driver.get(configProperty.getUrl());
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		initializaton();
	}

	@AfterMethod
	public void quttingBrowser() {
		driver.quit();
		LoggerClass.log("Broswer is openening>>>>>>");
	}
    
	public void initializaton() {
		hp=new HomePage(driver);
		waits = new CommonWaits();
		cm = new CommonActions();
		jsExecutor = (JavascriptExecutor) driver;
	}
}