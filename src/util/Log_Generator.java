package util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Log_Generator {
public 	FileWriter fw = null;
	public BufferedWriter bw = null;
		   String FILENAME;
		 public void CreateLogfile(String Filepath)
		 		 {
			 FILENAME=Filepath;
			 try {
				 File f=new File(FILENAME);
				 f=null;
				fw = new FileWriter(FILENAME);
				 bw = new BufferedWriter(fw);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 public void WriteLogfile(String content)
		 {
				try {
					String currenttimestamp=util.CommonFunction.GetcurrentTime();
					bw.write("["+currenttimestamp+ " ] :: "+content+"\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
		 }
		 public void CloseLogfile()
		 {
				try {
					if (bw != null)
						bw.close();
					if (fw != null)
						fw.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
	}
