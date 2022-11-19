package Google;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewOperation {
	
    @Test
	public void selenium() throws InterruptedException {
 
    	WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
    	
    	driver.navigate().to("https://www.google.com/");
		driver.manage().window().maximize();
		
		WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
		search.sendKeys("selenium");
		
		List<WebElement> sugg = driver.findElements(By.xpath("//li[@role='presentation']"));
		
	//	System.out.println(sugg);
		
		for (WebElement item : sugg) {
			
			System.out.println(item.getText());
			
		}
		
		Thread.sleep(5000);
		
//		WebElement NewEle = driver.findElement(By.xpath("(//div[@class='wM6W7d'])[4]"));
//		
//		NewEle.click();
		
		
	   for (WebElement item : sugg) {
	  if(item.getText().equals("selenium webdriver")) {
	   		item.click();
	  		break;
	  	}
	 	Thread.sleep(10000);
	 	
//	 	driver.close();
	
		
		}
    
    }
}




