package Annotation;

import org.testng.annotations.Test;

public class Demo1 extends AnnotationPractice{

	@Test
	public void myTestMethod1() {
		System.out.println("myTestMethod1");
	}
	
	@Test
	public void myTestMethod2() {
		System.out.println("myTestMethod2");
	}
}
