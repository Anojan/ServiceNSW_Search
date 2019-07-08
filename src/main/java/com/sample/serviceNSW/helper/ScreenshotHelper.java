package com.sample.serviceNSW.helper;


	import java.io.File;
	import java.io.IOException;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;

	/**
	 * @author anoasw
	 * 
	 */
	public class ScreenshotHelper {

		/**
		 * @param screenshotFileName
		 * @param driver
		 * @throws IOException
		 *             This method will capture the screenshot of the output
		 */
		public static void saveScreenshot(String screenshotFileName,
				WebDriver driver) throws IOException {
			File screenshot = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(screenshotFileName));

		}
	}

