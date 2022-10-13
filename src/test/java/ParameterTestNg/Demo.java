package ParameterTestNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	@Parameters({"browser", "user", "pass"})
	@Test
	public void paremtr(String browser, String user, String pass) {
		
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else {
			System.out.println("input is wrong");
		}
	   	driver.get("https://www.w3schools.com/");
	   
	   	SoftAssert soft = new SoftAssert();
	   	
	    WebElement logbtn = driver.findElement(By.id("w3loginbtn"));
          soft.assertTrue(logbtn.isDisplayed());
		logbtn.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement Email = driver.findElement(By.id("modalusername"));
		WebElement PassWord = driver.findElement(By.id("current-password"));
		 soft.assertTrue(Email.isDisplayed());
		 soft.assertTrue(PassWord.isDisplayed());
		Email.sendKeys(user);
		PassWord.sendKeys(pass);
		
		WebElement login = driver.findElement(By.xpath("//span[text()='Log in']"));
		 soft.assertTrue(login.isDisplayed());
		login.click();
		
		soft.assertAll();
		
	//	driver.close();
		
	
	}
}


