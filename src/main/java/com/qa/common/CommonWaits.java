package com.qa.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import com.BaseClass.BaseClass;
import com.qa.reports.LoggerClass;

public class CommonWaits {

	public void waitUntilClickable(WebElement element) {
		try {
			BaseClass.wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (NullPointerException e) {
			LoggerClass.log(element + " : Not Found");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void waitUntilVisible(WebElement element) {
		try {
			BaseClass.wait.until(ExpectedConditions.visibilityOf(element));
		} catch (NullPointerException e) {
			LoggerClass.log(element + " : Not Found");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void waitUntilSelectable(WebElement element) {
		try {
			BaseClass.wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (NullPointerException e) {
			LoggerClass.log(element + " : Not Found");
			e.printStackTrace();
			Assert.fail();
		}
	}
}
