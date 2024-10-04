package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeedbackPage {
	public FeedbackPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@name='downloadInvoice']")
	private  WebElement downloadInvoiceBtn;
	
	//getter method
	public WebElement getDownloadInvoice()
	{
		return downloadInvoiceBtn;
	}
	//Business Logic
	public void clickOnDownloadInvoiceBtn()
	{
		downloadInvoiceBtn.click();
	}

}
