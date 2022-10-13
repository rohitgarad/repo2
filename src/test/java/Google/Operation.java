package Google;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Operation {
	
	
	@Test
	public void selenium() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://www.google.com/");
		driver.manage().window().maximize();
		
		WebElement search = driver.findElement(By.xpath("//input[@type='text']"));
		search.sendKeys("selenium");
		
	List<WebElement> suggestion = driver.findElements(By.xpath("//li[@role]"));
	
	System.err.println(suggestion);
	
	for (WebElement i : suggestion) {
		
		System.out.println(i.getText());
		
	}
	
	Thread.sleep(5000);
//	
//    for (WebElement multiple : suggestion) {
//    	if(multiple.getText().equals("selenium webdriver")) {
//    		multiple.click();
//    		break;
//    	}
//    	Thread.sleep(5000);
    
	
	
	driver.close();
		
		
	}
}


