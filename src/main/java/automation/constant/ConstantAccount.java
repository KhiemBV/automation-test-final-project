package automation.constant;

import org.openqa.selenium.By;

public class ConstantAccount {
	public static String RISE_URL = "https://rise.fairsketch.com/signin";
	public static By TEXT_EMAIL = By.id("email");
	public static By TEXT_PASSWORD = By.id("password");
	public static By BUTTON_SIGNIN = By.xpath("//button[text()='Sign in']");
	public static By DASHBOARD_TEXT = By.xpath("//span[normalize-space()='Dashboard']");
	public static By AUTHENICATION_ALERT = By.xpath("//div[normalize-space()='Authentication failed!']");
	public static By BUTTON_LOGOUT = By.xpath("//li[normalize-space()='Sign Out']");
	public static By USER_AVATAR = By.id("user-dropdown");
	public static By ADD_CLIENT_BOARD = By.id("ajaxModalContent");
	
	public static String ALADA_URL = "https://alada.vn/";
	public static By ALADA_USER_AVATAR = By.xpath("//li[@id='showsub']");

	public static String TRIZEN_URL = "https://techydevs.com/demos/themes/html/trizen-demo/trizen/index.html";
	public static By SEARCH_RESULT = By.xpath("//h2[text()='Flight Search Result']");
}
