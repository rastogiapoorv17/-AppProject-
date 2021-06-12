package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestngListener implements ITestListener {
	@Override		
    public void onFinish(ITestContext arg0) {					
        // TODO Auto-generated method stub				
        		
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
    public void onTestFailure(ITestResult result) {					
        // TODO Auto-generated method stub				
        System.out.println("Failed Test Case is: " + result.getName());	
     
    }

    @Override		
    public void onTestSkipped(ITestResult result) {					
        // TODO Auto-generated method stub				
    	 System.out.println("Skipped Test Case is: " + result.getName());
    	 
    }		

    @Override		
    public void onTestStart(ITestResult result) {					
        // TODO Auto-generated method stub				
    	System.out.println("Started Test Case is: " + result.getName());	
    }		

    @Override		
    public void onTestSuccess(ITestResult result) {					
        // TODO Auto-generated method stub				
    	System.out.println("Passed Test Case is: " + result.getName());
    }		
}
