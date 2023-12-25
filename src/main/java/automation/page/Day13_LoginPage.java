package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automation.constant.ConstantAccount;

public class Day13_LoginPage {
	private WebDriver driver;

	public Day13_LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void loginFuntion(String email, String password) {
		WebElement emailElement = driver.findElement(ConstantAccount.TEXT_EMAIL);
		if (emailElement.isEnabled()) {
			emailElement.clear();
			emailElement.sendKeys(email);
		}
		WebElement passwordElement = driver.findElement(ConstantAccount.TEXT_PASSWORD);
		if (passwordElement.isEnabled()) {
			passwordElement.clear();
			passwordElement.sendKeys(password);
		}
		WebElement loginButtonElement = driver.findElement(ConstantAccount.BUTTON_SIGNIN);
		if (loginButtonElement.isEnabled()) {
			loginButtonElement.click();	
		}
	}
}
