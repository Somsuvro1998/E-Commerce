package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavaPage {
	public JavaPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//button[@ondblclick='addtocart()']")
	private WebElement addToCartBtn;
	
	//getter method
	public WebElement getAddToCartBtn()
	{
		return addToCartBtn;
	}
	//business logic
	public void clickOnAddToCartBtn()
	{
		addToCartBtn.click();
	}

}
