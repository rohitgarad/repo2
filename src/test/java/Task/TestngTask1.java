package Task;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngTask1 {

	WebDriver driver;                         // as a instant variable 
	
	@BeforeTest
	public void BrowserSet() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.navigate().refresh();	
	}
	
	@Test (priority = 1)
	public void Title() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	
	@Test (priority = 2)
	public void logbtn() {
		WebElement logbtn = driver.findElement(By.id("w3loginbtn"));
		logbtn.click();	
	}
	
	@Test (priority = 3,dependsOnMethods = "logbtn")
	public void EnterCred() {
	WebElement Email = driver.findElement(By.id("modalusername"));
	WebElement Pass = driver.findElement(By.id("current-password"));
		Email.sendKeys("rohitgarad07@gmail.com");
		Pass.sendKeys("Rohit@1628");
	}
	
	@Test (priority = 4)
	public void login() {
		WebElement login = driver.findElement(By.xpath("//span[text()='Log in']"));
		login.click();
	}
	
	@Test (priority = 5,enabled = false)
	public void logout () {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement logout = driver.findElement(By.xpath("//button[text()='Log out']"));
		
		logout.click();
	}
	
	@AfterTest
	public void Tearup() {
		driver.close();
	}
}
