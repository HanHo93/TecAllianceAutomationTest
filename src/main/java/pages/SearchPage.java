package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.ActionUtil;
import util.AssertionUtil;
import util.ElementUtil;

public class SearchPage {
	private final WebDriver driver;

	// constructor
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	// ELEMENTS
	private WebElement searchTxt() {
		return ElementUtil.findElementByCssSelector("[name='q']");
	}

	private List<WebElement> resultList() {
		return ElementUtil.findElementListByCssSelector("#rso h3");
	}

	private WebElement nextPage() {
		return ElementUtil.findElementByCssSelector("td[role='heading'] span");
	}

	private WebElement nextPageNumber() {
		return ElementUtil.findElementByCssSelector("#botstuff [role='navigation'] table tr td[class]:not([role]) +td");
	}

	// ACTIONS
	public void inputValueIntoSearchField(String value) {
		ActionUtil.inputText(searchTxt(), value, "Search field");
	}

	public void pressEnter() {
		ActionUtil.pressEnter(searchTxt(), "Search field");
	}

	public List<String> getResultList(List<WebElement> lst) {
		List<String> resultList = new ArrayList<>();
		for (WebElement ele : lst) {
			resultList.add(ele.getText());
		}
		return resultList;
	}

	public void navigateToNextPage() {
		ActionUtil.click(nextPageNumber(), "Next page");
	}

	// ASSERTIONS
	public void verifyPageTitle(String pageTitle) {
		AssertionUtil.verifyEquals(driver.getTitle().trim(), pageTitle, "page title");
	}

	public boolean verifySearchResultContains(String value) {
		for (String i : getResultList(resultList())) {
			if (i.toLowerCase().contains(value.toLowerCase()))
				return true;
			break;
		}
		return false;
	}

	public void verifyAllSearchResult(String value) {
		boolean isNextDisabled = nextPage().getAttribute("style").contains("display:block")
				&& nextPage().getText().contains("Next");
		boolean isFound = false;
		verifySearchResultContains(value);
		while (!isNextDisabled && isFound == false) {
			navigateToNextPage();
			isFound = verifySearchResultContains(value);
			isNextDisabled = nextPage().getAttribute("style").contains("display:block")
					&& nextPage().getText().contains("Next");
		}
	}

}
