package generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {

	public String getKeyAndValueData(String key) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/E-commerce.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}
}
