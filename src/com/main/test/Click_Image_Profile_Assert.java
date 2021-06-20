package com.main.test;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.main.pages.HomePage;
import com.main.pages.LoginPage;

import utilities.BaseTest;
import utilities.CommonExcelRead;

public class Click_Image_Profile_Assert extends BaseTest {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(BaseTest.class.getName());

	@BeforeTest
	@Parameters("browsername")
	public void initiate_launch(String browsername) {
		// super.logger_Method(Click_Image_Profile_Assert.class.getName());
		driver = LaunchURL(browsername);
	}

	@Test(enabled = true, priority = 1)
	public void navigatetoScoll() throws IOException {

		CommonExcelRead data = new CommonExcelRead();
		ArrayList<String> creds = data.getData("Credentials");
		log.info("Opening LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.loginField(creds.get(1));
		lp.passwordField(creds.get(2));
		log.info("Submitting Login Button");
		lp.loginsubmit();

		log.debug("Submitting Credentials");
		HomePage hp = new HomePage(driver);
		/*
		 * WebElement sp1= driver.findElement(HomePage.spinner);
		 * super.explicitVisible(sp1);
		 */

		// hp.click_Element();

		String expectedText = "My Profile";
		log.info("Hover On Profile");

		hp.hoverProfile();
		String actualText = hp.myProfile();
		log.error("Text Not Match On Hover");
		try {
			Assert.assertEquals(actualText, expectedText);

		} catch (Exception e) {
			// TODO Auto-generated catch block

		}
	}

	@Test(dependsOnMethods = { "navigatetoScoll" }, enabled = true, priority = 2)
	public void clickTest() throws InterruptedException, IOException {

		log.info("Opening HomePage");

		HomePage hp = new HomePage(driver);

		/*
		 * WebElement sp1= driver.findElement(HomePage.scroll); hp.explicitVisible(sp1);
		 */
		Thread.sleep(20000);
		String current_url = driver.getCurrentUrl();
		driver.get(current_url);
		Thread.sleep(30000);
		log.info("Clicking on Scroll Button");
		hp.imageComparisonScrollClick("\nPDF Actions\n");

		log.debug("Installing	PDF Actions Addon");
		hp.image_Comapre_Install();
		/*
		 * String install_actual_message= hp.install_message(); String
		 * install_expected_message ="Succeeded to install \"PDF Actions\" addon!"; try
		 * { Assert.assertEquals(install_actual_message, install_expected_message); }
		 * catch (Exception e) { // TODO Auto-generated catch block }
		 */
		log.info("UnInstalling Image Compare Addon");
		hp.image_Comapre_UnInstall();
		hp.image_Comapre_UnInstall_Confirm();
		log.info("UnInstalled Image Compare Addon");
	}

	@AfterTest
	public void tearDown() throws Exception {

		driver.close();
	}

}
