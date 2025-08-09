package test;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod; 
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BasePage;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import util.DataUtil;
import util.MyXLSReader;


public class LoginTest extends BasePage{

	WebDriver driver;
	MyXLSReader excelReader;
	
	@Test(dataProvider="dataSupplier")
	public void testLogin(HashMap<String, String> hMap) { //String email, String password will be converted to Hashmap
		
		if(!DataUtil.isRunnable(excelReader, "LoginTest", "Testcases") || hMap.get("Runmode").equals("N")) { //verifying in the test and data level
			throw new SkipException("Run mode is set to N, hence not executed");	
		}
		else {
			
			driver = openBrowserandApplicationURL(hMap.get("Browser"));	//method called from BasePage
			
			HomePage hp = new HomePage(driver);
			hp.clickmyAccountDropMenu();
			LoginPage lp = hp.selectLoginOption();
			lp.enterEmail(hMap.get("Username"));
			lp.enterPassword(hMap.get("Password"));
			AccountPage ap = lp.clickLoginButton();
			ap.verifyDisplayEditAccInfo();
			
			
			//Validating the ExpectedResult from the sheet whether it is failure or success 
			String expectedResult = hMap.get("ExpectedResult");
			boolean expectedConvertedResult = false;
			
			if(expectedResult.equalsIgnoreCase("Success")) {
				expectedConvertedResult = true;
			}
			else if(expectedResult.equalsIgnoreCase("Failure")){
				expectedConvertedResult = false;
			}
			
		
			//After successful login; for validation webElement present on the UI is validated
			boolean actualResult = false;
			
			actualResult = ap.verifyDisplayEditAccInfo();
			
			Assert.assertEquals(actualResult, expectedConvertedResult);
			
		}	
		}
	

	//Calling Data provider method from DataUtil class
	@DataProvider
	public Object[][] dataSupplier(){
		
		Object[][] data = null;
		
		try {
			excelReader = new MyXLSReader("src\\test\\resources\\TutorialsNinja.xlsx");
			data = DataUtil.getTestData(excelReader, "LoginTest", "Data"); 
			//excelReader,String TestName,String SheetName 
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		return data;
	}
	
	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}
}
