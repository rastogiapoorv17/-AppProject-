package com.main.test;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;

//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.main.pages.HomePage;
import com.main.pages.LoginPage;

import utilities.BaseTest;
import utilities.CommonExcelRead;
//import utilities.CommonExcelRead;
import utilities.ExtentReport;



public class Click_Image_Profile_Assert extends BaseTest {
	
	@BeforeTest
	public void initiate_launch() {
		super.logger_Method("LoginTest");
		ExtentReport.ExtentReportInitiate();
	}
	
	@Test(enabled = false,priority=1)
	public void navigatetoScoll(String login, String password) throws IOException
	{

		CommonExcelRead data= new CommonExcelRead();
		ArrayList<String> creds= data.getData("Credentials");
		ExtentReport.createTest("My Profile Text Test");
		logger.info("Opening LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.loginField(creds.get(1));
		lp.passwordField(creds.get(2));
		logger.info("Submitting Login Button");
		ExtentReport.test.info("Submitting Login Button");
		lp.loginsubmit();
		
		logger.info("Opening HomePage");
		ExtentReport.test.info("Opening HomePage");
		HomePage hp = new HomePage(driver);
		/*
		 * WebElement sp1= driver.findElement(HomePage.spinner);
		 * super.explicitVisible(sp1);
		 */

		//hp.click_Element();
		
		String expectedText= "My Profile";
		logger.info("Hover On Profile");
		ExtentReport.test.info("Hover On Profile");
		hp.hoverProfile();
		String actualText= hp.myProfile();
		logger.info("Verifying Test Match");
	    try {
			Assert.assertEquals(actualText, expectedText);
			ExtentReport.test.pass("Text Matched");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			ExtentReport.test.fail(e.getMessage());
		}
	}
	@Test(enabled = true,priority=2)
	public void clickTest() throws InterruptedException, IOException
	{
		CommonExcelRead data= new CommonExcelRead();
		ArrayList<String> creds= data.getData("Credentials");
		ExtentReport.createTest("Install Image Comparison Test");
		logger.info("Opening LoginPage");
		ExtentReport.test.info("Submitting Login Button");
		LoginPage lp = new LoginPage(driver);
		lp.loginField(creds.get(1));
		lp.passwordField(creds.get(2));
		logger.info("Submitting Login Button");
		lp.loginsubmit();
		logger.info("Successfully Login");
		
		logger.info("Opening HomePage");
		ExtentReport.test.info("Opening HomePage");
		HomePage hp = new HomePage(driver);
		
		/*
		 * WebElement sp1= driver.findElement(HomePage.scroll); hp.explicitVisible(sp1);
		 */
		 Thread.sleep(20000);
		String current_url=driver.getCurrentUrl(); driver.get(current_url);
		  Thread.sleep(30000);
		logger.info("Clicking on Scroll Button");
		hp.imageComparisonScrollClick("\nPDF Actions\n");
		
		logger.info("Installing	PDF Actions Addon");
		hp.image_Comapre_Install();
		/*
		 * String install_actual_message= hp.install_message(); String
		 * install_expected_message ="Succeeded to install \"PDF Actions\" addon!"; try
		 * { Assert.assertEquals(install_actual_message, install_expected_message);
		 * ExtentReport.test.pass("Text Match"); } catch (Exception e) { // TODO
		 * Auto-generated catch block ExtentReport.test.fail(e.getMessage()); }
		 */
		logger.info("UnInstalling Image Compare Addon");
		hp.image_Comapre_UnInstall();
		hp.image_Comapre_UnInstall_Confirm();
		logger.info("UnInstalled Image Compare Addon");
	}
	
	@AfterMethod 
	 public void  tearDown(ITestResult result) throws Exception 
    {
		ExtentReport extent = new ExtentReport(result, driver);
		extent.teardown(result,driver);
		driver.close();
    }
	
	@AfterTest
	public void flushReport()
	{
		ExtentReport.extent.flush();
		
	}
	 
	 
}
