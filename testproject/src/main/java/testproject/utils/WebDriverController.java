package testproject.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverController {

	public static WebDriverController instance = new WebDriverController();
	public WebDriver driver;
	
	private WebDriverController() {
		WebDriverManager.chromedriver().version("77.0.3865.40").setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public static WebDriverController getWebDriverControllerInstance() {
		if(instance == null) {
			instance = new WebDriverController();
		}
		return instance;
	}
	
	public static WebDriver getDriver() {
		return getWebDriverControllerInstance().driver;
	}
	
	public static void killWebDriver() {
		getWebDriverControllerInstance().driver.quit();
	}
	
}
