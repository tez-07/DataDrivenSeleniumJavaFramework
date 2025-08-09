package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);		//learn this
	}

	//WebElements
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	
	//Methods
	public void clickmyAccountDropMenu() {
		myAccountDropMenu.click();
	}
	
	/*	//can directly navigate to the LoginPage after clicking on the Login Option
	public void selectLoginOption() {
		loginOption.click();
	}
	*/
	
	public LoginPage selectLoginOption() {
		loginOption.click();
		return new LoginPage(driver);			//LoginPage lp = new LoginPage is not required in Login
	}
	
	
}
