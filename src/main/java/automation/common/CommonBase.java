package automation.common;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonBase {
	public WebDriver driver;
	private int initWaitTime = 5;

	public boolean isElementPresent(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		} catch (org.openqa.selenium.TimeoutException e2) {
			return false;
		}
	}

	public WebElement getElementPresentDOM(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}

	public void type(By locator, String value) {
		WebElement element = getElementPresentDOM(locator);
		element.clear();
		element.sendKeys(value);
	}

	public void typeByJS_inValue(By locator, String value) {
		WebElement element = getElementPresentDOM(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '" + value + "'", element);
	}

	public void click(By locator) {
		WebElement element = getElementPresentDOM(locator);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	public void clickByJS(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", getElementPresentDOM(locator));
	}
	
	public void scroll(By locator) {
		WebElement element = getElementPresentDOM(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void pause(long miliSeconds) {
		try {
			Thread.sleep(miliSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void waitAlertPresent() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitIFramePresent(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	public void closeDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
	
	private WebDriver initChromeDriver() {
		System.out.println("Chrome driver runing ...");
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		return driver;
	}
	
	private WebDriver initFirefoxDriver() {
		System.out.println("Firefox driver runing ...");
		FirefoxOptions options = new FirefoxOptions();
		System.setProperty("webdriver.firefox.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
		driver = new FirefoxDriver(options);
		return driver;
	}
	
	private WebDriver initMSEdgeDriver() {
		System.out.println("MSEdge driver runing ...");
		EdgeOptions options = new EdgeOptions();
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\driver\\msedgedriver.exe");
		driver = new EdgeDriver(options);
		return driver;
	}
	
	@SuppressWarnings("deprecation")
	public WebDriver setupDriver(String browser) {
		switch (browser.trim().toLowerCase()) {
		case "chrome":
			driver = initChromeDriver();
			break;
		case "firefox":
			driver = initFirefoxDriver();
			break;
		case "edge":
			driver = initMSEdgeDriver();
			break;
		default:
			System.out.println("No browser name was passed");
			driver = initChromeDriver();
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		return driver;
	}
	public String getWeekWithSpecialFormat() {
		// Get calendar set to current date and time
		Calendar c = GregorianCalendar.getInstance();
		// Set the calendar to monday of the current week
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		System.out.println("Current week = " + Calendar.DAY_OF_WEEK);
		// Print dates of the current week starting on Monday
		SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy", Locale.getDefault());
		String startDate = "", endDate = "";
		startDate = df.format(c.getTime());
		c.add(Calendar.DATE, 6);
		endDate = df.format(c.getTime());
		System.out.println("Start Date = " + startDate);
		// cáº¯t chuá»—i endDate Ä‘á»ƒ chá»‰ láº¥y ra ngÃ y
		System.out.println("Day of end Date = " + endDate.subSequence(4, 6));
		String expected = new StringBuilder().append(startDate.substring(0, 6)).append(" - ")
				.append(endDate.subSequence(4, 6))
				.append(startDate.substring(6, 12)).toString();
		System.out.println("Expected weekWithSpecialFormat: " + expected);
		return expected;
	}
}
