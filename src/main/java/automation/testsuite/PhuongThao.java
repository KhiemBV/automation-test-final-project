package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class PhuongThao extends CommonBase{
	@Parameters("browser")
	@BeforeMethod
	public void openChrome(@Optional("chrome")String browser) {
		setupDriver(browser);
		driver.get("https://rise.fairsketch.com/signin");
	}
	@Test
	public void ManageLabel() {
		type(By.xpath("//input[@id='email']"),"admin@demo.com");
		type(By.xpath("//input[@id='password']"),"riseDemo");
		click(By.xpath("//button[text()='Sign in']"));
		isElementPresent(By.xpath("//span[text()='John Doe']"));
		click(By.xpath("//span[text()='Events']"));
		isElementPresent(By.xpath("//h1[text()='Event calendar']"));
		click(By.xpath("//a[text()=' Manage labels']"));
		type(By.xpath("//input[@id='title']"),"màu đỏ");
		click(By.xpath("//span[@data-color='#e74c3c']"));
		click(By.xpath("//button[text()=' Save']"));
		isElementPresent(By.xpath("//span[text()='màu đỏ']"));


	}
	@Test
	public void CheckMandatoryField() {
		type(By.xpath("//input[@id='email']"),"admin@demo.com");
		type(By.xpath("//input[@id='password']"),"riseDemo");
		click(By.xpath("//button[text()='Sign in']"));
		isElementPresent(By.xpath("//span[text()='John Doe']"));
		click(By.xpath("//span[text()='Events']"));
		isElementPresent(By.xpath("//h1[text()='Event calendar']"));
		click(By.xpath("//a[text()=' Manage labels']"));
		type(By.xpath("//input[@id='title']"),"");
		click(By.xpath("//span[@data-color='#e74c3c']"));
		click(By.xpath("//button[text()=' Save']"));
		isElementPresent(By.xpath("//span[text()='This field is required.']"));


	}
	@Test
	public void FiltereByWeek() {
		type(By.xpath("//input[@id='email']"),"admin@demo.com");
		type(By.xpath("//input[@id='password']"),"riseDemo");
		click(By.xpath("//button[text()='Sign in']"));
		isElementPresent(By.xpath("//span[text()='John Doe']"));
		click(By.xpath("//span[text()='Events']"));
		isElementPresent(By.xpath("//h1[text()='Event calendar']"));
		click(By.xpath("//button[text()='week']"));
		String expectedWeek = getWeekWithSpecialFormat();
		String actualweek = driver.findElement(By.xpath("//h2[@class='fc-toolbar-title']")).getText();
		assertEquals(actualweek, "Dec 24 - 30, 2023");
		


	}
	

	@AfterMethod // testNG annotation
	public void closeChromeDriver() {
		driver.close();
	}
}
