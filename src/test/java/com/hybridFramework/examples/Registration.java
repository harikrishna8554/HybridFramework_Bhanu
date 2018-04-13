package com.hybridFramework.examples;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.LoginPage;
import com.hybridFramework.PageObject.MyAccountPage;
import com.hybridFramework.PageObject.RegistrationPage;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class Registration  extends TestBase{
	
	private static final  Logger logger=LoggerHelper.getLogger(Registration.class);
	private RegistrationPage registration;
	private MyAccountPage myAccount;
	private LoginPage login;
	@Test(groups= {"smoke","regression"})
	public void testRegistration()
	{
		logger.info(Registration.class.getName()+": Test Started!");
		//Enter URL
		
		Config config = new Config(OR);
		//Click on Sign In
		driver.get(config.getWebsite());
		login=new LoginPage(driver);
		login.clickOnSignInLink();
		//Create an account
		login.enterRegistrationEmail();
		registration = login.clickOnCreateAnAccount();
		//Registration Page
		registration.setMrRadioButton();
		registration.setFirstName("harik");
		registration.setLastname("krishna");
		registration.setPassword("9059733843");
		registration.setDay("25");
		registration.setMonth("February");
		registration.setYear("1993");
		//Your Address
		registration.setYourAddressFirstName("hanish");
		registration.setYourAddressLastName("krishna");
		registration.setYourAddressCompany("TechMahindra");
		registration.setAddress("2-3-603,new patel nager,amberpet");
		registration.setYourAddressCity("hyderabad");
		registration.setYourAddressState("Connecticut");
		registration.setYourAddressPostCode("00000");
		registration.setAdditionalInformation("Life is beautifull!");
		registration.setHomePhone("9291509904");
		registration.setMobilePhone("8456278965");
		registration.setAddressAlias("7/g,brucelee colony");
		registration.clickRegistration();
		//My Account Page
		 myAccount=new MyAccountPage(driver);
		boolean status = myAccount.verifySuccessRegistrationMsg();
		String success = myAccount.successRegistrationMsg.getText();
		if(status)
		{
			logger.info(success+": Verification Successful!");
			assertTrue(true, "Verification Successful!");
		}else
		{
			logger.info(success+": Verification NOT Successfull!");
			assertTrue(false, "Verification NOT Successfull!");
		}
		logger.info(Registration.class.getName()+" :Test Finished!");
		
		driver.quit();
		
		
		
		
	}

}
