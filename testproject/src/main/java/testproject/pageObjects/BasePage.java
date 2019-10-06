package testproject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testproject.utils.WebDriverController;

public class BasePage {

	protected static WebDriver driver = WebDriverController.getDriver();
	public final WebDriverWait wait = new WebDriverWait(driver, 20);
	public Actions actions = new Actions(driver);
	
	
	public void openHomePage(String url) {
		driver.get(url);
	}
	
	public void selectDropDownOption(WebElement elem, String option) {
		Select select = new Select(elem);
		select.selectByVisibleText(option);
	}
	
	public String getSelectedDropDownOption(WebElement elem) {
		Select select = new Select(elem);
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isChecked(WebElement elem) {
		return elem.isSelected();
	}
	
	public void clickOnElement(WebElement elem) {
		elem.click();
	}
	
	public String getCurrentValue(WebElement elem) {
		return elem.getAttribute("value");
	}
	
	public void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
