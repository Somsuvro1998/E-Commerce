package generic_utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

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
	public void beforeClass() throws Throwable
	{
		String BROWSER = flib.getKeyAndValueData("browser");
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
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
