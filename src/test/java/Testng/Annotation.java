package Testng;

import org.testng.annotations.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotation {
	
	@BeforeTest
	public void setup() {
		
		System.out.println("browser open");
	}
	
	@Test (priority = 1, description = "this is test script")
	public void login () {
		System.out.println("login");
	}
	
	@Test(priority = 2)
	public void logout() {
		System.out.println("logout");
	}

	@AfterTest
	public void tearup() {
		
		System.out.println("browser close");
	}
}
