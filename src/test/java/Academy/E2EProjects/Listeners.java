package Academy.E2EProjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import resources.BaseClass;
import resources.ExtentReporterNG;

public class Listeners extends BaseClass implements ITestListener
{

	ExtentTest test;	
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> tl=new ThreadLocal<ExtentTest>();           
	public void onTestStart(ITestResult result)
	
	{
	 test=extent.createTest(result.getMethod().getMethodName());
	tl.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		tl.get().log(Status.PASS, "Test  iS Passsed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	tl.get().fail(result.getThrowable());
	WebDriver driver =null;
	String testMethodName =result.getMethod().getMethodName();
	
	try {
		driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch(Exception e)
	{
		
	}
	try {
	tl.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
		
		
		

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		extent.flush();
		
	}
	
	

}
