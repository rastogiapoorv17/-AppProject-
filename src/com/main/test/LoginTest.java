package com.main.test;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.main.pages.LoginPage;

import utilities.BaseTest;
import utilities.CommonExcelRead;

public class LoginTest extends BaseTest {
	
	public WebDriver driver;
	
	@BeforeTest
	@Parameters("browsername")
	public void initiate_launch(String browsername) {
		super.logger_Method(LoginTest.class.getName());
		driver=LaunchURL(browsername);
	}
	@Test
	public void loginTest() throws IOException
	{
		CommonExcelRead data= new CommonExcelRead();
		ArrayList<String> creds= data.getData("Credentials");
		logger.info("Opening LoginPage");
		LoginPage lp = new LoginPage(driver);
		System.out.println(creds.get(1));
		lp.loginField(creds.get(1));
		lp.passwordField(creds.get(2));
		logger.info("Submitting Login Button");
		lp.loginsubmit();
			
	}

	
	@AfterTest 
	 public void  tearDown() throws Exception 
   {
		driver.close();
   }
	
	
}
