package util;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Readtest {
	
	public static ExtentReports report;
	public static ExtentTest logger;
	
@Test
public static void starttest(){
	try {
		ReadInput.testList();
		testNGXmlgeneration.testNGcreation("");
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	/*public static void main(String[] args) throws IOException {

		//String testName = ReadInput.readExcel(1, 5);
		ReadInput.testList();
		
		testNGXmlgeneration.testNGcreation("");	
		
		//String reportPath=Common.getvalueRepository("reportPath");
		//report=new ExtentReports(reportPath,true);
	}*/
}