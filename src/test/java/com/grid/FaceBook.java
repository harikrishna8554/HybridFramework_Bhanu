package com.grid;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.hybridFramework.testBase.BaseClass_grid;

public class FaceBook extends BaseClass_grid {

	@Test
	public void testFaceBook() throws InterruptedException {
		getDriver().get("https://www.facebook.com/");
		getDriver().manage().timeouts().implicitlyWait(160, TimeUnit.SECONDS);
		getDriver().findElement(By.id("email")).sendKeys("admin");
		getDriver().findElement(By.id("pass")).sendKeys("password");
	}

}
