package com.hybridFramework.examples;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.HomePage;
import com.hybridFramework.PageObject.ProductCategoryPage;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class VerifyLowestFirstPriceFilter extends TestBase{
	private static final Logger logger=LoggerHelper.getLogger(VerifyLowestFirstPriceFilter.class);
	private HomePage homepage;
	private ProductCategoryPage productsPage;
	@Test(groups="sanity")
	public void testVerifyLowestFirstPriceFilter() throws Exception
	{
		Config config=new Config(OR);
		driver.get(config.getWebsite());
		
		homepage=new HomePage(driver);
		productsPage = homepage.clickOnMenu(homepage.womenMenu);
		productsPage.selectSortByFilter("Price: Lowest first");
		Thread.sleep(8000);
		List<WebElement> prices = productsPage.getAllProductsPrice();
		
		ArrayList<Integer> al=new ArrayList<Integer>();
		Iterator<WebElement> itr = prices.iterator();
		while(itr.hasNext())
		{
			String text = itr.next().getText();
			String text1 = text.trim();
			if(text1.contains("$"))
			{
				String price = text1.substring(1);
				double duble = Double.parseDouble(price);
				int price1=(int)(duble);
				al.add(price1);
			}	
		}
		System.out.println(al);
		
		//Price verification in ascending Order
		for(int i=0;i<al.size()-1;i++)
		{
			if(al.get(i)<=al.get(i+1))
			{
				System.out.println("al.get(i)"+al.get(i));
				System.out.println("al.get(i+1)"+al.get(i+1));
				
			}
			else
			{
				assertTrue(false, "Price Filter is not working!");
			}
			
		}
		driver.quit();
	}

}
