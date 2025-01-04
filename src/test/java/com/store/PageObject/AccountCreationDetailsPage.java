package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationDetailsPage {

	WebDriver ldriver;
	
	public AccountCreationDetailsPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy (id = "id_gender1")
	WebElement radioBtn_titleMr;
	
	@FindBy (id = "customer_firstname")
	WebElement txt_firstName;
	
	@FindBy (id = "customer_lastname")
	WebElement txt_lastName;
	
	@FindBy (id = "email")
	WebElement txt_email;
	
	@FindBy (id = "passwd")
	WebElement txt_password;
	
	@FindBy (id = "submitAccount" )
	WebElement btn_register;
	
	
	public void titleMr() {
		radioBtn_titleMr.click();
	}
	
	public void firstName(String firstname) {
		txt_firstName.sendKeys(firstname);
	}
	
	public void lastName(String lastname) {
		txt_lastName.sendKeys(lastname);
	}
	
	public void enterEmail(String email) {
		txt_email.sendKeys(email);
	}
	
	public void EnterPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void registerButton() {
		btn_register.click();
	}
		
}
