package stepdefinitions;

import java.util.Map;
import java.util.Properties;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import testproject.pageObjects.BorrowCalcPage;
import testproject.utils.LoadProperties;

public class HomePageStepDefinition {
	
	BorrowCalcPage page = new BorrowCalcPage();
	Properties config = LoadProperties.getProperties();

	@Given("^I open calculator$")
	public void openBrowser() {
		page.openHomePage(config.getProperty("app.link"));
	}
	
	@Given("^I enter following details$")
	public void input_details(Map<String,String> data) throws Exception {
		page.selectApplicationType(data.get("Application Type"));
		page.selectDependents(data.get("No. of Dependents"));
		page.selectPropertyType(data.get("Property Type"));
		page.inputEarningsAndExpenses("Your income", data.get("Income Before Tax"));
		page.inputEarningsAndExpenses("Your other income", data.get("Other Income"));
		page.inputEarningsAndExpenses("Living expenses", data.get("Living Expenses"));
		page.inputEarningsAndExpenses("Current home loan", data.get("Current Home Loan"));
		page.inputEarningsAndExpenses("Other loan", data.get("Other Loan"));
		page.inputEarningsAndExpenses("Other commitments", data.get("Other Commitments"));
		page.inputEarningsAndExpenses("credit card limits", data.get("Credit Card Limits"));
	}
	
	@Given("^I click on Work out how much I could borrow button$")
	public void clickOnBorrowButton() {
		page.clickOnBorrowBtn();
	}
	
	@Given("^borrowing estimate should be \"([^\"]*)\"$")
	public void clickOnBorrowButton(String estimate) {
		Assert.assertEquals(page.getBorrowAmnt(), estimate);
	}
	
	@Given("^I click on start over$")
	public void clickOnStartOverButton() {
		page.clickOnStartOverBtn();
	}
	
	@Given("^all the fileds in the forms get cleared$")
	public void verifyFormIsCleared() {
		Assert.assertTrue(page.isApplicationTypeSingleSelected());
		Assert.assertEquals(page.getSelectedDependents(), "0");
		Assert.assertTrue(page.isPropertyTypeHomeSelected());
		Assert.assertEquals(page.getValueEarningsAndExpenses("Your income"), "0");
		Assert.assertEquals(page.getValueEarningsAndExpenses("Your other income"), "0");
		Assert.assertEquals(page.getValueEarningsAndExpenses("Living expenses"), "0");
		Assert.assertEquals(page.getValueEarningsAndExpenses("Current home loan"), "0");
		Assert.assertEquals(page.getValueEarningsAndExpenses("Other loan"), "0");
		Assert.assertEquals(page.getValueEarningsAndExpenses("Other commitments"), "0");
		Assert.assertEquals(page.getValueEarningsAndExpenses("credit card limits"), "0");
	}
	
	@Given("^I enter Living expenses as \"([^\"]*)\"$")
	public void enterLivingExpenses(String livingExpenses) {
		page.inputEarningsAndExpenses("Living expenses", livingExpenses);
	}
	
	@Given("^an error message \"([^\"]*)\" is displayed$")
	public void verifyErrorMessage(String expectedMsg) {
		Assert.assertEquals(expectedMsg.trim(), page.getErrorMessage().trim());
	}
}
