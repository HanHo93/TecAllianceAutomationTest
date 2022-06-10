package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ActionUtil {
	private static final Logger logger = LogManager.getLogger(ActionUtil.class.getName());

	public static void click(WebElement ele, String... eleName) {
		ele.click();
		if (!eleName[0].isEmpty()) {
			logger.info(String.format("Click %s", eleName[0]));
		}
	}

	public static void inputText(WebElement ele, String value, String eleName) {
		ele.clear();
		ele.sendKeys(value);
		String log = String.format("Type %s", value);
		if (!eleName.isEmpty()) {
			log += String.format(" into %s", eleName);
		}
		logger.info(log);
	}

	public static void pressEnter(WebElement ele, String eleName) {
		ele.sendKeys(Keys.ENTER);
		String log = String.format("Press Enter");
		logger.info(log);
	}
}
