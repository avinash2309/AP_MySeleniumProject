package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
	WebDriver ldriver;
	
	public SearchResultPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy (xpath =  "//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")
	WebElement searchResultProduct;
	
	public String getSearchResult() {
		return searchResultProduct.getText();
	}

}
