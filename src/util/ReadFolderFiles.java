package util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;

public class ReadFolderFiles {


	public static String readFolderFiles(String folderpath){
		String inputFile=null;
		File folder = new File(folderpath);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				System.out.println(file.getName());
				if (file.getName().startsWith("IHTSOA")) {
					inputFile = file.getName();
				}
			}
		}
		return inputFile;


	}
	
	
	/* *******************************************************************************
	   Function Name : readXml
	   Created By : Nishant Kumar
	   Creation Date : 6th April 2017
	   Purpose : Delete a particular directory
	   Return Type : true in case of pass and false in case f failure
	 **********************************************************************************/
	public static File[] readXml(String folderpath){
		String inputFile=null;
		File folder = new File(folderpath);
		File[] listOfFiles = folder.listFiles();
		
		return listOfFiles;

	}
	/*
	public static void movetoHistory() throws IOException{
		try {
			String inputFile=null;
			DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
			Calendar calobj = Calendar.getInstance();
			System.out.println(df.format(calobj.getTime()));
			String date = df.format(calobj.getTime());
			String date1 = date.substring(date.lastIndexOf(" ")+1);
			System.out.println(date1);
			String date2 = date1.replaceAll(":", "_");
			System.out.println(date2);
			String folderpathHistory = Common.getvalueRepository("archieveHistort");
			String folderpatCurrent = Common.getvalueRepository("Resultfolderpath");

			File folder = new File(folderpatCurrent);
			File[] listOfFiles = folder.listFiles();
			//int counter=1;
			for (File file : listOfFiles) {

				System.out.println(file.getName());
				File sourceFile = new File(folderpatCurrent+"\\"+file.getName());
				File destDir = new File(folderpathHistory+"\\"+file.getName()+"_"+date2+"_Archieved");
				//counter=counter+1;

				FileUtils.moveDirectory(sourceFile, destDir);    
				System.out.println("Archieved successfully");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			 e.printStackTrace();
			 System.out.println("Can't be archieved");
		}

	 */	


}
