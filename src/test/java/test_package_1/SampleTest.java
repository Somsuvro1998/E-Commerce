package test_package_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic_utilities.ExtentImplementation;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(generic_utilities.ExtentImplementation.class)
public class SampleTest {
	@Test
public void sampleTest1() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.google.co.in/");
}
@Test
public void sampleTest2() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	SoftAssert sa=new SoftAssert();
	sa.assertEquals(false, true);
	driver.get("https://www.facebook.com/");
	sa.assertAll();
}
}
