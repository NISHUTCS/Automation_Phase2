package util;

import java.io.IOException;
import java.util.Date;
import testCases.TestCases;


public class QCConnect {

private static Log_Generator QcLog=new Log_Generator();
	public static void SetQchelper()
	{
		
		QcLog.CreateLogfile(CommonFunction.getCurrentDirectory()+"\\Report\\Log\\QcStatus.log");
		QcLog.WriteLogfile("Suite_Name :"+TestCases.pureSuiteName);
	}
	public static void WriteQchelper(String TestcaseName,String TestRunName,Boolean testres)
	{
		String teststatus="";
		if(testres)
			teststatus="Pass";		
			else
				teststatus="Fail";
		//QcLog.WriteLogfile("Test Name :"+TestcaseName+" RunName :"+TestRunName+" Status :"+teststatus+" LogFileLocation :"+ScaleTestCases.CurrentDirectory+"\\Report\\Log\\"+TestcaseName+"_"+TestRunName+".log");
	}
	
	public static void CloseQchelper()
	{
		QcLog.CloseLogfile();
	}
	
	public static void UpdateQC()
			 {
								
				try {
					Process  process = Runtime.getRuntime().exec("cmd /c start "+CommonFunction.getCurrentDirectory()+"\\QcUpdater\\QcUtil.bat" );
					process.waitFor();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	}
	
	
	public static void main(String[] args) {
		UpdateQC();
	}
		
	
}
