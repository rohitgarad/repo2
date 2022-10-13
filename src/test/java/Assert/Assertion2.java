package Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertion2 {
	
	@Test
	public void demo () throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/");
		
		SoftAssert soft = new SoftAssert();
		
		String ExpectedTitle = "W3Schools Online Web Tutorials";
	    String ActualTitle = driver.getTitle();
	    
	    soft. assertEquals(ActualTitle, ExpectedTitle) ;
	    
        WebElement logbtn = driver.findElement(By.id("w3loginbtn"));
		
		soft.assertTrue(logbtn.isDisplayed());
		logbtn.click();
		
		Thread.sleep(4000);
		
		driver.close();
		soft.assertAll();
	}

}
