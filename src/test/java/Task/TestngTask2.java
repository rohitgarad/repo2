package Task;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngTask2 {
	
	WebDriver driver;
	
	@BeforeTest
	public void BrowserSet() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@Test(priority = 1)
	public void EnterCred() {
		WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
		WebElement Password = driver.findElement(By.xpath("//input[@name='password']"));
		username.sendKeys("Admin");
		Password.sendKeys("admin123");
	}
	
	@Test(priority = 2)
	public void logbtn() {
		WebElement button = driver.findElement(By.xpath("//button[text()=' Login ']"));
		button.click();
	}
	
	@Test(priority = 3)
	public void MyInfo() {
		WebElement Info = driver.findElement(By.xpath("//span[text()='My Info']"));
		Info.click();
	}
	
	@Test(priority = 4)
	public void profile() {
		WebElement Name = driver.findElement(By.xpath("//h6[text()='Paul Collings']"));
		System.out.println(Name.getText());
		
	}
	
	@Test(priority = 5)
	public void logout() throws InterruptedException {
		WebElement option = driver.findElement(By.xpath("//p[text()='Paul Collings']"));
		option.click();
		Thread.sleep(3000);
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
		logout.click();
			
	}
	
	@AfterTest
	public void Tearup() {
		driver.close();
	}
	
	

}
