package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestngListener extends BaseTest implements ITestListener {
	ExtentReports extent= ExtentReport.ExtentReportInitiate();
	ExtentTest test; 
	ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
 	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testMethodName =result.getMethod().getMethodName();
		
		try {
			
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
         	System.out.println(driver);
			System.out.println("Method Name"+ testMethodName);
			extentTest.get().addScreenCaptureFromPath(captureScreenshot(driver,testMethodName), result.getMethod().getMethodName());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
        extent.flush();
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Skipped Test Case is: " + result.getName());

	}

}
