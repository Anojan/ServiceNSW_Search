package com.sample.serviceNSW.tests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.sample.serviceNSW.helper.ScreenshotHelper;
import com.sample.serviceNSW.pageObjects.ServiceNSWPageObjects;

/**
 * @author anoasw
 *
 */
public class ServiceNSWTest extends ServiceNSWPageObjects {

	public RemoteWebDriver driver;
	Properties propertyObj;

	@Before
	public void loadBrowser() throws MalformedURLException {
		String browser = TestRunner.browserOri;
		propertyObj = readPropertyFile();
		String Node = propertyObj.getProperty("node");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(new URL(Node), cap);
		} else if (browser.equalsIgnoreCase("firefox")) {
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			driver = new RemoteWebDriver(new URL(Node), cap);
		}

		driver.get(propertyObj.getProperty("url"));
	}

	@Given("^ServiceNSW Page is Loaded$")
	public void servicensw_Page_is_Loaded() {
		Assert.assertEquals("The page title should have the ServiceNSW title at the start of the test.",
				propertyObj.getProperty("title"), driver.getTitle());
	}

	@When("^Search Product \"([^\"]*)\"$")
	public void search_Product(String productName) throws Throwable {
		enterSearchText(driver, productName);
		clickSearchButton(driver);

	}

	@Then("^navigate to apply page$")
	public void navigate_to_apply_page() throws Throwable {
		selectFromList(driver);
		Assert.assertEquals("The page title should have the Apply for number plate title at the start of the test.",
				propertyObj.getProperty("secondTitle"), driver.getTitle());
	}
	
	@When("^click Find Location tab$")
	public void click_Find_Location_tab() {
		clickFindLocationTab(driver);
	}

	@Then("^navigate to find serviceNSW location page$")
	public void navigate_to_find_serviceNSW_location_page() {
		Assert.assertEquals("The page title should have the Find Service NSW location title at the start of the test.",
				propertyObj.getProperty("thirdTitle"), driver.getTitle());
	}

	@When("^search for \"([^\"]*)\"$")
	public void search_for(String arg1) {
		enterSuburbText(driver, arg1);

	}

	@Then("^\"([^\"]*)\" is available in the results$")
	public void is_available_in_the_results(String centre) throws Throwable {
		verifyItemsAvailable(driver, centre);
	}

	@After
	public void tearDown() throws IOException {
		String fileName = new SimpleDateFormat("yyyyMMddHHmm'.png'").format(new Date());
		ScreenshotHelper.saveScreenshot(fileName, driver);
		driver.quit();
	}

	private Properties readPropertyFile() {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("src/main/resources/properties/config.properties");
			// load a properties file
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	}

}
