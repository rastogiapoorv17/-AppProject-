package com.main.test;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.main.pages.LoginPage;
import com.main.pages.SignUp;

import utilities.BaseTest;

public class SignUpTest extends BaseTest {

	public static Logger log = LogManager.getLogger(BaseTest.class.getName());

	@BeforeTest
	@Parameters("browsername")
	public void initiate_launch(String browsername) {
		// super.logger_Method(SignUpTest.class.getName());
		driver = LaunchURL(browsername);
	}

	@Test
	public void registerTest() {
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		log.info("Signing Up");
		LoginPage lg = new LoginPage(driver);
		lg.signupClick();
		SignUp sg = new SignUp(driver);
		sg.email_Enter(super.email());
		sg.continuebtn();
		sg.fname_Enter();
		sg.lname_Enter();
		sg.password_Enter();
		sg.check_Select();
		sg.submit_Click();
		log.info("Successfully Signup");

	}

	@AfterTest
	public void tearDown() throws Exception {

		driver.close();
	}

}
