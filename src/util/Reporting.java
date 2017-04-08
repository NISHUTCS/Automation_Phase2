package util;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/* *******************************************************************************
Class Name : Reporting
Created By : Prashant Kumar
Purpose : Class contatins helper methods for the extend report and test case wise logs.
Creation Date : 30th November 2016
**********************************************************************************/

public class Reporting {
	public  ExtentTest test;
	 public  String testName="";
	public static ExtentReports extent;
	public static String CodeVersion="0.1";//PropertiesFileUtil.ReadPropValue("CodeVersion");
	public boolean failFlag=false;
	
	// Constructor to initiate the extend report testcase and log object
	public Reporting(String TestcaseName) 
	{
		  test=Reporting.extent.startTest(TestcaseName);
		  testName=TestcaseName;
		  failFlag=false;
		  this.reportinfostep("Executing the test in Automation Code Version : "+CodeVersion);
		 
	}
	// method to handle the Test pass event for extent reports
	public  void reportpassstep(String message) throws AutomationException 
	{
		test.log(LogStatus.PASS, message );
	}
	// method to handle the Test pass with screenshot  for extent reports
	public  void reportpassstepWithScreenshot(String message,String screenShotPath) throws AutomationException 
	{
		System.out.println(screenShotPath);	
		test.log(LogStatus.PASS, message+test.addScreenCapture(screenShotPath) );
	}
	
	// method to handle the Test fail event for extent reports
	public  void reportfailedstep(String message, String screenShotPath) throws AutomationException
	{
		System.out.println(screenShotPath);
		screenShotPath=screenShotPath.replace(TestBase.ReportPath, ".");
		//screenShotPath=screenShotPath.replace(ScaleTestCases.ReportPath, ".");
		System.out.println(screenShotPath);
		String image= test.addScreenCapture(screenShotPath);
		System.out.println(image);
		test.log(LogStatus.FAIL,message,message);
		this.failFlag=true;
		throw new AutomationException();
	}
	// method to handle the info event for extent reports
	public void reportinfostep(String message) 
	{
		test.log(LogStatus.INFO, message);
	}
	// method to close the testcase writing in extentend report
	public  void reportendtest()
	{
		 extent.endTest(test);
	}
	// method to publish the complete test suite report
	public static void reportflush()
	{
        // calling flush writes everything to the log file
        extent.flush();
	}
}
