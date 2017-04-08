package util;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Date;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import com.sun.mail.smtp.*;
public class MailUtility {
	public static void ZipAndMailReport(String MailSummary) {
	
		ZipFolder.zipFolder_function();
		try {
			sendmail(MailSummary);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
    public static void sendmail(String MailSummary) throws Exception {
        Properties props = System.getProperties();
        String userdetails="";
        String adduserdetails="";
        if(PropertiesFileUtil.ReadPropValue("ScheduledBy").contains("@"))
        	userdetails=","+PropertiesFileUtil.ReadPropValue("ScheduledBy");
        if(!PropertiesFileUtil.ReadPropValue("AdditionalStakeHolderMails").equalsIgnoreCase("empty"))
        	adduserdetails=","+PropertiesFileUtil.ReadPropValue("AdditionalStakeHolderMails");
        String to_receipent="amkh@tdc.dk,CHMA@tdc.dk"+userdetails+adduserdetails;      //"amkh@tdc.dk,CHMA@tdc.dk";//amkh@tdc.dkamkh@tdc.dk,CHMA@tdc.dk
        String cc_receipent="YPA@tdc.dk,prkum@tdc.dk,dacheb@tdc.dk";//"YPA@tdc.dk,prkum@tdc.dk,naalo@tdc.dk";
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy : HH.mm.ss").format(new Timestamp(System.currentTimeMillis()));
        props.put("hmail-common.tdk.dk","false");
        //props.put("hmail-common.tdk.dk","false");
        Session session = Session.getInstance(props, null);
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("SEAutomation@tdc.dk"));;
        msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(to_receipent, false));
        msg.setRecipients(Message.RecipientType.CC,
                InternetAddress.parse(cc_receipent, false));
        msg.setSubject("Auto Email : Self-Service-Business Regression testing : "+timeStamp);//+System.currentTimeMillis());
        msg.setHeader("X-Mailer", "SMTP Automation test");
        msg.setSentDate(new Date());
        String text = "Please DO NOT REPLY on this email\n\n\n Hi Stakeholder,\n\nPlease find the automation test report for Self-Service-Business Regression executed on "+ timeStamp +MailSummary+"\n\n Regards,\n Test Automation Team\n**********************************\nOnsite: Yuvaraja Paramasivam\n    ypa@tdc.dk\n  +4571591375\n\nOffshore:       Prashant Kumar\n   prkum@tdc.dk\n +918420017121\n**********************************";
        String mailBodyPart1="<Html><p style='color:red;'><b>Please DO NOT REPLY on this email</b></P>";
        String mailBodyPart2="<p>Dear Stakeholder,<br><br>Please find the automation test report for Self-Service-Business Regression executed on "+timeStamp+"</P><Table style='text-align: left;'>";
        String mailBodyfooter="</table><p>Regards,<br> Test Automation Team<br>**********************************<br><b>Onsite:</b><br> Yuvaraja Paramasivam<br>ypa@tdc.dk<br> +4571591375<br>Dakshayani Chebrolu<br>dacheb@tdc.dk<br>+4571364996<br><b>Offshore:</b><br>Prashant Kumar<br> prkum@tdc.dk<br> +918420017121<br>**********************************</p></html>";
        String newlineSpace="<tr><td style='line-height:15px;'>&nbsp;</td></tr>";
        text=mailBodyPart1+mailBodyPart2+MailSummary+mailBodyfooter;
        msg.setText(text);
        Multipart mp = new MimeMultipart();
        MimeBodyPart htmlPart = new MimeBodyPart();
        htmlPart.setContent(text, "text/html");
        mp.addBodyPart(htmlPart);
        msg.setContent(mp);
        
      /* MimeBodyPart messageBodyPart = new MimeBodyPart();
        Multipart multipart = new MimeMultipart();
        messageBodyPart = new MimeBodyPart();
        String text = "Please DO NOT REPLY on this email\n\n\n Hi Stakeholder,\n\nPlease find the automation test report for Self-Service-Business Regression executed on "+ timeStamp +MailSummary+"\n\n Regards,\n Test Automation Team\n**********************************\nOnsite: Yuvaraja Paramasivam\n    ypa@tdc.dk\n  +4571591375\n\nOffshore:       Prashant Kumar\n   prkum@tdc.dk\n +918420017121\n**********************************";
        MimeBodyPart textPart = new MimeBodyPart();
        textPart.setText( text, "utf-8" );
        multipart.addBodyPart( textPart );
        DataSource source = new FileDataSource(ZipFolder.OUTPUT_ZIP_FILE);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(ZipFolder.fileName);
        multipart.addBodyPart(messageBodyPart);
        msg.setContent(multipart);
      */SMTPTransport t =
                (SMTPTransport)session.getTransport("smtp");
        t.connect("hmail-common.tdk.dk", "", "");
        t.sendMessage(msg, msg.getAllRecipients());
        System.out.println("Response: " + t.getLastServerResponse());
        t.close();
    }
    
    public static void main(String[] args) {
    	try {
    		PropertiesFileUtil.loadPropertiesFile();
			sendmail("<b>Test</b>");
			PropertiesFileUtil.closePropertiesFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
