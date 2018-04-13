package com.hybridFramework.testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class TestBase_Parallel {
	public WebDriver driver;

	@BeforeTest
	@Parameters("myBrowser")
	public void getBrowser(String myBrowser) {
		if (System.getProperty("os.name").contains("Windows 10"))
		{
			if (myBrowser.equalsIgnoreCase("firefox")) 
			{
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (myBrowser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			}else if (myBrowser.equalsIgnoreCase("ie"))
			{
				System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
				driver =new InternetExplorerDriver();
			}
		} else if (System.getProperty("os.name").contains("Mac"))
		{
			System.out.println(System.getProperty("os.name"));
			if (myBrowser.equalsIgnoreCase("firefox"))
			{
				System.out.println(System.getProperty("user.dir"));
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
				driver = new FirefoxDriver();

			} else if (myBrowser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
				driver = new ChromeDriver();

			}
		}
	}
	
	@AfterClass
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}

}
