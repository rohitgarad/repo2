package ListnerTestNg;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerTask implements ITestListener{

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("****Test Case is success****");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("****Test Case is Failed****");
		
		TakesScreenshot ts = (TakesScreenshot)Task1.driver;
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualdate = format.format(date);
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\rohit\\eclipse-workspace\\ProjectTestNg\\target\\"+actualdate+".png");
		
		try {
			FileUtils.copyFile(source, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("****Test Case is Started****");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("****Test Case is Finished****");
		
	}

	
	
}
