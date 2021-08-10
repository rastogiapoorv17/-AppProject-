package com.main.test;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	public static Logger log = LogManager.getLogger(BaseTest.class.getName());

	@BeforeTest
	@Parameters("browsername")
	public void initiate_launch(String browsername) {
		// super.logger_Method(LoginTest.class.getName());
		driver = LaunchURL(browsername);
		log.info("Initializing Driver");
	}

	@Test(invocationCount = 5, threadPoolSize = 5)
	public void loginTest() throws IOException {
		CommonExcelRead data = new CommonExcelRead();
		ArrayList<String> creds = data.getData("Credentials","Login");
		log.info("Opening LoginPage");
		LoginPage lp = new LoginPage(driver);
		System.out.println(creds.get(1));
		lp.loginField(creds.get(1));
		lp.passwordField(creds.get(2));
		log.info("Submitting Login Button");
		lp.loginsubmit();
		log.debug("Submitting Login Credentials");

	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.close();
	}

}
