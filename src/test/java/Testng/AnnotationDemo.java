package Testng;

import org.testng.annotations.Test;

public class AnnotationDemo {

	@Test
	public void homepage() {
		System.out.println("home page");
	}
	
	@Test
	public void profile() {
		System.out.println("view profile");
	}
}
