package test_package_1;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic_utilities.BaseClass_Ecommerce;
import pom.HomePage;
import pom.JavaPage;
@Listeners(generic_utilities.ExtentImplementation.class)
public class AddJavaCourseTest extends BaseClass_Ecommerce {
	@Test
	public void addJavaCourseTest() throws Throwable
	{
		wlib.maximizeWindow(driver);
		HomePage hp=new HomePage(driver);
		hp.moveToCourseLink(driver);
		hp.openJavaInNewTab(driver);
		Thread.sleep(3000);
		//SoftAssert sa=new SoftAssert();
		//sa.assertEquals(false, true);
		wlib.WindowSwitching(driver);
		Thread.sleep(3000);
		//sa.assertAll();
		JavaPage jp=new JavaPage(driver);
		jp.clickOnAddToCartBtn();
		wlib.alertAccept(driver);
		Thread.sleep(3000);
		
	}

}
