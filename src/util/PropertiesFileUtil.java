package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/* ************************************************************************************************
Class Name : PropertiesFileUtil
Created by : Yuvaraja P
Date : 	  02/1/2017
Purpose :   Class contains methods to support  loading,reading and closing the config file 
***************************************************************************************************/
public class PropertiesFileUtil {

	static Properties prop = new Properties();
	static InputStream input = null;
	public static void main(String[] args) {
		loadPropertiesFile();
		System.out.println(PropertiesFileUtil.ReadPropValue("dbHost")+":"+PropertiesFileUtil.ReadPropValue("dbPort")+":"+PropertiesFileUtil.ReadPropValue("dbSID")+", "+PropertiesFileUtil.ReadPropValue("dbUserName")+","+PropertiesFileUtil.ReadPropValue("dbPassword"));
		closePropertiesFile();
	}
	public static void loadPropertiesFile(){
		try {
			input = new FileInputStream(CommonFunction.getCurrentDirectory()+"\\src\\util\\Config.properties");
			//input = new FileInputStream(ScaleTestCases.CurrentDirectory+"\\src.app\\Config.properties");
			// load a properties file
			prop.load(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String ReadPropValue(String Key)
	{
		return prop.getProperty(Key);
	}
	public  static void closePropertiesFile()
	{
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
