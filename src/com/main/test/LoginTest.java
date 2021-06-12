package com.main.test;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
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
	@Test(dataProvider = "DataShare")
	public void loginTest(String login, String password)
	{
		ExtentReport.createTest("Login Test");
		logger.info("Opening LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.loginField(login);
		lp.passwordField(password);
		logger.info("Submitting Login Button");
		lp.loginsubmit();
		ExtentReport.test.pass("Successfully Login");
		
	}
	@DataProvider(name="DataShare")
	public Object[][] getData() {
		
		
		CommonExcelRead er= new CommonExcelRead("./TestAppProject.xlsx");
		int rowc=er.getrowcount(0);
		System.out.println(rowc);
		Object[][] data= new Object[rowc][2];
		for(int i=0;i<rowc;i++)
		{
			data[i][0]= er.getExcelData(0, i, 0);
			data[i][1]= er.getExcelData(0, i, 1);
		}
		return data;
		
		 
		
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
