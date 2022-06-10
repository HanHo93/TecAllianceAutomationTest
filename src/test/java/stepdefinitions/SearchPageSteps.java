package stepdefinitions;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import pages.SearchPage;
import util.ConfigReader;
import util.ElementUtil;

public class SearchPageSteps extends Steps {
	private SearchPage searchPage;
	private WebDriver driver;
	Properties prop;

	@BeforeStories
	public void beforeScenario() throws FileNotFoundException {
		ConfigReader config = new ConfigReader();
		prop = config.init();
		driver = DriverFactory.getDriverInstance(prop.getProperty("browser"));
		driver.get(prop.getProperty("site_url"));
		searchPage = new SearchPage(driver);
		ElementUtil.initDriver(driver);
	}

	@Given("user is on Google home page")
	public void givenUserIsOnGoogleHomePage() {
		searchPage.verifyPageTitle("Google");
	}

	@When("searching for the keyword $keyword")
	public void performsearching(String keyword) {
		searchPage.inputValueIntoSearchField(keyword);
		searchPage.pressEnter();
	}

	@Then("results include the string $value")
	public void verifySearchResultsContain(String value) {
		searchPage.verifyAllSearchResult(value);
	}

	@AfterStories
	public void afterScenario() {
		driver.quit();
	}
}
