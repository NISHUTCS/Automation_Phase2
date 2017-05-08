package util;

public class AddTest {
	public String testName;
	public String LID;
	public String channel_id;
	public String dslam;
	public String port;
	public String sik;
	public String test_speed;
	public String technical_profile_name;
   public AddTest(String testName,String LID, String channel_id, String dslam, String port, String sik, String test_speed, String technical_profile_name){
	 this.testName = testName;
	 this.LID = LID;
	 this.channel_id = channel_id;
	 this.dslam = dslam;
	 this.port = port;
	 this.sik = sik;
	 this.test_speed = test_speed;
	 this.technical_profile_name = technical_profile_name;
 }
}
