package util;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterSuite;

public class TestBase {
	
	
	public static String folderPath;
	public  String testName="";
	public static String CurrentDirectory = "";
	public static String SuiteName = "";
	static int passCount =0;
	 static int failCount =0;
	 static int Totaltest =0;
	public static String pureSuiteName = "";
	public static String ReportPath = "";
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  
  }
	@BeforeTest
	public void beforeTest(final ITestContext testContext) {
		testName=testContext.getName();
	}
  
  @AfterMethod
  public void afterMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS)
			passCount++;
		else if(result.getStatus()==ITestResult.FAILURE)
			failCount++;
  }

  @BeforeSuite
	public void BeforeSuite(ITestContext ctx) {
		
		CurrentDirectory =CommonFunction.getCurrentDirectory();
		PropertiesFileUtil.loadPropertiesFile();
		String timeStamp = new SimpleDateFormat("dd-MMM-yyyy'T'HH-mm-ss").format(new Timestamp(System.currentTimeMillis()));
		SuiteName=PropertiesFileUtil.ReadPropValue("Environmnet")+"_"+ctx.getCurrentXmlTest().getSuite().getName()+"_"+timeStamp;
		pureSuiteName=ctx.getCurrentXmlTest().getSuite().getName();
		System.out.println(SuiteName);
		ReportPath=CurrentDirectory+"\\Report\\Latest_Report\\"+SuiteName;
		File src=new File(CurrentDirectory+"\\Report\\Latest_Report");
		File trg=new File(CurrentDirectory+"\\Report\\Report_History");
		//CommonFunction.copy(src, trg);
		//CommonFunction.ClearDirectory();
		src=null;
		trg=null;
		src=new File(CurrentDirectory+"\\Report\\Latest_Report");
		CommonFunction.deleteDirectory(src);
		src=null;
		//QCConnect.SetQchelper();
		 //DBUtility dbObj=new DBUtility();
			//dbObj.getDbConnection();
			//dbObj.GentNextSequenceNumber();
			//dbObj.closeDbConnection();
		CommonFunction.createScreenshotFolder(ReportPath+"\\Screenshot");
		Reporting.extent = new ExtentReports(ReportPath+"\\"+"Report_"+ctx.getCurrentXmlTest().getSuite().getName()+".html", true);
		System.out.println(ReportPath+"\\"+"Report_"+ctx.getCurrentXmlTest().getSuite().getName()+".html");
	}

  @AfterSuite
  public void afterSuite() {
	  Reporting.reportflush();
	  Totaltest=passCount+failCount;
		/*String envmsg="\n\n\n Environment Details:\n\n SiteCore :"+PropertiesFileUtil.ReadPropValue("SiteCore")+"\n BusinessCore :"+PropertiesFileUtil.ReadPropValue("Environmnet")+"\n Browsers :"+PropertiesFileUtil.ReadPropValue("Browsers")+"\n ScheduledBy :"+PropertiesFileUtil.ReadPropValue("ScheduledBy");
		String reportmsg="\n\n\n Report Details:\n\n Report URL :"+"ftp://10.73.61.39/"+"\n Report Folder :"+SuiteName;
		String mailSummary="\n\n========================\nSummary :\n\n Test Suite Name  :"+pureSuiteName+"\n Total Tests :"+Totaltest+"\n Tests Passed :"+passCount+"\n Tests Failed :"+failCount+envmsg+reportmsg+"\n========================\n";
		*/String newlineSpace="<tr><td style='line-height:15px;'>&nbsp;</td></tr>";
		//String summarymailMsg="<th>Summary :</th><tr><td>Test Suite Name:</td><td>"+pureSuiteName+"</td></tr><tr><td>Total Tests: </td><td>"+Totaltest+"</td></tr><tr><td>Tests Passed: </td><td>"+passCount+"</td></tr><tr><td>Tests Failed: </td><td>"+failCount+"</td></tr>";
		//String envmailMsg="<th>Environment Details:</th><tr><td>SiteCore: </td><td>"+PropertiesFileUtil.ReadPropValue("SiteCore")+"</td></tr><tr><td> BusinessCore: </td><td>"+PropertiesFileUtil.ReadPropValue("Environmnet")+"</td></tr><tr><td>Browsers: </td><td>"+PropertiesFileUtil.ReadPropValue("Browsers")+"</td></tr><tr><td>ScheduledBy: </td><td>"+PropertiesFileUtil.ReadPropValue("ScheduledBy")+"</td></tr>";
		//String reportmailMsg="<th>Report Details:</th><tr><td>Report URL: </td><td><a href='http://w7d12337/Se/start.html'><b>http://w7d12337/Se/start.html</b></a></td></tr><tr><td> Report Folder:</td><td style='color:blue;'><b>"+SuiteName+"</b></td></tr>";
		//String Mailsummary=summarymailMsg+newlineSpace+envmailMsg+newlineSpace+reportmailMsg+newlineSpace;
		PropertiesFileUtil.closePropertiesFile();
		//System.out.println(Mailsummary);
		//if(PropertiesFileUtil.ReadPropValue("MailSwitch").equalsIgnoreCase("on"))
		//MailUtility.ZipAndMailReport(Mailsummary);	
		QCConnect.CloseQchelper();
	/*	
		DBUtility dbObj=new DBUtility();
		dbObj.getDbConnection();
		dbObj.WriteSequenceNumber();
		dbObj.closeDbConnection();
	*/	
		//File src=new File(CurrentDirectory+"\\test.log");
		File trg=new File(ReportPath+"\\"+SuiteName+".txt");
		//CommonFunction.copy(src, trg);
		ZipFolder.zipFolder_function();
		//src=new File(ZipFolder.OUTPUT_ZIP_FILE);
		trg=new File(ReportPath+"\\"+SuiteName+".Zip");
		//CommonFunction.copy(src, trg);
		// src=new File(CurrentDirectory+"\\Report\\Latest_Report");
		 trg=new File(CurrentDirectory+"\\Report\\Report_History");
		//CommonFunction.copy(src, trg);
		trg=null;
		trg=new File("C:\\inetpub\\wwwroot\\sereport");
		
		//CommonFunction.createScreenshotFolder("C:\\inetpub\\wwwroot\\ReportPage\\"+SuiteName);
		//CommonFunction.copy(src, trg);
		//src=null;
		trg=null;
  }

}
