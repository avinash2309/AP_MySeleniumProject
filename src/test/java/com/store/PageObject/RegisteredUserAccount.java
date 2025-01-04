package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserAccount {
	
	 WebDriver ldriver;
	 
	 public RegisteredUserAccount(WebDriver rdriver) {
		 ldriver = rdriver;
		 PageFactory.initElements(rdriver, this);
	 }
	 
	 @FindBy (xpath = "//a[@title='View my customer account']")
	 WebElement lable_profileName;
	 
	 @FindBy (xpath = "//a[@title ='Log me out']" )
	 WebElement btn_signOut;
	 
	 @FindBy (name = "search_query")
	 WebElement searchBox;
	 
	 @FindBy (name = "submit_search")
	 WebElement Btn_submitSearch;
	 
	 public String getProfileName() {
		 String text = lable_profileName.getText();
		 return text;
	 }
	 
	 public void clickOnSignOut() {
		 btn_signOut.click();
	 }
	
	 public void enterDateInSearchBox(String searchKey) {
		 searchBox.sendKeys(searchKey);
	 }
	 
	 public void clickOnSearchButton() {
		 Btn_submitSearch.click();
	 }

}
