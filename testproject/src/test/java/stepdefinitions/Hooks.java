package stepdefinitions;

import cucumber.api.java.After;
import testproject.utils.WebDriverController;

public class Hooks {

	@After
	public void tearDownClass() throws Exception {
		WebDriverController.killWebDriver();
	}
}