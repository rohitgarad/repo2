package Assert;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Practice {
	
		WebDriver driver;
		SoftAssert soft = new SoftAssert();
		
		@BeforeTest
		public void setup() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.w3schools.com/");
			
		}
		@Test(priority = 1)
		public void title () {
			String ExpectedTitle = "W3Schools Online Web Tutorials";
		    String ActualTitle = driver.getTitle();
		
			soft.assertEquals(ActualTitle, ExpectedTitle);   // hard assert  
		}
		
		@Test(priority = 2)
		public void logbtn() {
			
			WebElement logbtn = driver.findElement(By.id("w3loginbtn"));
			
			soft.assertTrue(logbtn.isDisplayed());
			logbtn.click();
			
		}
		
		@Test(priority = 3, dependsOnMethods ="logbtn" )
		public void EnterCred() throws InterruptedException {
			
			WebElement Email = driver.findElement(By.id("modalusername"));
			WebElement Pass = driver.findElement(By.id("current-password"));
			soft.assertTrue(Email.isDisplayed());
			soft.assertTrue(Pass.isDisplayed());
			Thread.sleep(4000);
				Email.sendKeys("rohitgarad07@gmail.com");
				Pass.sendKeys("Rohit@1628");
			
			
		}
		
		@Test(priority = 4)
		public void login() throws InterruptedException {
			Thread.sleep(4000);
			WebElement login = driver.findElement(By.xpath("//span[text()='Log in']"));
			soft.assertTrue(login.isDisplayed());
			login.click();
		}
		
		@Test(priority = 5)
		public void logout() throws InterruptedException {
			
			String Expected = "My learning | W3Schools";
		    String Actual = driver.getTitle();
		    
		    Assert.assertEquals(Actual, Expected);
		    
		    Thread.sleep(3000);
			WebElement logout = driver.findElement(By.xpath("//button[text()='Log out']"));
			soft.assertTrue(logout.isDisplayed());
			logout.click();
			soft.assertAll();
		}
		
		@AfterTest
		public void Tearup() throws InterruptedException {
			Thread.sleep(4000);
			driver.close();
			
		}

	}



