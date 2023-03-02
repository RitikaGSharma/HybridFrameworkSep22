package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	public static String getproperty(String key)
	{
		Properties pro=new Properties();
		try {
			pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/config/ConfigProp")));
		} catch (IOException e) {
			System.out.println("Error"+e.getMessage());
		}
		return pro.getProperty(key);
	}

}
