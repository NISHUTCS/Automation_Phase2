package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadInput {
	public static String fileName=null;
	public static String cellValue = null;
	public static ArrayList<AddTest> al=new ArrayList<AddTest>();

	public static String readExcel(int row, int column) throws IOException{
		
		Sheet sheet;
		fileName = ReadFolderFiles.readFolderFiles(CommonFunction.getCurrentDirectory()+"\\src\\TestData\\");
		//String fileName="YouseeInput.xlsx";
		String filePath = System.getProperty("user.dir");
		String sheetName="input";
		File file = new File(CommonFunction.getCurrentDirectory()+"\\src\\TestData\\"+fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook sysnServiceWorkbook = null;
		//Find the file extension by spliting file name in substring and getting only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		//Check condition if the file is xlsx file
		if(fileExtensionName.equals(".xlsx")){

			sysnServiceWorkbook = new XSSFWorkbook(inputStream);
			org.apache.poi.ss.usermodel.Sheet syncServiceSheet = sysnServiceWorkbook.getSheet(sheetName);	

			System.out.println(syncServiceSheet.getRow(row).getCell(column).getStringCellValue());
			cellValue = syncServiceSheet.getRow(row).getCell(column).getStringCellValue();


		}

		else if(fileExtensionName.equals(".xls")){

			sysnServiceWorkbook = new HSSFWorkbook(inputStream);
			org.apache.poi.ss.usermodel.Sheet syncServiceSheet = sysnServiceWorkbook.getSheet(sheetName);	

			System.out.println(syncServiceSheet.getRow(row).getCell(column).getStringCellValue());
			cellValue = syncServiceSheet.getRow(row).getCell(column).getStringCellValue();


		}
		/*
		else if(fileExtensionName.equals(".ods")){


			sheet = SpreadSheet.createFromFile(file).getSheet(sheetName);
			cellValue = (String) sheet.getValueAt(column, row);


		}
		 */
		return cellValue;

	}

	public static void testList() throws IOException{

		Sheet sheet;
		fileName = ReadFolderFiles.readFolderFiles(CommonFunction.getCurrentDirectory()+"\\src\\TestData\\");
		//String fileName="YouseeInput.xlsx";
		String filePath = System.getProperty("user.dir");
		String sheetName="input";
		File file = new File(CommonFunction.getCurrentDirectory()+"\\src\\TestData\\"+fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook syncServiceWorkbook = null;
		//Find the file extension by spliting file name in substring and getting only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		//Check condition if the file is xlsx file
		File[] xmlfileList = CommonFunction.getXMLtoSend();
		int noofXML = xmlfileList.length;
		if(fileExtensionName.equals(".xlsx")){

			syncServiceWorkbook = new XSSFWorkbook(inputStream);
			org.apache.poi.ss.usermodel.Sheet syncServiceSheet = syncServiceWorkbook.getSheet(sheetName);
			int totalRowNo = syncServiceSheet.getLastRowNum();

			for (int i = 0; i <= noofXML-1; i++) {
				for(File file1: xmlfileList ){
					if (file1.getName().contains(syncServiceSheet.getRow(i).getCell(1).getStringCellValue())) {
						String testName=syncServiceSheet.getRow(i).getCell(1).getStringCellValue();
						String LID=syncServiceSheet.getRow(i).getCell(2).getStringCellValue();
						String channel_id=syncServiceSheet.getRow(i).getCell(3).getStringCellValue();
						String dslam=syncServiceSheet.getRow(i).getCell(4).getStringCellValue();
						String port= String.valueOf(syncServiceSheet.getRow(i).getCell(5).getStringCellValue());
						String sik=syncServiceSheet.getRow(i).getCell(6).getStringCellValue();
						//String externalInstallationID=syncServiceSheet.getRow(i).getCell(3).getStringCellValue();
						AddTest addtest = new AddTest(testName, LID, channel_id, dslam, port, sik);
						al.add(addtest);
					}
				}
				
			}

		}

		else if(fileExtensionName.equals(".xls")){

			syncServiceWorkbook = new XSSFWorkbook(inputStream);
			org.apache.poi.ss.usermodel.Sheet syncServiceSheet = syncServiceWorkbook.getSheet(sheetName);
			int totalRowNo = syncServiceSheet.getLastRowNum();

			for (int i = 0; i <= totalRowNo; i++) {
				for(File file1: xmlfileList ){
					if (syncServiceSheet.getRow(i).getCell(1).getStringCellValue().contains(file1.getName())) {
						String testName=syncServiceSheet.getRow(i).getCell(1).getStringCellValue();
						String LID=syncServiceSheet.getRow(i).getCell(2).getStringCellValue();
						String channel_id=syncServiceSheet.getRow(i).getCell(3).getStringCellValue();
						String dslam=syncServiceSheet.getRow(i).getCell(4).getStringCellValue();
						String port=syncServiceSheet.getRow(i).getCell(5).getStringCellValue();
						String sik=syncServiceSheet.getRow(i).getCell(6).getStringCellValue();
						//String externalInstallationID=syncServiceSheet.getRow(i).getCell(3).getStringCellValue();
						AddTest addtest = new AddTest (testName, LID, channel_id, dslam, port, sik);;
						al.add(addtest);

					}
				}
				
			}

		}
		/*
		else if(fileExtensionName.equals(".ods")){

			inputStream = new FileInputStream(file);
			sheet = SpreadSheet.createFromFile(file).getSheet("input");

			//Get row count and column count
			int nColCount = sheet.getColumnCount();
			int totalRowNo = sheet.getRowCount();

			int counter = 0;
			// System.out.println(sheet.getValueAt(1, 1));
			while ((String)sheet.getValueAt(0, counter)!="") {

				counter=counter+1;
			}

			for (int i = 0; i <= counter; i++) {
				if (((String) sheet.getValueAt(0, i)).equalsIgnoreCase("Y")) {
					String testName=(String) sheet.getValueAt(5, i);
					AddTest addtest = new AddTest(testName);
					al.add(addtest);

				}
			}
		}
		 */			
	}
}

