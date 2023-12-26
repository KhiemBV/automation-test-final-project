package automation.testsuite;

import static org.testng.Assert.*;

import org.testng.annotations.*;
import automation.common.CommonBase;
import automation.constant.ConstantAccount;
import automation.page.Day13_LoginPage;

public class test extends CommonBase{
	
	@Parameters("browser")
	@BeforeMethod
	public void openDriver(@Optional("chrome") String browser) {
		driver = setupDriver(browser);
		driver.get(ConstantAccount.RISE_URL);
	}

	@Test(priority = 1)
	public void LoginSuccessfully() {
		Day13_LoginPage login = new Day13_LoginPage(driver);
		login.loginFuntion("admin@demo.com", "riseDemo");
		assertEquals(true, driver.findElement(ConstantAccount.DASHBOARD_TEXT).isDisplayed());
	}

	@Test(priority = 2)
	public void LoginFailIncorrertEmail() {
		Day13_LoginPage login = new Day13_LoginPage(driver);
		login.loginFuntion("ahihi@demo.com", "riseDemo");
		assertEquals(true, driver.findElement(ConstantAccount.AUTHENICATION_ALERT).isDisplayed());
	}
	
	@Test(priority = 3)
	public void LoginFailIncorrertPassword() {
		Day13_LoginPage login = new Day13_LoginPage(driver);
		login.loginFuntion("admin@demo.com", "ahihi");
		assertEquals(true, driver.findElement(ConstantAccount.AUTHENICATION_ALERT).isDisplayed());
	}
	
	@Test(priority = 4)
	public void LoginFailIncorrertEmail_Password() {
		Day13_LoginPage login = new Day13_LoginPage(driver);
		login.loginFuntion("ahihi@demo.com", "ahihi");
		assertEquals(true, driver.findElement(ConstantAccount.AUTHENICATION_ALERT).isDisplayed());
	}

	@AfterMethod
	public void closeChrome() {
		closeDriver();
	}
}
