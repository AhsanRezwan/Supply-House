package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.common.CommonActions;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "react-header-search-input") public WebElement SearchBox;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement ClickButton;
	
	public void searchBox(CommonActions cm, String val) {
		cm.writeText(SearchBox, val);
	}
	public void clickButton(CommonActions cm) {
		cm.clickMethod(ClickButton);
	}
}
