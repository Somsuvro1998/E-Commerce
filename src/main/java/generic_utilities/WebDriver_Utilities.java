package generic_utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utilities {
	
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void implicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	public void alertAccept(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.accept();
	}
	public void alertDismiss(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}
	public void actionsMoveToElement(WebDriver driver,WebElement ele)
	{
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();	
	}
	public void javascriptExecutor(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",element);
	}
	public String takesScreenShot(WebDriver driver,String screenShotName) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshots/"+screenShotName+".png");
		FileUtils.copyFile(src,dest);
		return dest.getAbsolutePath();	
		}
	public void OpenLinkInNewTab(WebDriver driver,WebElement Link)
	{
		Actions action=new Actions(driver);
		action.keyDown(Keys.CONTROL).click(Link).keyUp(Keys.CONTROL).perform();
	}
	public void WindowSwitching(WebDriver driver)
	{
		Set<String> allWindows = driver.getWindowHandles();
		ArrayList<String> tabs=new ArrayList(allWindows);
		driver.switchTo().window(tabs.get(1));
	}
	public void doubleClick(WebDriver driver,WebElement ele)
	{
		Actions action=new Actions(driver);
		action.doubleClick(ele).perform();
	}
	public void mouseOver(WebDriver driver,WebElement ele)
	{
		Actions action=new Actions(driver);
		action.moveToElement(ele).perform();
	}
	public void scrollIntoView(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}
	
}





























