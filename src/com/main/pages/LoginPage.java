package com.main.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(how=How.CSS,using="[id='tp-signup-link']")
	private WebElement signUpLink;
	
	@FindBy(how=How.XPATH,using="//input[@id='username']")
	private WebElement uname;
	
	@FindBy(how=How.XPATH,using="//input[@id='password']")
	private WebElement passwordElement;
	
	@FindBy(how=How.CSS,using="input[name='login']")
	private WebElement submit;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void loginField(String login) {
		this.uname.sendKeys(login);
	}
	
	public void passwordField(String password) {
		this.passwordElement.sendKeys(password);
	}
	public void loginsubmit() {
		submit.click();
	}
	public void signupClick() {
		this.signUpLink.click();
	}
	
}
