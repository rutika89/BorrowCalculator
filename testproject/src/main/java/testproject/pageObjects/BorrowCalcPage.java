package testproject.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BorrowCalcPage extends BasePage{
	
	@FindBy(id = "application_type_single")
	WebElement application_type_single;
	
	@FindBy(id = "application_type_joint")
	WebElement application_type_joint;
	
	@FindBy(xpath = "//select[@title='Number of dependants']")
	WebElement dependentsDrpDwn;
	
	@FindBy(id="borrow_type_home")
	WebElement propertyTypeHome;

	@FindBy(id="borrow_type_investment")
	WebElement propertyTypeInvestment;
	
	@FindBy(css = ".btn--borrow__calculate")
	WebElement borrow_btn;
	
	@FindBy(css = "button.start-over")
	WebElement startOver_btn;
	
	@FindBy(css = ".borrow__result__text__amount")
	WebElement borrwoAmnt;
	
	@FindBy(css = ".borrow__error__text")
	WebElement borrowErrorMsg; 
	
	public BorrowCalcPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAppTypeSingle() {
		application_type_single.click();
	}

	public void clickOnBorrowBtn() {
		actions.moveToElement(borrow_btn).perform();
		borrow_btn.click();
	}
	
	public void clickOnStartOverBtn() {
		startOver_btn.click();
	}
	
	public String getBorrowAmnt() {
		sleep();
		wait.until(ExpectedConditions.visibilityOf(borrwoAmnt));
		wait.until(ExpectedConditions.invisibilityOf(borrow_btn));
		return borrwoAmnt.getText();
	}
	
	public void selectApplicationType(String applicationType) throws Exception {
		if (applicationType.equalsIgnoreCase("Single")) {
			clickOnElement(application_type_single);
		}
		else if (applicationType.equalsIgnoreCase("Joint")) {
			clickOnElement(application_type_joint);
		}
		else {
			throw new Exception("Invalid Application Type");
		}
	}
	
	public void selectDependents(String noOfDependents) {
		selectDropDownOption(dependentsDrpDwn, noOfDependents);
	}
	
	public void selectPropertyType(String propertyType) {
		if(propertyType.equalsIgnoreCase("Home to live in")) {
			clickOnElement(propertyTypeHome);
		}
		else if(propertyType.equalsIgnoreCase("Residential investment")) {
			clickOnElement(propertyTypeInvestment);
		}
	}
	
	public void inputEarningsAndExpenses(String type, String value) {
		WebElement elem = driver.findElement(By.xpath("//label[contains(text(),'"+type+"')]/following-sibling::div/input"));
		elem.sendKeys(value);
	}
	
	public String getErrorMessage() {
		return borrowErrorMsg.getText();
	}
	
	public boolean isApplicationTypeSingleSelected() {
		return isChecked(application_type_single);
	}
	
	public boolean isPropertyTypeHomeSelected() {
		return isChecked(propertyTypeHome);
	}
	
	public String getSelectedDependents() {
		return getSelectedDropDownOption(dependentsDrpDwn);
	}
	
	public String getValueEarningsAndExpenses(String type) {
		WebElement elem = driver.findElement(By.xpath("//label[contains(text(),'"+type+"')]/following-sibling::div/input"));
		return getCurrentValue(elem);
	}
}
