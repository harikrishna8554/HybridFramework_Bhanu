package com.hybridFramework.examples;

import static org.testng.Assert.assertTrue;

import java.util.List;

import javax.swing.LookAndFeel;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.HomePage;
import com.hybridFramework.PageObject.ProductCategoryPage;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class VerifyProductsCount extends TestBase{
	private static final Logger logger=LoggerHelper.getLogger(VerifyProductsCount.class);
	
	private HomePage homePage;
	private ProductCategoryPage productsPage;
	@Test(groups="regression")
	public void testVerifyProductsCount() throws Exception
	{
		logger.info(VerifyProductsCount.class.getName()+":  Test Started!");
		Config config=new Config(OR);
		driver.get(config.getWebsite());
		
		homePage=new HomePage(driver);
		productsPage = homePage.clickOnMenu(homePage.womenMenu);
		
		productsPage.selectColor(productsPage.Orange);
		Thread.sleep(7000);
		
		int totalProducts = productsPage.getTotalProducts();
		System.out.println("totalProducts: "+totalProducts);
		
		if(totalProducts==3)
		{
			assertTrue(true, "Products Count Matched!");
			logger.info("Products Count Matched!");
		}else
		{
			logger.info("Products Count NOT Matched!");
			assertTrue(false, "Products Count NOT   Matched!");
		}
		logger.info(VerifyProductsCount.class.getName()+":  Test Finished!");
		Thread.sleep(5000);
		driver.quit();
		
	}

}
