package datapro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class New {
	
	@Test(dataProvider = "DataPass")
	public void loginfunction(String user, String pass) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		
		username.sendKeys(user);
		password.sendKeys(pass);
		login.click();
		
	}
	
	@DataProvider(name="DataPass")
	public Object[][] value(){
		
		Object[][] data = new Object[3][2];
		data[0][0]="Admin";
		data[0][1]="admin123";
		data[1][0]="Admin";
		data[1][1]="admin1234";
		data[2][0]="Admin";
		data[2][1]="admin12345";
		
		return data;
		
		
	}

}
