package factory;

import org.openqa.selenium.WebDriver;

public class BrowserFactory {
	private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

	public static void setDriver(WebDriver driver) {
		driverThread.set(driver);
	}

	public static WebDriver getDriver() {
		return driverThread.get();
	}

	public static void cleanupDriver() {
		WebDriver driver = driverThread.get();
		if (driver != null) {
			driver.quit();
			driverThread.remove();
		}
	}
}
