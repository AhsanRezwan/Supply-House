package com.TestClass;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.BaseClass.BaseClass;
import com.qa.utilities.ExcelFile;

public class TestClass extends BaseClass {

	@DataProvider(name = "ExcelData")
	public Object[][] getAutoQuoteData(){
	String excelPath ="/Users/ahsanarezwan/eclipse-workspace/SupplyHouse/excel/Products.xlsx";
	String sheetName ="Sheet1";
	ExcelFile excelReader=new ExcelFile(excelPath,sheetName);
	Object[][] data=excelReader.getData();
	return data;
	}
	@Test(dataProvider = "ExcelData")
	public void autoQuoteTest(String val)  {
		BaseClass.hp.searchBox(cm, val);
		onTestPass();
	}
	
	public void onTestPass() {
		 String Path=System.getProperty("user.dir");
		File ScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileHandler.copy(ScreenShot, new File(Path+"/ss/"+"shot.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
	  }
}
