package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	
	WebDriver ldriver;
	
	public IndexPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText = "Sign in")
	WebElement signIn;
	
	@FindBy (xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
	WebElement tShirtMenu;
	
	public void clickOnSignIn() {
		signIn.click();
	}
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	public void clickOnTshirtMenu() {
		tShirtMenu.click();
		
	}
	

}
