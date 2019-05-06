package siteUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataReader {

 Properties pro;
	
	public ConfigDataReader()
	{
		pro=new Properties();
		File src=new File(System.getProperty("user.dir")+"/Configuration/config.properties");
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			pro.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}
	
	public String getURL()
	{
		return pro.getProperty("AppURL");
	}
	
	public String getExcelPath()
	{
		return pro.getProperty("ExcelPath");
	}
	
}
