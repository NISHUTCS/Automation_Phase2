package XMLObjectOR;

public class XMLOR {
	public static String baseXML(){
		//EB611567
		return "<command>\r\n" + 
		"  <cb-system>\r\n" + 
		"    <session-id>Fullrate-327481</session-id>\r\n" + 
		"    <transaction-id>109</transaction-id>\r\n" + 
		"    <columbine-session-id/>\r\n" + 
		"  </cb-system>\r\n" + 
		"  <name>access-broadband-manager</name>\r\n" + 
		"  <parameter-list>\r\n" + 
		"    <broadband-manager-parameters>\r\n" + 
		"      <dtd-name>ihtsoaWholeSale</dtd-name>\r\n" + 
		"      <operation>get_accesspoint</operation>\r\n" + 
		"      <phone-no>EB600629</phone-no>\r\n" + 
		"      <sik-value/>\r\n" + 
		"      <logical-poi/>\r\n" + 
		"      <circuit-id>0</circuit-id>\r\n" + 
		"      <dslam-name/>\r\n" + 
		"      <port/>\r\n" + 
		"      <range/>\r\n" + 
		"      <test-speed/>\r\n" + 
		"      <multicast/>\r\n" + 
		"      <stream>1</stream>\r\n" + 
		"      <store>STREAM</store>\r\n" + 
		"    </broadband-manager-parameters>\r\n" + 
		"  </parameter-list>\r\n" + 
		"</command>";
	}
	public static String findAddressXML(){
		return 	"<command>\r\n" + 
				"	<cb-system>\r\n" + 
				"		<session-id>1448</session-id>\r\n" + 
				"		<transaction-id />\r\n" + 
				"		<columbine-session-id />\r\n" + 
				"	</cb-system>\r\n" + 
				"	<name>find-address</name>\r\n" + 
				"	<parameter-list>\r\n" + 
				"		<installation>\r\n" + 
				"			<address>\r\n" + 
				"				<street-code />\r\n" + 
				"				<municipal-code />\r\n" + 
				"				<street-name>åstræde</street-name>\r\n" + 
				"				<house-no>11</house-no>\r\n" + 
				"				<door-no />\r\n" + 
				"				<zip-code>2800</zip-code>\r\n" + 
				"				<county />\r\n" + 
				"				<main-door>4</main-door>\r\n" + 
				"				<floor></floor>\r\n" + 
				"			</address>\r\n" + 
				"		</installation>\r\n" + 
				"	</parameter-list>\r\n" + 
				"</command>";
	}
	public static String getEventStatusXML(){
		return "<command xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'\r\n" +
			"	    xmlns:uib='http://www.unisys.dk/infobroker' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>\r\n" +
				"<cb-system>\r\n" + 
				"    <session-id>3000009513</session-id>\r\n" + 
				"     <transaction-id>1</transaction-id>\r\n" + 
				"  </cb-system>\r\n" + 
				"   <name>get-event-status</name>\r\n" + 
				"</command>";
	}
}
