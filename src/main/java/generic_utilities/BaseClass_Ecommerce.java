package generic_utilities;

import java.net.URL;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass_Ecommerce {
	public WebDriver driver;
	public static WebDriver sdriver;
	public File_Utility flib=new File_Utility();
	public WebDriver_Utilities wlib=new WebDriver_Utilities();
	
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Connecting database");
	}
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Starting Parallel Execution");
	}
	@BeforeClass
	@Parameters({"os","browser"})
	public void beforeClass(String os, String browser) throws Throwable
	{
		//String BROWSER = flib.getKeyAndValueData("browser");
		//String env = flib.getKeyAndValueData("executions_env");
	try {	if(flib.getKeyAndValueData("execution_env").equalsIgnoreCase("remote"))
		{
          DesiredCapabilities capabilities=new DesiredCapabilities();
		//os
		if(os.equalsIgnoreCase("windows"))
		{
			capabilities.setPlatform(Platform.WIN11);
		}
		else if(os.equalsIgnoreCase("mac"))
		{
			capabilities.setPlatform(Platform.MAC);
		}
		else if(os.equalsIgnoreCase("Linux"))
		{
			capabilities.setPlatform(Platform.LINUX);
		}
		else
		{
			System.out.println("No matching os");
			return;
		}
		//browser
		if(browser.equalsIgnoreCase("chrome"))
		{
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
			capabilities.setBrowserName("Chrome");
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
//			WebDriverManager.edgedriver().setup();
//			driver=new EdgeDriver();
			capabilities.setBrowserName("MicrosoftEdge");
		}
		else
		{
//			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
			System.out.println("No matching browser");
			return;
		}
		driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
		if(flib.getKeyAndValueData("execution_env").equalsIgnoreCase("local"))
		{
          
		//browser
		if(browser.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();	
		}
		else
		{
//			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
			System.out.println("No matching browser");
		}	
		}
		sdriver=driver; //storing driver into sdriver
	}
	@BeforeMethod
	public void beforeMethod() throws Throwable
	{
		String URL = flib.getKeyAndValueData("url");
		driver.get(URL);
	}
	@AfterMethod
	public void afterMethod()
	{
		driver.close();
	}
	@AfterClass
	public void afterClass()
	{
		driver.quit();
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("Closing Parallel Execution");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("Closing database connection");
	}
	
}
