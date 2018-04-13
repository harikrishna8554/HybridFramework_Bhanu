package com.hybridFramework.productBuy;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DriverCommand;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.HomePage;
import com.hybridFramework.PageObject.LoginPage;
import com.hybridFramework.PageObject.ProductCategoryPage;
import com.hybridFramework.PageObject.ShoppinCartSummaryPage;
import com.hybridFramework.helper.Javascript.JavaScriptHelper;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class PurchaseAProduct extends TestBase {
	private static final Logger logger=LoggerHelper.getLogger(PurchaseAProduct.class);
	private LoginPage login;
	private HomePage homePage;
	private ProductCategoryPage productPage;
	private ShoppinCartSummaryPage shoppingCart;
	private JavaScriptHelper js;
	@Test(groups="regression")
	public void testPurchaseAProduct() throws Exception
	{
		logger.info(PurchaseAProduct.class.getName()+": Test Started!");
		Config config=new Config(OR);
		driver.get(config.getWebsite());
		
		login=new LoginPage(driver);
		login.clickOnSignInLink();
		//Login
		login.loginToApplication(config.getUserName(),config.getPassword());
		
		//click on womens menu
		homePage=new HomePage(driver);
		productPage = homePage.clickOnMenu(homePage.womenMenu);
		//sort by filter
		productPage.selectSortByFilter("Price: Highest first");
		Thread.sleep(5000);

		productPage.selectItemAndAddToCart(1);
		productPage.clickOnContinueShopping();
		
		productPage.selectItemAndAddToCart(2);
		productPage.clickOnContinueShopping();
		
		productPage.selectItemAndAddToCart(3);
		productPage.clickOnProceedTocheckOut();
		shoppingCart=new ShoppinCartSummaryPage(driver);
		Thread.sleep(4000);
		js=new JavaScriptHelper(driver);
		js.scrollDownByPixel();
		shoppingCart.delectProductFromShoppingCart();
		if(shoppingCart.verifyEmptyShoppingCartMesssage())
		{
			logger.info("verifying deleted Shopping Cart Messsage..Sucessful");
			assertTrue(true, "verifying deleted Shopping Cart Messsage..Sucessful");
		}else
		{
			logger.info("verifying deleted Shopping Cart Messsage..Not Sucessful");
			assertTrue(false, "verifying deleted Shopping Cart Messsage..Not Sucessful");
		}
		logger.info(PurchaseAProduct.class.getName()+": Test Finished!");
		Thread.sleep(5000);
		driver.quit();
		
		
	}

}
