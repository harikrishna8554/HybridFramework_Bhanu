package parallelTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.hybridFramework.testBase.TestBase_Parallel;

public class ParallelTest extends TestBase_Parallel{
	
	@Test
	public void loginTest()
	{
		//url
		driver.get("http://localhost:8888/index.php?");
		driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.MINUTES);
		//login
		driver.findElement(By.xpath(".//*[@id='form']/div/div[2]/input")).sendKeys("admin");
		driver.findElement(By.xpath(".//*[@id='form']/div/div[4]/input")).sendKeys("manager");
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
	}

}
