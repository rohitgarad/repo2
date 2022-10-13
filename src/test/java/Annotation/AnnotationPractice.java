package Annotation;

import org.testng.annotations.*;

public class AnnotationPractice {

	@BeforeSuite
	public void BeforeSuit() {
		System.out.println("Beforesuit");
	}
	
	@BeforeTest
	public void BeforeTest() {
		System.out.println("BeforeTest");
	}
	
	@BeforeClass
	public void BeforeClass() {
		System.out.println("BeforeClass");
	}
	
	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("BeforeMethod");
	}
	
	@AfterMethod
	public void AfterMethod() {
		System.out.println("AfterMethod");
	}
	
	@AfterClass
	public void AfterClass() {
		System.out.println("AfterClass");
	}
	
	@AfterTest
	public void AfterTest() {
		System.out.println("AfterTest");
	}
	
	@AfterSuite
	public void AfterSuit() {
		System.out.println("AfterSuit");
	}
	
}
