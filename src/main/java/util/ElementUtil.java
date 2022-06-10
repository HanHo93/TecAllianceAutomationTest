package util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {
	private static WebDriver driver;

	public static void initDriver(WebDriver browserDriver) {
		driver = browserDriver;
	}

	public static WebElement findElementByCssSelector(String selector) {
		return driver.findElement(By.cssSelector(selector));
	}

	public static List<WebElement> findElementListByCssSelector(String selector) {
		return driver.findElements(By.cssSelector(selector));
	}

	/**
	 * we can define other element finders here: find element by xPath,id, , class,
	 * text,...
	 */
}
