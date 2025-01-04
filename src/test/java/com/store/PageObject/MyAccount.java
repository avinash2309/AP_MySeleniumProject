package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
	
	WebDriver ldriver;
	
	//Constructor
	public MyAccount(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//Identify WebElemets
	@FindBy (id = "email_create")
	WebElement txt_emailCreate;
	
	@FindBy(id = "SubmitCreate")
	WebElement btn_submitCrate;
	
	@FindBy (id = "email")
	WebElement txt_email;
	
	@FindBy (id = "passwd")
	WebElement txt_password;
	
	@FindBy (id = "SubmitLogin")
	WebElement btn_signIn;
	
	
	//Identify Action on WebElements
	public void enterEmailCreateAdress(String emailAdd) {
		txt_emailCreate.sendKeys(emailAdd);
	}
	
	public void clickSubmitCreate() {
		btn_submitCrate.click();
	}
	
	public void clickOnSignInButton() {
		btn_signIn.click();
	}
	
	
	
}
