package ListnerTestNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Assert.Assertion;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(ListnerTestNg.ListnerTask.class)
public class Task1 {
	
	static WebDriver driver;
	
	@Test
	public void practice () throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://online.actitime.com/bytesquare/login.do");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.name("pwd"));
		WebElement login = driver.findElement(By.id("loginButton"));
		
		username.sendKeys("trainee");
		password.sendKeys("trainee");
		login.click();
		
		Thread.sleep(3000);
		
		WebElement HomeText = driver.findElement(By.xpath("//h3[text()='Enter Time-Track']"));
		
		String Expected = "Enter Time";
		String Actual = HomeText.getText();
		
		Assert.assertEquals(Expected,Actual);
		
		driver.close();
	}

}
