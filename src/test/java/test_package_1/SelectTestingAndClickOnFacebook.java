package test_package_1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import generic_utilities.BaseClass_Ecommerce;
import generic_utilities.WebDriver_Utilities;
import pom.CatagoryPage;
import pom.HomePage;

@Listeners(generic_utilities.ExtentImplementation.class)
public class SelectTestingAndClickOnFacebook extends BaseClass_Ecommerce{
	@Test
	public void SelectTestingAndClickOnFacebookTest() throws Throwable
	{
	WebDriver_Utilities wlib=new WebDriver_Utilities();
	HomePage hp=new HomePage(driver);
	wlib.maximizeWindow(driver);
	Thread.sleep(3000);
	hp.selectTestingFromDropdown();
	Thread.sleep(3000);
	CatagoryPage cp=new CatagoryPage(driver);
	cp.scrollToFacebookLink(driver);
	Thread.sleep(3000);
	cp.clickOnFacebookLink();
	Thread.sleep(3000);
	
	}
}
