package util;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class AssertionUtil {
	/**
	 * This class is for handling all kinds of assertions (e.g: assert equal, assert
	 * true, ,...)
	 */
	private static final Logger logger = null;

	public static void verifyEquals(Object actual, Object expected, String item) {
		try {

			Assert.assertEquals("The actual " + item + " is " + actual + ". The expected " + item + " is " + expected,
					expected, actual);
		} catch (AssertionError e) {
			logger.error("[Assert Fail] - The actual " + item + " is " + actual + ". While the expected " + item
					+ " is " + expected);
			Assert.fail();
		}
	}

	public static void verifyTrue(boolean condition, String message) {
		try {
			Assert.assertTrue(condition);
			logger.info(message + " : true");
		} catch (AssertionError e) {
			logger.info(message + " : false");
			Assert.fail();
		}
	}
}
