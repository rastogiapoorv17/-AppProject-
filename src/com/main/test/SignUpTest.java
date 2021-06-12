package com.main.test;

import java.util.concurrent.TimeUnit;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.main.pages.LoginPage;
import com.main.pages.SignUp;

import utilities.BaseTest;
import utilities.ExtentReport;

public class SignUpTest extends BaseTest {
	
	@BeforeTest
	public void initiate_launch() {
		super.logger_Method("LoginTest");
		ExtentReport.ExtentReportInitiate();
	}
	
	@Test
	public void registerTest() {
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		ExtentReport.createTest("SignUp Test");
		logger.info("Signing Up");
		LoginPage lg= new LoginPage(driver);
		lg.signupClick();
		SignUp sg = new SignUp(driver);
		sg.email_Enter(super.email());
		sg.continuebtn();
		sg.fname_Enter();
		sg.lname_Enter();
		sg.password_Enter();
		sg.check_Select();
		sg.submit_Click();
		logger.info("Successfully Signup");
		ExtentReport.test.pass("Successfully SignUp");
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
