package automation.testsuite;

import static org.testng.Assert.*;

import org.testng.annotations.*;
import automation.common.CommonBase;
import automation.constant.Constant;
import automation.page.LoginPage;

public class test extends CommonBase{
	int nextClickCount = 0;
	int prevClickCount = 0;
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
	@Test(priority = 2)
	public void NextAndPrevMonth() throws InterruptedException {
		//login
		LoginPage login = new LoginPage(driver);
		login.LoginFuntion(Constant.EMAIL, Constant.PASSWORD);
		
		
////////Click để vào trang events
		click(By.xpath("//span[text()='Events']"));
		//kiểm tra trang event đã hiển thị chưa
		isElementPresent(By.id("event-calendar"));
	
 /////// CLICK VÀO BUTTON MONTH VÀ KIỂM TRA SỰ KIỆN MỚI /////////////////////
		click(By.xpath("//button[text()='month']"));
        // Thực hiện 5 lần click "Next"
        for (int i = 1; i <= 5; i++) {
            click(By.xpath("//span[@class='fc-icon fc-icon-chevron-right']"));
			nextClickCount++;
            Thread.sleep(1000);
        }
    	
    	// Thực hiện 3 lần click "Previous"
        for (int i = 1; i <= 3; i++) {
            click(By.xpath("//span[@class='fc-icon fc-icon-chevron-left']"));
            prevClickCount++;
            Thread.sleep(1000);
        }   
        
  /////// CLICK VÀO BUTTON WEEK VÀ KIỂM TRA SỰ KIỆN MỚI /////////////////////
 		click(By.xpath("//button[text()='week']"));
 	// Thực hiện 5 lần click "Next"
 		for (int i = 1; i <= 5; i++) {
 			click(By.xpath("//span[@class='fc-icon fc-icon-chevron-right']"));
 			nextClickCount++;
 			Thread.sleep(1000);
 		}
 		
 		// Thực hiện 3 lần click "Previous"
 		for (int i = 1; i <= 3; i++) {
 			click(By.xpath("//span[@class='fc-icon fc-icon-chevron-left']"));
 			prevClickCount++;
 			Thread.sleep(1000);
 		} 
        
  /////// CLICK VÀO BUTTON DAY VÀ KIỂM TRA SỰ KIỆN MỚI /////////////////////
     		click(By.xpath("//button[text()='day']"));
     	// Thực hiện 5 lần click "Next"
     		for (int i = 1; i <= 5; i++) {
     			click(By.xpath("//span[@class='fc-icon fc-icon-chevron-right']"));
     			nextClickCount++;
     			Thread.sleep(1000);
     		}
     		
     		// Thực hiện 3 lần click "Previous"
     		for (int i = 1; i <= 3; i++) {
     			click(By.xpath("//span[@class='fc-icon fc-icon-chevron-left']"));
     			prevClickCount++;
     			Thread.sleep(1000);
     		}   
		}

	@AfterMethod
	public void closeChrome() {
		closeDriver();
	}
}
