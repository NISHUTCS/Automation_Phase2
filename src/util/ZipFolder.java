package util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* *******************************************************************************
Class Name : Reporting
Created By : Prashant Kumar
Purpose : Class contatins helper methods to zip the test report before mailing.
Creation Date : 30th November 2016
**********************************************************************************/
public class ZipFolder
{
    List<String> fileList;
    public static final String fileName="SS_Report.zip";
    public static final String OUTPUT_ZIP_FILE = TestBase.CurrentDirectory+"\\Report\\Report_History\\zipoutput\\Zip\\Report.zip";
     static final String SOURCE_FOLDER = TestBase.ReportPath;
     public static void zipFolder_function(  )
    {
    	try 
    	{
			zipFolder(SOURCE_FOLDER, OUTPUT_ZIP_FILE);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    static public void zipFolder(String srcFolder, String destZipFile) throws Exception {
        ZipOutputStream zip = null;
        FileOutputStream fileWriter = null;
        File f=new File(destZipFile)	;
        f=null;
        fileWriter = new FileOutputStream(destZipFile);
        zip = new ZipOutputStream(fileWriter);
        addFolderToZip("", srcFolder, zip);
        zip.flush();
        zip.close();
      }
      static private void addFileToZip(String path, String srcFile, ZipOutputStream zip)
          throws Exception {
        File folder = new File(srcFile);
        if (folder.isDirectory()) {
          addFolderToZip(path, srcFile, zip);
        } else {
          byte[] buf = new byte[1024];
          int len;
          FileInputStream in = new FileInputStream(srcFile);
          zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
          while ((len = in.read(buf)) > 0) {
            zip.write(buf, 0, len);
          }
          in.close();
        }
      }
      static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
          throws Exception {
        File folder = new File(srcFolder);
        for (String fileName : folder.list()) {
          if (path.equals("")) {
            addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
          } else {
            addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
          }
        }
      }
}
