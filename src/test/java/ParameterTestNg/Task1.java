package ParameterTestNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Task1 {
	

    @Parameters({"browser","user","pass"})
	@Test
	public void ornghrm(String browser, String user, String pass) throws InterruptedException {
		
    	WebDriver driver = null;
    	if (browser.equalsIgnoreCase("chrome")) {
    		WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver();
    		
    	}else if (browser.equalsIgnoreCase("edge")) {
    		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
    	
        }else if (browser.equalsIgnoreCase("firefox")) {
    	WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
       }else {
    	   System.out.println("wrong input");
       }
    	SoftAssert soft = new SoftAssert();
    	
    	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    	
    	String expectedTitle = "OrangeHRM";
    	String ActualTitle = driver.getTitle();
    	System.out.println(ActualTitle );
    	
    	soft.assertNotEquals(ActualTitle, expectedTitle);
    	Thread.sleep(3000);
    	
    	WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
    	WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
    	
    	soft.assertTrue(username.isDisplayed());
    	username.sendKeys(user);
    	
      	soft.assertTrue(password.isDisplayed());
    	password.sendKeys(pass);
	
    	Thread.sleep(3000);
    	
    	WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
    	login.click();
    	
    	
    	WebElement Myinfo = driver.findElement(By.xpath("//span[text()='My Info']"));
         soft.assertTrue(Myinfo.isDisplayed());
         Myinfo.click();
         
         Thread.sleep(3000);
         WebElement name = driver.findElement(By.xpath("//h6[text()='Paul Collings']"));
         soft.assertTrue(name.isDisplayed());
         System.out.println(name.getText());
         
         WebElement list = driver.findElement(By.xpath("//p[text()='Paul Collings']"));
         list.click();
         
         WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
         logout.click();
         
         soft.assertAll();
         
         Thread.sleep(4000);
         driver.close();
}
}
