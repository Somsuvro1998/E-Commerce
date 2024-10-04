package test_package_1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic_utilities.BaseClass_Ecommerce;
import generic_utilities.WebDriver_Utilities;
import pom.FeedbackPage;
import pom.HomePage;

@Listeners(generic_utilities.ExtentImplementation.class)
public class DownloadInvoice extends BaseClass_Ecommerce{
	@Test
	public void downloadInvoiceTest() throws Throwable
	{   
		wlib.maximizeWindow(driver);
		HomePage hp=new HomePage(driver);
		Thread.sleep(3000);
		hp.openFeedbackInNewTab(driver);
		Thread.sleep(3000);
		wlib.WindowSwitching(driver);
		Thread.sleep(3000);
		FeedbackPage fp=new FeedbackPage(driver);
		fp.clickOnDownloadInvoiceBtn();
		Thread.sleep(3000);
		
		
	}

}
