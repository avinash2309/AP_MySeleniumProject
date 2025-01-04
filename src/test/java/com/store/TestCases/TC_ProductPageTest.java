package com.store.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.PageObject.AccountCreationDetailsPage;
import com.store.PageObject.IndexPage;
import com.store.PageObject.MyAccount;
import com.store.PageObject.RegisteredUserAccount;
import com.store.PageObject.SearchResultPage;

public class TC_ProductPageTest extends BaseClass{

	@Test (priority = 2)
	public void verifySearchProduct() throws IOException {
		
		String searchKey = "T-shirts";
		logger.info("\n********Test Case Search Product Started*******");
		
		//Sign In
		IndexPage indexPage = new IndexPage(driver);
		indexPage.clickOnSignIn();
		
		//Enter Account Detail Email and Password
		AccountCreationDetailsPage accountcreationdetail = new AccountCreationDetailsPage(driver);
		accountcreationdetail.enterEmail("mr.avinashpol@gmail.com");
		accountcreationdetail.EnterPassword("Avinash@123");
		MyAccount myAccount = new MyAccount(driver);
		myAccount.clickOnSignInButton();
		
		//
		RegisteredUserAccount registeredUser = new RegisteredUserAccount(driver);
		registeredUser.enterDateInSearchBox(searchKey);
		registeredUser.clickOnSearchButton();
		SearchResultPage searchresult = new SearchResultPage(driver);
		String result = searchresult.getSearchResult();
		
		if(result.contains(searchKey)) {
			logger.info("Verify - Product Search");
			Assert.assertTrue(true);
			registeredUser.clickOnSignOut();
		}else {
			logger.info("Verify - Failed Search Result is not matched with Expected result");
			captureScreenShot(driver, "verifySearchProduct");
			Assert.assertTrue(false);
			
		}
	}
	
}
