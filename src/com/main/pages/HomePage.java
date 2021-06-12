package com.main.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class HomePage  {
	WebDriver driver;
	
	@FindBy(how=How.XPATH,using="//div[@title='Scroll to Element']")
	private WebElement scrolltoElements;
	
	@FindBy(how=How.ID,using="my-profile-link")
	private WebElement profile;
	
	@FindBy(how=How.XPATH,using="//div[@class='user-default-avatar ng-scope']")
	private WebElement hoverprofile;
	
	@FindBy(how=How.XPATH,using="//div[@class='user-popup-panel-footer-logout']")
	private WebElement logout;
	
	@FindBy(how=How.XPATH,using="//div[@class='top-bar-container ng-scope']")
	private WebElement spinner;
	
	@FindBy(how=How.XPATH,using="//div[@class='carousel-arrow-container'][2]")
	private WebElement scroll;
	
	@FindBy(how=How.XPATH,using="//div[@title='PDF Actions']")
	private WebElement plugin_button;
	
	@FindBy(how=How.XPATH,using="//div[@class='addon-info-action addon-info-btn blue ng-binding ng-scope']")
	private WebElement imageCompareInstall;
	
	@FindBy(how=How.XPATH,using="//div[@class='addon-info-action addon-info-link ng-binding ng-scope']")
	private WebElement imageCompareUnInstall;
	
	@FindBy(how=How.XPATH,using="//div[@class='ng-binding ng-scope ng-alert-all-buttons-epic ng-alert-right ng-alert-blue-button']")
	private WebElement unInstallImageComparisonConfirm;
	
	@FindBy(how=How.XPATH,using="//div[@class='addon-info-close-icon']")
	private WebElement closeAddOnInfo;
	
	@FindBy(how=How.XPATH,using="//div[text()='Succeeded to install \\\"PDF Actions\\\" addon!']")
	private WebElement install_Message;
	
	@FindBy(how=How.XPATH,using="//div[text()='Succeeded to uninstall \\\"PDF Actions\\\" addon!']")
	private WebElement uninstall_Message;
	
	@FindBy(how=How.XPATH,using="//div[@class='addon-item-name tp-text-ellipsis ng-binding']")
	private List<WebElement> list_scroll_Elements;
	
	//By scrolltoElements= By.xpath("//div[@title='Scroll to Element']");
	//By profile= By.id("my-profile-link");
	//By hoverprofile= By.xpath("//div[@class='user-default-avatar ng-scope']");
	//By logout= By.xpath("//div[@class='user-popup-panel-footer-logout']");
    //public static By spinner= By.xpath("//div[@class='top-bar-container ng-scope']");
    //public static By scroll = By.xpath("//div[@class='carousel-arrow-container'][2]");
    //By imageCompare= By.xpath("//div[@title='Image Comparison']");
    //public static By imageCompareInstall= By.xpath("//div[@class='addon-info-action addon-info-btn blue ng-binding ng-scope']");
    //public static By imageCompareUnInstall= By.xpath("//div[@class='addon-info-action addon-info-link ng-binding ng-scope']");
    //By unInstallImageComparisonConfirm= By.xpath("//div[@class='ng-binding ng-scope ng-alert-all-buttons-epic ng-alert-right ng-alert-blue-button']");
    //By closeAddOnInfo= By.xpath("//div[@class='addon-info-close-icon']");
    //By install_Message= By.xpath("//div[text()='Succeeded to install \"Image Comparison\" addon!']");
    //By uninstall_Message= By.xpath("//div[text()='Succeeded to uninstall \"Image Comparison\" addon!']");
    //By list_scroll_Elements= By.xpath("//div[@class='addon-item-name tp-text-ellipsis ng-binding']");
    
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void click_Element() {
		this.scrolltoElements.click();
	}
	
	public void hoverProfile()
	{
		Actions act= new Actions(driver);
		act.moveToElement(this.hoverprofile).perform();
	}
	public String myProfile()
	{
		String text=this.profile.getText();
		return text;
	}
	public void logOut()
	{
		this.logout.click();
	}
	
	public void imageComparisonScrollClick(String elementName) {
				
		for (int i=1;i<list_scroll_Elements.size();i++)
		{
			WebElement elements= this.list_scroll_Elements.get(i);
			
			String innerhtml=elements.getAttribute("innerHTML");			
			if(innerhtml.contentEquals(elementName))
			{
				elements.click();
				break;
			} else {
				this.scroll.click();
			}
		}
		
	}
	
	public void image_Comapre_Install() {
		this.imageCompareInstall.click();
	}
	public void image_Comapre_UnInstall() {
		this.imageCompareUnInstall.click();
	}
	public void image_Comapre_UnInstall_Confirm() {
		this.unInstallImageComparisonConfirm.click();
	}
	public String install_message()
	{
		String text=this.install_Message.getText();
		return text;
	}
	public String uninstall_message()
	{
		String text=this.uninstall_Message.getText();
		return text;
	}
}
