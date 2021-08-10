package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport extends BaseTest {
	public static ExtentReports extent; // ExtentReports responsible to drive all the reporting execution
	public static ExtentTest test; // ExtentTest captures the test result what is happening in execution
	//ITestResult result;

	// Extent Report Part
	public static ExtentReports ExtentReportInitiate() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");// ExtentSparkReporter is responsible
																					// to create on html file and do
																					// some configuration
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("TestApp Report");
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Apoorv Rastogi");
		return extent;
	}

	}
