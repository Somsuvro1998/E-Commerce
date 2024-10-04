package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import generic_utilities.WebDriver_Utilities;

public class CatagoryPage {
	
	public CatagoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="(//i[@class='fa fa-facebook'])[2]")
	private WebElement facebookLink;
	
	//Getter method
	public WebElement getFacebookLink()
	{
		return facebookLink;
	}
	//Business logic
	public void scrollToFacebookLink(WebDriver driver)
	{
		WebDriver_Utilities wlib=new WebDriver_Utilities();
		wlib.scrollIntoView(driver,facebookLink);
				
	}
	public void clickOnFacebookLink()
	{
     facebookLink.click();	
	}

}
