package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	@FindBy (id = "email")
	WebElement emailElement;
	
	@FindBy (id = "password")
	WebElement passwordElement;
	
	@FindBy (xpath = "//button[normalize-space()='Sign in']")
	WebElement signinBtnElement;
	
	@FindBy (id = "user-dropdown")
	WebElement userAvatarElement;
	
	@FindBy (xpath = "//li[normalize-space()='Sign Out']")
	WebElement signoutBtnElement;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void LoginFuntion(String email, String password) {
		emailElement.clear();
		emailElement.sendKeys(email);
		passwordElement.clear();
		passwordElement.sendKeys(password);
		signinBtnElement.click();
	}
	
	public void LogoutFuntion(String email, String password) {
		LoginFuntion(email, password);
		
		userAvatarElement.click();
		signoutBtnElement.click();
	}
}
