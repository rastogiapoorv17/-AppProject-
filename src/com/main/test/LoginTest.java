package com.main.test;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.main.pages.LoginPage;

import utilities.BaseTest;
import utilities.CommonExcelRead;
import utilities.ExtentReport;

public class LoginTest extends BaseTest {
	
	@BeforeTest
	public void initiate_launch() {
		super.logger_Method("LoginTest");
		ExtentReport.ExtentReportInitiate();
	}
	@Test
	public void loginTest() throws IOException
	{
		CommonExcelRead data= new CommonExcelRead();
		ArrayList<String> creds= data.getData("Credentials");
		ExtentReport.createTest("Login Test");
		logger.info("Opening LoginPage");
		LoginPage lp = new LoginPage(driver);
		System.out.println(creds.get(1));
		lp.loginField(creds.get(1));
		lp.passwordField(creds.get(2));
		logger.info("Submitting Login Button");
		lp.loginsubmit();
		ExtentReport.test.pass("Successfully Login");
		
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
