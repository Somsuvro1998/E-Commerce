package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import generic_utilities.WebDriver_Utilities;

public class HomePage {

	//Initialization of elements
	public HomePage(WebDriver driver)
	{
	PageFactory.initElements(driver,this);	
	}
	@FindBy(xpath="//a[@id='course']")
	private WebElement courseLink;
	
	@FindBy(xpath="(//a[text()='Java'])[1]")
	private WebElement javaLink;
	
	@FindBy(xpath="//select[@class='chosen-select']")
	private WebElement dropDown;
	
	@FindBy(xpath="//a[text()='FEEDBACK']")
	private WebElement feedbackLink;
	
	//Getter methods
	public WebElement getCourseLink()
	{
		return courseLink;
	}
	public WebElement getJavaLink()
	{
		return javaLink;
	}
	public WebElement getDropDown()
	{
		return dropDown;
	}
	public WebElement getFeedbackLink()
	{
		return feedbackLink;
	}
	
	//Business Logic
	public void moveToCourseLink(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.moveToElement(courseLink).perform();
	}
	public void clickOnJavaLink()
	{
		javaLink.click();
	}
	public void openJavaInNewTab(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.keyDown(Keys.CONTROL).click(javaLink).keyUp(Keys.CONTROL).perform();	
	}
	public void clickOnDropDown()
	{
		dropDown.click();
	}
	public void selectTestingFromDropdown()
	{
		Select s=new Select(dropDown);
		s.selectByVisibleText("Testing");
	}
	public void openFeedbackInNewTab(WebDriver driver)
	{
		WebDriver_Utilities wlib=new WebDriver_Utilities();
		wlib.OpenLinkInNewTab(driver,feedbackLink );
		
	}	
}
