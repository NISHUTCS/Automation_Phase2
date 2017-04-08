package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class CommonFunction {
	public static String fileName=null;
	
	public String createDesiredXML(String xmlFile2Send,Reporting obj_testReport,String LID) throws IOException{
		FileInputStream fin = new FileInputStream(xmlFile2Send);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		copy(fin, bout);
		fin.close();
		byte[] b = bout.toByteArray();
		StringBuffer buf=new StringBuffer();
		String s=new String(b);
		//replacing a sample value in Request XML
		s=s.replaceAll("v_lid", LID);
		//s=s.replaceAll("v_externalInstallationID", externalInstallationID);
		return s;
	}
	public String builtColumbineXMLwithEncodedValue(String xmlFile2Send,Reporting obj_testReport,String encodedValue) throws IOException{
		FileInputStream fin = new FileInputStream(xmlFile2Send);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		copy(fin, bout);
		fin.close();
		byte[] b = bout.toByteArray();
		StringBuffer buf=new StringBuffer();
		String s=new String(b);
		//replacing a sample value in Request XML
		s=s.replaceAll("ReplaceWithEncodedMessage", encodedValue);
		return s;
	}

	public String createDesiredXML(String xmlFile2Send,String transactionId,String externalInstallationID) throws IOException{
		FileInputStream fin = new FileInputStream(xmlFile2Send);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		copy(fin, bout);
		fin.close();
		byte[] b = bout.toByteArray();
		StringBuffer buf=new StringBuffer();
		String s=new String(b);
		//replacing a sample value in Request XML
		s=s.replaceAll("v_transactionId", transactionId);
		s=s.replaceAll("v_externalInstallationID", externalInstallationID);
		return s;
	}

	// Function to send request
	public StringBuilder  sendSoapRequest(String SOAPUrl, String cisId,String xmlFile2Send,String responseFileName,Reporting obj_testReport,String s) throws Exception {
		//use this if you need proxy to connect
		System.setProperty("javax.net.ssl.keyStore", "D:\\SoapSample\\TDCAS-KARENTCS.p12");
		System.setProperty("javax.net.ssl.keyStorePassword", "CertTCS2014");
		System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("sltarray06", 80));
		// Create the connection with http
		URL url = new URL(SOAPUrl);
		URLConnection connection = url.openConnection(proxy);
		HttpURLConnection httpConn = (HttpURLConnection) connection;
		byte[] b=s.getBytes();
		//String rquestanchor="<a href='"+xmlFile2Send+"'>Request XML</a>";
		//obj_testReport.reportinfostep("Click to view Request xml : "+rquestanchor);

		// Set the appropriate HTTP parameters.
		httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
		httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		httpConn.setRequestProperty("SOAPAction", "");
		httpConn.setRequestMethod("POST");
		httpConn.setDoOutput(true);


		// send the XML that was read in to b.
		OutputStream out = httpConn.getOutputStream();
		out.write(b);
		out.close();

		// Read the response.
		httpConn.connect();
		if (httpConn.getResponseMessage().toString().equalsIgnoreCase("OK")){
			obj_testReport.reportpassstep("http connection status :"+ httpConn.getResponseMessage());
		}else{
			obj_testReport.reportfailedstep("http connection status :"+ httpConn.getResponseMessage(),"");
		}

		System.out.println("http connection status :"+ httpConn.getResponseMessage());
		InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
		BufferedReader in = new BufferedReader(isr);
		StringBuilder sb=new StringBuilder();

		for(String line=in.readLine();line!=null;line=in.readLine()){
			sb.append(line);
			//in.close();
		}
		//System.out.println("SB :"+sb);
		/*
		while ((inputLine = in.readLine()) != null){
		System.out.println(inputLine);
		//inputLine = in.readLine();
		//obj_testReport.reportinfostep(inputLine);
		System.out.println(inputLine);
		sb.append(inputLine);
		FileOutputStream fos=new FileOutputStream(responseFileName);
		copy(httpConn.getInputStream(),fos);
		in.close();

		}
		 */
		return sb;
	}
	
	// Function to send Rest request
		public StringBuilder  sendRestRequest(String SOAPUrl, String cisId,String xmlFile2Send,String responseFileName,Reporting obj_testReport,String s) throws Exception {
			//use this if you need proxy to connect
			System.setProperty("javax.net.ssl.keyStore", "D:\\SoapSample\\TDCAS-KARENTCS.p12");
			System.setProperty("javax.net.ssl.keyStorePassword", "CertTCS2014");
			System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("sltarray06", 80));
			// Create the connection with http
			URL url = new URL(SOAPUrl);
			URLConnection connection = url.openConnection(proxy);
			HttpURLConnection httpConn = (HttpURLConnection) connection;
			byte[] b=s.getBytes();
			//String rquestanchor="<a href='"+xmlFile2Send+"'>Request XML</a>";
			//obj_testReport.reportinfostep("Click to view Request xml : "+rquestanchor);

			// Set the appropriate HTTP parameters.
			httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
			httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
			httpConn.setRequestProperty("SOAPAction", "");
			httpConn.setRequestMethod("POST");
			httpConn.setDoOutput(true);


			// send the XML that was read in to b.
			OutputStream out = httpConn.getOutputStream();
			out.write(b);
			out.close();

			// Read the response.
			httpConn.connect();
			if (httpConn.getResponseMessage().toString().equalsIgnoreCase("OK")){
				obj_testReport.reportpassstep("http connection status :"+ httpConn.getResponseMessage());
			}else{
				obj_testReport.reportfailedstep("http connection status :"+ httpConn.getResponseMessage(),"");
			}

			System.out.println("http connection status :"+ httpConn.getResponseMessage());
			InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			StringBuilder sb=new StringBuilder();

			for(String line=in.readLine();line!=null;line=in.readLine()){
				sb.append(line);
				//in.close();
			}
			//System.out.println("SB :"+sb);
			/*
			while ((inputLine = in.readLine()) != null){
			System.out.println(inputLine);
			//inputLine = in.readLine();
			//obj_testReport.reportinfostep(inputLine);
			System.out.println(inputLine);
			sb.append(inputLine);
			FileOutputStream fos=new FileOutputStream(responseFileName);
			copy(httpConn.getInputStream(),fos);
			in.close();

			}
			 */
			return sb;
		}

	public static void copy(InputStream in, OutputStream out)
			throws IOException {

		synchronized (in) {
			synchronized (out) {
				byte[] buffer = new byte[256];
				while (true) {
					int bytesRead = in.read(buffer);
					if (bytesRead == -1)
						break;
					out.write(buffer, 0, bytesRead);
				}
			}
		}
	}

	public void ValidateXML(String xml,String tag,Reporting obj_testReport) throws AutomationException{
		//boolean result=false;

		System.out.println("xml"+xml + ":: Tag"+tag);
		if(xml.contains(tag)){
			//System.out.println("test status");
			obj_testReport.reportpassstep("Response XML contains "+tag);
		}else{
			//System.out.println("test status1");
			obj_testReport.reportfailedstep("Response XML doesnot contain required value "+tag, "");
		}
	}
	public void storeXML(String xmlpath,String xml,Reporting obj_testReport,String type) throws AutomationException, IOException{
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter out = null;
		System.out.println("path : "+xmlpath);
		fw = new FileWriter(xmlpath, false);
		bw = new BufferedWriter(fw);
		out = new PrintWriter(bw);
		out.print(xml);
		//System.out.println(xml);
		out.close();
		String rquestanchor="<a href='"+xmlpath+"'>"+type+" XML</a>";
		obj_testReport.reportinfostep("Click to view "+type+" xml : "+rquestanchor);
	}

	// **********************************************************************************/
	public static String GetcurrentTime()
	{
		return new SimpleDateFormat("dd-MM-yyyy HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
	}

	/* ********************************************************************************************
	Function Name : readExcel
	Write by : Prashant Kumar
	Creation date : 2nd Nov 2016
	Purpose : Read a data from excel
	Parameters : row and column
	Return Type : return desired value in String formate
	 ************************************************************************************************/
	/*public static String readExcel(int row, int column) throws IOException{
		String fileName = "TestData.xlsx";
		String sheetName = "Common";
		//String filePath = System.getProperty("user.dir");
		Path currentRelativePath = Paths.get("");
		String CurrentDirectory  = currentRelativePath.toAbsolutePath().toString();
		File file = new File(CurrentDirectory+"\\"+fileName);
		//Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		Workbook guru99Workbook = null;
		//Find the file extension by spliting file name in substring and getting only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		//Check condition if the file is xlsx file
		if(fileExtensionName.equals(".xlsx")){
			guru99Workbook = new XSSFWorkbook(inputStream);
		}
		else if(fileExtensionName.equals(".xls")){
			guru99Workbook = new HSSFWorkbook(inputStream);
		}
		org.apache.poi.ss.usermodel.Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);
		System.out.println(guru99Sheet.getRow(row).getCell(column).getStringCellValue());
		String value = guru99Sheet.getRow(row).getCell(column).getStringCellValue();
		return value;
	}
	 */

	/* *******************************************************************************
   Function Name : createScreenshotFolder
   Created By : Prashant Kumar
   Creation Date : 1st November 2016
   Purpose : Create a folder where we keep our test evidences
   Return Type : Screen shot folder path 
	 **********************************************************************************/
	public static void createScreenshotFolder(String TestcaseName){
		//Create object of date time in dd/MM/yy HH:mm:ss format 
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Calendar calobj = Calendar.getInstance();
		//Get current Time
		String date = df.format(calobj.getTime());
		//Remove space from date and time
		String date1 = date.substring(date.lastIndexOf(" ")+1);
		// Remove ":" and "_" from date and time and make a string
		String date2 = date1.replaceAll(":", "_");
		//Create folder path
		System.out.println("Creating Report folder : "+TestcaseName);
		new File(TestcaseName).mkdir();
		//return created folder path
		return ;
	}

	/* *******************************************************************************
	   Function Name : copyDirectory
	   Created By : Yuvraj P
	   Creation Date : 1st November 2016
	   Purpose : Copy directory to another directory
	   Parameter: source directory and target directory
	   Return Type : void
	 **********************************************************************************/
	private static void copyDirectory(File source, File target) throws IOException {
		if (!target.exists()) {
			target.mkdir();
		}
		for (String f : source.list()) {
			copy(new File(source, f), new File(target, f));
		}
	}
	/* *******************************************************************************
	   Function Name : copy
	   Created By : Yuvraj P
	   Creation Date : 1st November 2016
	   Purpose : Copy file of a directory to another directory
	   Parameter: source directory and target directory
	   Return Type : void
	 **********************************************************************************/
	public static void copy(File sourceLocation, File targetLocation) throws IOException {
		if (sourceLocation.isDirectory()) {
			copyDirectory(sourceLocation, targetLocation);
		}
		else {
			copyFile(sourceLocation, targetLocation);
		}
	}
	/* *******************************************************************************
	   Function Name : copyFile
	   Created By : Yuvraj P
	   Creation Date : 1st November 2016
	   Purpose : Copy files of a directory to another directory
	   Parameter: source directory and target directory
	   Return Type : void
	 **********************************************************************************/	
	private static void copyFile(File source, File target) throws IOException {        
		try 
		{
			InputStream in = new FileInputStream(source);
			OutputStream out = new FileOutputStream(target);
			byte[] buf = new byte[1024];
			int length;
			while ((length = in.read(buf)) > 0) {
				out.write(buf, 0, length);
			}
			in.close();
			out.close();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/* *******************************************************************************
	   Function Name : ClearDirectory
	   Created By : Yuvraj P
	   Creation Date : 1st November 2016
	   Purpose : Clear requested directory
	   Return Type : void
	 **********************************************************************************/	
	public static void ClearDirectory(File dir) {
		for (File file: dir.listFiles()) {
			file.delete();
			System.out.println("Deleting  : "+file);
		}
	}
	/* *******************************************************************************
	   Function Name : deleteDirectory
	   Created By : Yuvraj P
	   Creation Date : 1st November 2016
	   Purpose : Delete a particular directory
	   Return Type : true in case of pass and false in case f failure
	 **********************************************************************************/
	public static boolean deleteDirectory(File directory) {
		CommonFunction.waitforThreeSec();
		if(directory.exists()){
			File[] files = directory.listFiles();
			if(null!=files){
				try
				{
					for(int i=0; i<files.length; i++) {
						if(files[i].isDirectory()) {
							deleteDirectory(files[i]);
							System.out.println("Deleting  : "+ files[i]);
							files[i].delete();
						}
						else {
							System.out.println("Deleting  : "+files[i]);
							files[i].delete();
						}
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		else
		{
			System.out.println("invalid directory "+directory);
		}
		return(true);
	}


	/*
	 * Function to generate eight digits  random string
	 */
	public static String randomString(){
		String uuid = UUID.randomUUID().toString();
		//System.out.println("uuid = "+ uuid);
		uuid=uuid.substring(0,6);
		//System.out.println("uuid = "+ uuid);
		return "Auto"+uuid;
	}

	public static void waitforThreeSec(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void waitforSecs(int i){
		try {
			Thread.sleep(i*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static String getCurrentDate_DD_MM_YYYY(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = Calendar.getInstance();
		String currDate;
		c.get(Calendar.DATE);
		currDate = sdf.format(c.getTime()); 
		return currDate;
	}
	public static String getNextDate_DD_MM_YYYY(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = Calendar.getInstance();
		String nextdate;
		c.add(Calendar.DATE, 1);  // number of days to add
		nextdate = sdf.format(c.getTime());
		return nextdate;
	}
	public static String getCurrentDirectory(){
		Path currentRelativePath = Paths.get("");
		String CurrentDirectory = currentRelativePath.toAbsolutePath().toString();
		return CurrentDirectory;
	}

	public String remove_Header_Footer_CobiXML(String xmlFile2Send,Reporting obj_testReport){
		
		String[] items = xmlFile2Send.split("<return");
		xmlFile2Send=items[1];  
		String[] items1=xmlFile2Send.split("</return>");
		xmlFile2Send=items1[0];
		String[] items2=xmlFile2Send.split(">");
		
		System.out.println("Row string xml: "+items2[1]);
		return items2[1].replaceAll("&#13;", "\r\n");
	}

	
	/* *******************************************************************************
	   Function Name : getXMLtoSend
	   Created By : Nishant Kumar
	   Creation Date : 6th April 2017
	   Purpose : Delete a particular directory
	   Return Type : true in case of pass and false in case f failure
	 **********************************************************************************/
	public static File[] getXMLtoSend() throws FileNotFoundException{
		
		File[] fileList = ReadFolderFiles.readXml(CommonFunction.getCurrentDirectory()+"\\src\\iHTSOARequestXML\\");

		for(File file: fileList){
			System.out.println(file.getName());
			
		}
		return fileList;
	}

}


