package automation.testsuite;

import static org.testng.Assert.*;

import org.testng.annotations.*;
import automation.common.CommonBase;
import automation.constant.Constant;
import automation.page.LoginPage;

public class test extends CommonBase{
	
	@Parameters("browser")
	@BeforeMethod
	public void openDriver(@Optional("chrome") String browser) {
		driver = setupDriver(browser);
		driver.get(Constant.RISE_URL);
	}

	@Test(priority = 1)
	public void LoginSuccessfully() {
		LoginPage login = new LoginPage(driver);
		login.LoginFuntion(Constant.EMAIL, Constant.PASSWORD);
	}

	@AfterMethod
	public void closeChrome() {
		closeDriver();
	}
}
