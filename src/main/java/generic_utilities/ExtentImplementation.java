package generic_utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentImplementation implements ITestListener{
	public ExtentSparkReporter sparkreporter; //used to set the UI and name of the report
	public ExtentReports extent; //populate common information on the report
	public ExtentTest test; //creating test entries in the report and update status of the test methods
	
	
	
	 public void onStart(ITestContext context) {
		 
			
			String date = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
			sparkreporter=new ExtentSparkReporter("ExtentReports/Reports"+date+".html");
			
			sparkreporter.config().setDocumentTitle("Automation Report");
			sparkreporter.config().setReportName("Functional Testing");
			sparkreporter.config().setTheme(Theme.DARK);
			
			extent=new ExtentReports();
			extent.attachReporter(sparkreporter);
			
			extent.setSystemInfo("ComputerName","Localhost");
			extent.setSystemInfo("Environment","QA");
			extent.setSystemInfo("Tester name","Som");
			extent.setSystemInfo("OS","Windows 11");
			extent.setSystemInfo("Browser","Chrome");
         
	 }
	
	 public void onTestStart(ITestResult result) {
		 test=extent.createTest(result.getName());
		 
	 }

		 
	 public void onTestSuccess(ITestResult result) {
		 test.log(Status.PASS,result.getTestClass().getName());
		 test.log(Status.PASS,result.getMethod().getMethodName());
		 test.log(Status.PASS, result.getThrowable());
		 
	 }
      public void onTestFailure(ITestResult result) {
    	  test.log(Status.FAIL,result.getTestClass().getName());
    	  test.log(Status.FAIL,result.getMethod().getMethodName());
    	  test.log(Status.FAIL,result.getThrowable());
    	  
    	  String screenShot=null;
    		  
    		  try {
				screenShot=WebDriver_Utilities.takesScreenShot(BaseClass_Ecommerce.sdriver,result.getMethod().getMethodName());
			} catch (Throwable e) {
				e.printStackTrace();
			}
    	  
    	   test.addScreenCaptureFromPath(screenShot);
    	  
      }

		
	  public void onTestSkipped(ITestResult result) {		
		  test.log(Status.SKIP, result.getTestClass().getName());
		  test.log(Status.SKIP,result.getMethod().getMethodName());
		  test.log(Status.SKIP, result.getThrowable());
	  }


		  
	 public void onFinish(ITestContext context) {
		 extent.flush();
		    
		  }
	
}
