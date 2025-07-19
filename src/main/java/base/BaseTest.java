package base;

import java.lang.reflect.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import factory.DriverFactory;
import factory.BrowserFactory;
import utilities.ConfigReader;

public class BaseTest {
	protected WebDriver driver;
	private static final Logger log = LogManager.getLogger(BaseTest.class);

	@BeforeMethod
	public void setUp(Method method) {
		String browser = ConfigReader.getValue("QA", "browser");
		String url = ConfigReader.getValue("QA", "url");
		String logFileName = method.getName();
		ThreadContext.put("logFileName", logFileName);
		driver = DriverFactory.initializeDriver(browser);
		BrowserFactory.setDriver(driver);
		log.info("Navigated to url: " + url);
		driver.get(url);
	}

	@AfterMethod
	public void tearDown() {
		BrowserFactory.cleanupDriver();
		ThreadContext.clearAll();
	}

	public WebDriver getDriver() {
		return BrowserFactory.getDriver();
	}
}