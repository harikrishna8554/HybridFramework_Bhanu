package com.grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Naveen_Grid {
	WebDriver driver;
	@Test
	@Parameters("myBrowser")
	public void testNaveen_Grid(String myBrowser) throws MalformedURLException
	{
		if(myBrowser.equals("chrome"))
		{
			
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WIN10);
		
		ChromeOptions options=new ChromeOptions();
		options.merge(cap);
		
		String url=" http://192.168.0.6:4444/wd/hub";
		driver=new RemoteWebDriver(new URL(url), options);
		}else if(myBrowser.equalsIgnoreCase("firefox"))
		{
			DesiredCapabilities cap= DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			
			cap.setPlatform(Platform.WIN10);
			
			
			String url=" http://192.168.0.6:4444/wd/hub";
			driver=new RemoteWebDriver(new URL(url), cap);
			
		}
		
		driver.get("http://www.freecrm.com");
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		
		driver.quit();
		
		
	}
}
