package classUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	public Properties prob;
	public ReadConfig()
	{
		File src=new File("./Configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			prob=new Properties();	
			prob.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String GetApplicationUrl()
	{
		String url=prob.getProperty("URL");
		return url;	
	}
	
	public String GetUserName()
	{
		String Username=prob.getProperty("UserName");
		return Username;
	}
	
	public String GetPassWord()
	{
		String Password=prob.getProperty("PassWord");
		return Password;
	}
	
	public String GetChromedriver()
	{
		String Chromepath=prob.getProperty("ChromPath");
		return Chromepath;
	}
}
