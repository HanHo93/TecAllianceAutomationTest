package factory;

import util.Constants;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	public static WebDriver getDriverInstance(String browserName) {
		WebDriver driver = null;
		switch (browserName) {
		case Constants.BROWSER_CHROME:
			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		// We can define other browsers here
		}

		if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);
		}
		return driver;
	}
}
