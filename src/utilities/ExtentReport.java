package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport extends BaseTest {
	public static ExtentReports extent;
    public static ExtentTest test;
    ITestResult result;
    //Extent Report Part
	public static void ExtentReportInitiate()
	{
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("TestApp Report");
		extent.attachReporter(spark);
	}
	
	 
	public ExtentReport(ITestResult result, WebDriver driver) {
		super();
		this.result = result;
		this.driver=driver;
	}


	public static ExtentTest createTest(String testName) 
	{
		test= extent.createTest(testName);
		return test;
	}
	
	public void teardown(ITestResult result, WebDriver driver) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
		try {
			BaseTest.captureScreenshot(driver, result.getName());
			test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(result.getName()+".png").build());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}

}
