package com.hybridFramework.examples;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.LoginPage;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class LoginToApplication extends TestBase {
	
	private static final Logger logger=LoggerHelper.getLogger(LoginToApplication.class);
	
	@Test(groups= {"smoke"})
	public void testLoginToApplication()
	{
		logger.info(LoginToApplication.class.getName()+":  test Started!");
		
		Config config = new Config(OR);
		driver.get(config.getWebsite());
		
		LoginPage login=new LoginPage(driver);
		
		login.loginToApplication(config.getUserName(),config.getPassword());
		
		boolean status = login.verifySuccessLoginMsg();
		logger.info(LoginToApplication.class.getName()+":  Login succesfull!");
		if(status)
		{
			logger.info("Verified Succesfully!!!");
			assertTrue(true,"Verified Succesfully!!!");
		}else
		{
			logger.info("verification NOT Succesfull!");
			assertTrue(false,"verification NOT Succesfull!");
		}
		logger.info(LoginToApplication.class.getName()+":  test Finished!");
		assertTrue(false);
		driver.quit();
	}

}
