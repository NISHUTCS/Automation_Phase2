package util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class testNGXmlgeneration {


	//This function is to auto create an testng.xml file which will be created every time when the script will run
	public static void testNGcreation(String testname) throws IOException{


		String Testfile=CommonFunction.getCurrentDirectory()+"\\testng.xml";
		try {
			File file = new File(Testfile);
			if (file.exists()) {
				System.out.println("testng file exists");
				file.delete();
			} else {
				System.out.println("No other testng file exists");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		File FC = new File(Testfile);//Created object of java File class.
		FC.createNewFile();
		FileWriter fr=new FileWriter(Testfile);
		BufferedWriter br=new BufferedWriter(fr);

		br.write("<?xml version='1.0' encoding='UTF-8'?>");
		br.newLine();
		br.write("<suite name='RegressionSuite'>");
		//br.write("<test name='Test'>");
		br.newLine();
		//br.newLine();
		Iterator itr=ReadInput.al.iterator();
		//traversing elements of ArrayList object 
		int counter = 1;
		while(itr.hasNext()){ 

			AddTest st=(AddTest)itr.next();
			String testName = st.testName;
			String LID=st.LID;
			//String externalInstallationID=st.externalInstallationID;					
			
			br.write("<test name='"+testName+"'>");
			br.newLine();
			br.write("<parameter name='LID' value='"+LID+"' />");
			br.newLine();
			/*br.write("<parameter name='externalInstallationID' value='"+externalInstallationID+"' />");
			br.newLine();*/
			br.write("<classes>");
			br.newLine();
			br.write("<class name='testCases.TestCases'>");
			br.newLine();
			br.write("<methods>");
			br.newLine();
			br.write("<include name='"+testName+"' />");
			br.newLine();
			br.write("</methods>");
			br.newLine();
			br.write("</class>");
			br.newLine();
			br.write("</classes>");
			br.newLine();
			br.write("</test>");	
			br.newLine();
			counter=counter+1;
		}
		
		br.write("</suite>");
		br.close();
	}
}
