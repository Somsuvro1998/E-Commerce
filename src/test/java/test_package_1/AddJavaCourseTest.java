package test_package_1;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic_utilities.BaseClass_Ecommerce;
import pom.HomePage;

public class AddJavaCourseTest extends BaseClass_Ecommerce {
	@Test
	public void addJavaCourseTest() throws Throwable
	{
		
		HomePage hp=new HomePage(driver);
		hp.moveToCourseLink(driver);
		hp.openJavaInNewTab(driver);
		Thread.sleep(3000);
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(false, true);
		wlib.WindowSwitching(driver);
		Thread.sleep(3000);
		sa.assertAll();
		
	}

}
