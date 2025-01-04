package com.store.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.store.PageObject.AccountCreationDetailsPage;
import com.store.PageObject.IndexPage;
import com.store.PageObject.MyAccount;
import com.store.PageObject.RegisteredUserAccount;
import com.store.Utilities.ReadConfig;
import com.store.Utilities.ReadExcelFile;

import jdk.internal.org.jline.utils.Log;

public class TC_MyAccountPageTestDataDriven extends BaseClass {

	@Test (enabled=false)
	public void verifyRegistrationAndLogin() {

		IndexPage indexPage = new IndexPage(driver);

		indexPage.clickOnSignIn();
		logger.info("Click on Sign in Button");

		MyAccount myAccount = new MyAccount(driver);

		myAccount.enterEmailCreateAdress("tes4t@tesrt.asd");
		logger.info("Enter Email Address into Create Address Textbox field");

		myAccount.clickSubmitCreate();
		logger.info("Click on Submit Button");

		AccountCreationDetailsPage accountcreationdetail = new AccountCreationDetailsPage(driver);
		accountcreationdetail.titleMr();
		accountcreationdetail.firstName("Avinash");
		accountcreationdetail.lastName("Pol");
		accountcreationdetail.EnterPassword("Avinash@123");
		logger.info("Enter user Details into Account Creation Page");
		accountcreationdetail.registerButton();
		logger.info("Click on Enter Button");

		RegisteredUserAccount registeredUser = new RegisteredUserAccount(driver);
		String username = registeredUser.getProfileName();

		Assert.assertEquals("Avinash Pol", username);

	}

	@Test (dataProvider = "loginDataProvider", priority = 1)
	public void verifyLogin(String userEmail, String userPwd, String expectedUserName) throws IOException {
		
		logger.info("Verify Login Test Execution started");
		IndexPage indexPage = new IndexPage(driver);
		indexPage.clickOnSignIn();
		logger.info("Click on Sign in Button");

		AccountCreationDetailsPage accountcreationdetail = new AccountCreationDetailsPage(driver);
		accountcreationdetail.enterEmail(userEmail);
		logger.info("Enter Email Address");
		accountcreationdetail.EnterPassword(userPwd);
		logger.info("Enter Password");
		MyAccount myAccount = new MyAccount(driver);
		myAccount.clickOnSignInButton();
		logger.info("Click on Sign in Button");
		RegisteredUserAccount registeredUser = new RegisteredUserAccount(driver);
		String username = registeredUser.getProfileName();
		
		if(username.equals(expectedUserName)) {
			logger.info("Verify Login - Passed");
			Assert.assertTrue(true);
			registeredUser.clickOnSignOut();
			
		}else {
			logger.info("Verify Login - Failed");
			captureScreenShot(driver, "verifyLogin");
			Assert.assertTrue(false);
		}
		
		

	}
	@DataProvider (name = "loginDataProvider")
	public String[][] loginDataProvider() {
		
		String fileName = System.getProperty("user.dir")+"\\TestData\\MyStoreTestData.xlsx";
		
		int ttRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
		
		String data[][] = new String[ttRows-1][ttColumns];
		for (int i=1; i<ttRows; i++) {
			for(int j=0; j<ttColumns; j++) {
				
				data[i-1][j] = ReadExcelFile.getCellValue(fileName, "LoginTestData", i, j);
			}
		}
		return data;
		
	}

}
