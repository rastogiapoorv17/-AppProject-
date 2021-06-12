package com.main.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignUp {
	
	WebDriver driver;
	
	@FindBy(how=How.CSS,using="[id='tp-continue-btn']")
	private WebElement ctnbtn;
	
	@FindBy(how=How.ID,using="first-name")
	private WebElement fname;
	
	@FindBy(how=How.ID,using="last-name")
	private WebElement lname;
	
	@FindBy(how=How.ID,using="email")
	private WebElement email;
	
	@FindBy(how=How.ID,using="password")
	private WebElement password;
	
	@FindBy(how=How.CSS,using="[class='tp-checkbox-input-view']")
	private WebElement check;
	
	@FindBy(how=How.CSS,using="[id='tp-sign-up']")
	private WebElement signup;
	
	
	public SignUp(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void fname_Enter()
	{
		this.fname.sendKeys("Raj");
	}
	public void lname_Enter()
	{
		this.lname.sendKeys("Sharma");
	}
	public void email_Enter(String mail)
	{
		this.email.sendKeys(mail);
	}
	
	public void continuebtn()
	{
		this.ctnbtn.click();;
	}
	public void password_Enter()
	{
		this.password.sendKeys("Welcome123");
	}
	public void check_Select()
	{
		this.check.click();
	}
	public void submit_Click()
	{
		this.signup.click();
	}

}
