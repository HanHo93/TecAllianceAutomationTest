package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	private Properties prop;

	public Properties init() throws FileNotFoundException {
		prop = new Properties();
		final InputStream inputStream;
		inputStream = new FileInputStream("./src/test/resources/config/config.properties");
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
