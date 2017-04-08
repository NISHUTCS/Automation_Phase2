package testCases;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import XMLObjectOR.XMLOR;
import util.CommonFunction;
import util.Reporting;
import util.TestBase;

public class TestCases extends TestBase {
	public static String pureSuiteName;

	@Parameters({ "LID"})
	@Test
	public void GetAccesspoint(String LID) throws FileNotFoundException {
		//String statuscode = "statuscode=0";
		String currentDir=CommonFunction.getCurrentDirectory();
		System.out.println(currentDir);
		String xmlFile2Send = currentDir+"\\src\\iHTSOARequestXML\\GetAccesspoint.xml";
		String responseFileName = currentDir+"\\src\\iHTSOAResponceXML\\GetAccesspoint.xml";
		//String modifiedxmlFile2Send = currentDir+"\\src\\RunTimeXML\\requestIsAlive.xml";
		String RESTUrl = "http://gisla-pn2.ip.tdk.dk/ihtsoa/index.php";
		CommonFunction CF=new CommonFunction();
		Reporting obj_testReport = new Reporting(testName);
		boolean testresult=true;
		try {
			String desiredxml=CF.createDesiredXML(xmlFile2Send, obj_testReport, LID);
			//CF.storeXML(modifiedxmlFile2Send, desiredxml,obj_testReport,"Request");
			StringBuilder response=CF.sendRestRequest(RESTUrl, "test", xmlFile2Send, responseFileName,obj_testReport, desiredxml);
			String responsexml=response.toString();
			System.out.println("responce:"+response);
			CF.storeXML(responseFileName, responsexml,obj_testReport,"Response");
			CF.ValidateXML(responsexml, "statuscode=\"0\"", obj_testReport);
			CF.ValidateXML(responsexml, "statusmessage=\"No complications occured\"", obj_testReport);
			//Assert.assertTrue(responsexml.contains("<isSynchServiceAlive>true</isSynchServiceAlive>"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Parameters("LID")
	@Test
	public void SetSpeed(String LID) throws FileNotFoundException {
		//String statuscode = "statuscode=0";
		CommonFunction cnf  = new CommonFunction();
		cnf.getXMLtoSend();
		String currentDir=CommonFunction.getCurrentDirectory();
		System.out.println(currentDir);
		String xmlFile2Send = currentDir+"\\src\\iHTSOARequestXML\\SetSpeed.xml";
		String responseFileName = currentDir+"\\src\\iHTSOAResponceXML\\SetSpeed.xml";
		//String modifiedxmlFile2Send = currentDir+"\\src\\RunTimeXML\\requestIsAlive.xml";
		String RESTUrl = "http://gisla-pn2.ip.tdk.dk/ihtsoa/index.php";
		CommonFunction CF=new CommonFunction();
		Reporting obj_testReport = new Reporting(testName);
		boolean testresult=true;
		try {
			String desiredxml=CF.createDesiredXML(xmlFile2Send, obj_testReport, LID);
			//CF.storeXML(modifiedxmlFile2Send, desiredxml,obj_testReport,"Request");
			StringBuilder response=CF.sendRestRequest(RESTUrl, "test", xmlFile2Send, responseFileName,obj_testReport, desiredxml);
			String responsexml=response.toString();
			System.out.println("responce:"+response);
			CF.storeXML(responseFileName, responsexml,obj_testReport,"Response");
			CF.ValidateXML(responsexml, "statuscode=\"0\"", obj_testReport);
			CF.ValidateXML(responsexml, "statusmessage=\"No complications occured\"", obj_testReport);
			//Assert.assertTrue(responsexml.contains("<isSynchServiceAlive>true</isSynchServiceAlive>"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Parameters("LID")
	@Test
	public void GetSpeeds(String LID) throws FileNotFoundException {
		//String statuscode = "statuscode=0";
		CommonFunction cnf  = new CommonFunction();
		cnf.getXMLtoSend();
		String currentDir=CommonFunction.getCurrentDirectory();
		System.out.println(currentDir);
		String xmlFile2Send = currentDir+"\\src\\iHTSOARequestXML\\GetSpeeds.xml";
		String responseFileName = currentDir+"\\src\\iHTSOAResponceXML\\GetSpeeds.xml";
		//String modifiedxmlFile2Send = currentDir+"\\src\\RunTimeXML\\requestIsAlive.xml";
		String RESTUrl = "http://gisla-pn2.ip.tdk.dk/ihtsoa/index.php";
		CommonFunction CF=new CommonFunction();
		Reporting obj_testReport = new Reporting(testName);
		boolean testresult=true;
		try {
			String desiredxml=CF.createDesiredXML(xmlFile2Send, obj_testReport, LID);
			//CF.storeXML(modifiedxmlFile2Send, desiredxml,obj_testReport,"Request");
			StringBuilder response=CF.sendRestRequest(RESTUrl, "test", xmlFile2Send, responseFileName,obj_testReport, desiredxml);
			String responsexml=response.toString();
			System.out.println("responce:"+response);
			CF.storeXML(responseFileName, responsexml,obj_testReport,"Response");
			CF.ValidateXML(responsexml, "statuscode=\"0\"", obj_testReport);
			CF.ValidateXML(responsexml, "statusmessage=\"No complications occured\"", obj_testReport);
			//Assert.assertTrue(responsexml.contains("<isSynchServiceAlive>true</isSynchServiceAlive>"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Parameters("LID")
	@Test
	public void Retrain(String LID) throws FileNotFoundException {
		//String statuscode = "statuscode=0";
		CommonFunction cnf  = new CommonFunction();
		cnf.getXMLtoSend();
		String currentDir=CommonFunction.getCurrentDirectory();
		System.out.println(currentDir);
		String xmlFile2Send = currentDir+"\\src\\iHTSOARequestXML\\Retrain.xml";
		String responseFileName = currentDir+"\\src\\iHTSOAResponceXML\\Retrain.xml";
		//String modifiedxmlFile2Send = currentDir+"\\src\\RunTimeXML\\requestIsAlive.xml";
		String RESTUrl = "http://gisla-pn2.ip.tdk.dk/ihtsoa/index.php";
		CommonFunction CF=new CommonFunction();
		Reporting obj_testReport = new Reporting(testName);
		boolean testresult=true;
		try {
			String desiredxml=CF.createDesiredXML(xmlFile2Send, obj_testReport, LID);
			//CF.storeXML(modifiedxmlFile2Send, desiredxml,obj_testReport,"Request");
			StringBuilder response=CF.sendRestRequest(RESTUrl, "test", xmlFile2Send, responseFileName,obj_testReport, desiredxml);
			String responsexml=response.toString();
			System.out.println("responce:"+response);
			CF.storeXML(responseFileName, responsexml,obj_testReport,"Response");
			CF.ValidateXML(responsexml, "statuscode=\"0\"", obj_testReport);
			CF.ValidateXML(responsexml, "statusmessage=\"No complications occured\"", obj_testReport);
			//Assert.assertTrue(responsexml.contains("<isSynchServiceAlive>true</isSynchServiceAlive>"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Parameters("LID")
	@Test
	public void OamTest_new(String LID) throws FileNotFoundException {
		//String statuscode = "statuscode=0";
		CommonFunction cnf  = new CommonFunction();
		cnf.getXMLtoSend();
		String currentDir=CommonFunction.getCurrentDirectory();
		System.out.println(currentDir);
		String xmlFile2Send = currentDir+"\\src\\iHTSOARequestXML\\OamTest_new.xml";
		String responseFileName = currentDir+"\\src\\iHTSOAResponceXML\\OamTest_new.xml";
		//String modifiedxmlFile2Send = currentDir+"\\src\\RunTimeXML\\requestIsAlive.xml";
		String RESTUrl = "http://gisla-pn2.ip.tdk.dk/ihtsoa/index.php";
		CommonFunction CF=new CommonFunction();
		Reporting obj_testReport = new Reporting(testName);
		boolean testresult=true;
		try {
			String desiredxml=CF.createDesiredXML(xmlFile2Send, obj_testReport, LID);
			//CF.storeXML(modifiedxmlFile2Send, desiredxml,obj_testReport,"Request");
			StringBuilder response=CF.sendRestRequest(RESTUrl, "test", xmlFile2Send, responseFileName,obj_testReport, desiredxml);
			String responsexml=response.toString();
			System.out.println("responce:"+response);
			CF.storeXML(responseFileName, responsexml,obj_testReport,"Response");
			CF.ValidateXML(responsexml, "statuscode=\"0\"", obj_testReport);
			CF.ValidateXML(responsexml, "statusmessage=\"No complications occured\"", obj_testReport);
			//Assert.assertTrue(responsexml.contains("<isSynchServiceAlive>true</isSynchServiceAlive>"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Parameters("LID")
	@Test
	public void OpenCloseService(String LID) throws FileNotFoundException {
		//String statuscode = "statuscode=0";
		CommonFunction cnf  = new CommonFunction();
		cnf.getXMLtoSend();
		String currentDir=CommonFunction.getCurrentDirectory();
		System.out.println(currentDir);
		String xmlFile2Send = currentDir+"\\src\\iHTSOARequestXML\\OpenCloseService.xml";
		String responseFileName = currentDir+"\\src\\iHTSOAResponceXML\\OpenCloseService.xml";
		//String modifiedxmlFile2Send = currentDir+"\\src\\RunTimeXML\\requestIsAlive.xml";
		String RESTUrl = "http://gisla-pn2.ip.tdk.dk/ihtsoa/index.php";
		CommonFunction CF=new CommonFunction();
		Reporting obj_testReport = new Reporting(testName);
		boolean testresult=true;
		try {
			String desiredxml=CF.createDesiredXML(xmlFile2Send, obj_testReport, LID);
			//CF.storeXML(modifiedxmlFile2Send, desiredxml,obj_testReport,"Request");
			StringBuilder response=CF.sendRestRequest(RESTUrl, "test", xmlFile2Send, responseFileName,obj_testReport, desiredxml);
			String responsexml=response.toString();
			System.out.println("responce:"+response);
			CF.storeXML(responseFileName, responsexml,obj_testReport,"Response");
			CF.ValidateXML(responsexml, "statuscode=\"0\"", obj_testReport);
			CF.ValidateXML(responsexml, "statusmessage=\"No complications occured\"", obj_testReport);
			//Assert.assertTrue(responsexml.contains("<isSynchServiceAlive>true</isSynchServiceAlive>"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Parameters("LID")
	@Test
	public void CreateCrossConnetc(String LID) throws FileNotFoundException {
		//String statuscode = "statuscode=0";
		CommonFunction cnf  = new CommonFunction();
		cnf.getXMLtoSend();
		String currentDir=CommonFunction.getCurrentDirectory();
		System.out.println(currentDir);
		String xmlFile2Send = currentDir+"\\src\\iHTSOARequestXML\\CreateCrossConnetc.xml";
		String responseFileName = currentDir+"\\src\\iHTSOAResponceXML\\CreateCrossConnetc.xml";
		//String modifiedxmlFile2Send = currentDir+"\\src\\RunTimeXML\\requestIsAlive.xml";
		String RESTUrl = "http://gisla-pn2.ip.tdk.dk/ihtsoa/index.php";
		CommonFunction CF=new CommonFunction();
		Reporting obj_testReport = new Reporting(testName);
		boolean testresult=true;
		try {
			String desiredxml=CF.createDesiredXML(xmlFile2Send, obj_testReport, LID);
			//CF.storeXML(modifiedxmlFile2Send, desiredxml,obj_testReport,"Request");
			StringBuilder response=CF.sendRestRequest(RESTUrl, "test", xmlFile2Send, responseFileName,obj_testReport, desiredxml);
			String responsexml=response.toString();
			System.out.println("responce:"+response);
			CF.storeXML(responseFileName, responsexml,obj_testReport,"Response");
			CF.ValidateXML(responsexml, "statuscode=\"0\"", obj_testReport);
			CF.ValidateXML(responsexml, "statusmessage=\"No complications occured\"", obj_testReport);
			//Assert.assertTrue(responsexml.contains("<isSynchServiceAlive>true</isSynchServiceAlive>"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Parameters("LID")
	@Test
	public void DeleteCrossConnetc(String LID) throws FileNotFoundException {
		//String statuscode = "statuscode=0";
		CommonFunction cnf  = new CommonFunction();
		cnf.getXMLtoSend();
		String currentDir=CommonFunction.getCurrentDirectory();
		System.out.println(currentDir);
		String xmlFile2Send = currentDir+"\\src\\iHTSOARequestXML\\DeleteCrossConnetc.xml";
		String responseFileName = currentDir+"\\src\\iHTSOAResponceXML\\DeleteCrossConnetc.xml";
		//String modifiedxmlFile2Send = currentDir+"\\src\\RunTimeXML\\requestIsAlive.xml";
		String RESTUrl = "http://gisla-pn2.ip.tdk.dk/ihtsoa/index.php";
		CommonFunction CF=new CommonFunction();
		Reporting obj_testReport = new Reporting(testName);
		boolean testresult=true;
		try {
			String desiredxml=CF.createDesiredXML(xmlFile2Send, obj_testReport, LID);
			//CF.storeXML(modifiedxmlFile2Send, desiredxml,obj_testReport,"Request");
			StringBuilder response=CF.sendRestRequest(RESTUrl, "test", xmlFile2Send, responseFileName,obj_testReport, desiredxml);
			String responsexml=response.toString();
			System.out.println("responce:"+response);
			CF.storeXML(responseFileName, responsexml,obj_testReport,"Response");
			CF.ValidateXML(responsexml, "statuscode=\"0\"", obj_testReport);
			CF.ValidateXML(responsexml, "statusmessage=\"No complications occured\"", obj_testReport);
			//Assert.assertTrue(responsexml.contains("<isSynchServiceAlive>true</isSynchServiceAlive>"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Parameters("LID")
	@Test
	public void Get_tech_profile_list(String LID) throws FileNotFoundException {
		//String statuscode = "statuscode=0";
		CommonFunction cnf  = new CommonFunction();
		cnf.getXMLtoSend();
		String currentDir=CommonFunction.getCurrentDirectory();
		System.out.println(currentDir);
		String xmlFile2Send = currentDir+"\\src\\iHTSOARequestXML\\Get_tech_profile_list.xml";
		String responseFileName = currentDir+"\\src\\iHTSOAResponceXML\\Get_tech_profile_list.xml";
		//String modifiedxmlFile2Send = currentDir+"\\src\\RunTimeXML\\requestIsAlive.xml";
		String RESTUrl = "http://gisla-pn2.ip.tdk.dk/ihtsoa/index.php";
		CommonFunction CF=new CommonFunction();
		Reporting obj_testReport = new Reporting(testName);
		boolean testresult=true;
		try {
			String desiredxml=CF.createDesiredXML(xmlFile2Send, obj_testReport, LID);
			//CF.storeXML(modifiedxmlFile2Send, desiredxml,obj_testReport,"Request");
			StringBuilder response=CF.sendRestRequest(RESTUrl, "test", xmlFile2Send, responseFileName,obj_testReport, desiredxml);
			String responsexml=response.toString();
			System.out.println("responce:"+response);
			CF.storeXML(responseFileName, responsexml,obj_testReport,"Response");
			CF.ValidateXML(responsexml, "statuscode=\"0\"", obj_testReport);
			CF.ValidateXML(responsexml, "statusmessage=\"No complications occured\"", obj_testReport);
			//Assert.assertTrue(responsexml.contains("<isSynchServiceAlive>true</isSynchServiceAlive>"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Parameters("LID")
	@Test
	public void Set_tech_profile(String LID) throws FileNotFoundException {
		//String statuscode = "statuscode=0";
		CommonFunction cnf  = new CommonFunction();
		cnf.getXMLtoSend();
		String currentDir=CommonFunction.getCurrentDirectory();
		System.out.println(currentDir);
		String xmlFile2Send = currentDir+"\\src\\iHTSOARequestXML\\Set_tech_profile.xml";
		String responseFileName = currentDir+"\\src\\iHTSOAResponceXML\\Set_tech_profile.xml";
		//String modifiedxmlFile2Send = currentDir+"\\src\\RunTimeXML\\requestIsAlive.xml";
		String RESTUrl = "http://gisla-pn2.ip.tdk.dk/ihtsoa/index.php";
		CommonFunction CF=new CommonFunction();
		Reporting obj_testReport = new Reporting(testName);
		boolean testresult=true;
		try {
			String desiredxml=CF.createDesiredXML(xmlFile2Send, obj_testReport, LID);
			//CF.storeXML(modifiedxmlFile2Send, desiredxml,obj_testReport,"Request");
			StringBuilder response=CF.sendRestRequest(RESTUrl, "test", xmlFile2Send, responseFileName,obj_testReport, desiredxml);
			String responsexml=response.toString();
			System.out.println("responce:"+response);
			CF.storeXML(responseFileName, responsexml,obj_testReport,"Response");
			CF.ValidateXML(responsexml, "statuscode=\"0\"", obj_testReport);
			CF.ValidateXML(responsexml, "statusmessage=\"No complications occured\"", obj_testReport);
			//Assert.assertTrue(responsexml.contains("<isSynchServiceAlive>true</isSynchServiceAlive>"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Parameters("LID")
	@Test
	public void CreateRouterConfig(String LID) throws FileNotFoundException {
		//String statuscode = "statuscode=0";
		CommonFunction cnf  = new CommonFunction();
		cnf.getXMLtoSend();
		String currentDir=CommonFunction.getCurrentDirectory();
		System.out.println(currentDir);
		String xmlFile2Send = currentDir+"\\src\\iHTSOARequestXML\\CreateRouterConfig.xml";
		String responseFileName = currentDir+"\\src\\iHTSOAResponceXML\\CreateRouterConfig.xml";
		//String modifiedxmlFile2Send = currentDir+"\\src\\RunTimeXML\\requestIsAlive.xml";
		String RESTUrl = "http://gisla-pn2.ip.tdk.dk/ihtsoa/index.php";
		CommonFunction CF=new CommonFunction();
		Reporting obj_testReport = new Reporting(testName);
		boolean testresult=true;
		try {
			String desiredxml=CF.createDesiredXML(xmlFile2Send, obj_testReport, LID);
			//CF.storeXML(modifiedxmlFile2Send, desiredxml,obj_testReport,"Request");
			StringBuilder response=CF.sendRestRequest(RESTUrl, "test", xmlFile2Send, responseFileName,obj_testReport, desiredxml);
			String responsexml=response.toString();
			System.out.println("responce:"+response);
			CF.storeXML(responseFileName, responsexml,obj_testReport,"Response");
			CF.ValidateXML(responsexml, "statuscode=\"0\"", obj_testReport);
			CF.ValidateXML(responsexml, "statusmessage=\"No complications occured\"", obj_testReport);
			//Assert.assertTrue(responsexml.contains("<isSynchServiceAlive>true</isSynchServiceAlive>"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*@Parameters({ "transactionId","externalInstallationID" })
	@Test
	public void CreateNetworkOperations(String transactionId,String externalInstallationID ) {
		String currentDir=CommonFunction.getCurrentDirectory();
		String xmlFile2Send = currentDir+"\\src\\RequestXmls\\Request_CreateNetworkOperation.xml";
		String responseFileName = currentDir+"\\src\\RequestXmls\\Response_CreateNetworkOperation.xml";
		String modifiedxmlFile2Send = currentDir+"\\src\\RunTimeXML\\Request_CreateNetworkOperation.xml";
		System.out.println(modifiedxmlFile2Send);
		String SOAPUrl = "http://syncsrv-test.tdk.dk/SynchWebService/services/synchservices";
		CommonFunction CF=new CommonFunction();
		Reporting obj_testReport = new Reporting(testName);
		boolean testresult=true;
		try {
			String desiredxml=CF.createDesiredXML(xmlFile2Send, obj_testReport, transactionId, externalInstallationID);
			System.out.println("desiredxml: "+desiredxml);
			CF.storeXML(modifiedxmlFile2Send, desiredxml,obj_testReport,"Request");
			StringBuilder response=CF.sendSoapRequest(SOAPUrl, "test", xmlFile2Send, responseFileName,obj_testReport,desiredxml);
			String responsexml=response.toString();
			//System.out.println("responce:"+response);
			obj_testReport.reportpassstep(responsexml);
			CF.storeXML(responseFileName, responsexml,obj_testReport,"Response");
			CF.ValidateXML(responsexml, "<syncAddressNetworkResponse>Success</syncAddressNetworkResponse>", obj_testReport);
			//Assert.assertTrue(responsexml.contains("<isSynchServiceAlive>true</isSynchServiceAlive>"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test
	public void columbineSample() {
		String currentDir=CommonFunction.getCurrentDirectory();
		// Request XML 
		String requestXML=currentDir+"\\src\\ColumbineRequestXML\\columbine.xml";
		// Default XML 
		String defaultrequestXML=currentDir+"\\src\\ColumbineRequestXML\\columbineDefault.xml";
		// Request XML to send 
		String toSendrequestXML=currentDir+"\\src\\ColumbineRequestXML\\columbineDefault.xml";
		// Response xml
		String xmlFile2Send = currentDir+"\\src\\RunTimeXML\\Requestcolumbine.xml";
		// Response xml
		String responseFileName = currentDir+"\\src\\ColumbineResponceXML\\responceColumbine.xml";
		// Application URL to connect
		String SOAPUrl = "https://itsg.test.tdc.dk:8444/itsb/karen/columbine";
		// Create object for common function
		CommonFunction CF=new CommonFunction();
		// Create object for reporting class
		Reporting obj_testReport = new Reporting(testName);
		//Assign initial Test result status
		boolean testresult=true;
		try {

			String encodedxml=ColumbineWrapper.encodeMessageWithPrivateKey(XMLOR.getEventStatusXML(), "TDCAS-KARENTCS.p12", "PKCS12", "CertTCS2014", "KAREN TCS (funktionscertifikat)");

			String xmlToSendCobi=CF.builtColumbineXMLwithEncodedValue(defaultrequestXML, obj_testReport, encodedxml);

			CF.storeXML(xmlFile2Send, xmlToSendCobi,obj_testReport,"Request");

			StringBuilder response=CF.sendSoapRequest(SOAPUrl, "test", xmlFile2Send, responseFileName,obj_testReport,xmlToSendCobi);

			String responsexml=response.toString();

			String rowEncodedXML=CF.remove_Header_Footer_CobiXML(responsexml, obj_testReport);
			//CF.storeXML(responseFileName, responsexml,obj_testReport,"Response");
			String decodedResponce=ColumbineWrapper.decodeSignedMessag(rowEncodedXML);
			System.out.println(decodedResponce);

			CF.storeXML(responseFileName, decodedResponce,obj_testReport,"Response");

			CF.ValidateXML(responsexml, "<isSynchServiceAlive>true</isSynchServiceAlive>", obj_testReport);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/
}
