package com.sample.serviceNSW.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

public class ServiceNSWPageObjects {

	WebElement searchTextBox;
	WebElement searchButton;
	WebElement searchResult;
	WebElement locateUsButton;
	WebElement suburbTextBox;
	String itemName;

	public void enterSearchText(WebDriver driver, String searchText) {
		searchTextBox = driver.findElement(By.cssSelector("#homeAutosuggest > input"));
		if (searchTextBox.isDisplayed()) {
			System.out.println("The searchbox is found");
			searchTextBox.click();
			searchTextBox.sendKeys(searchText);
		} else {
			System.out.println("The search Box is not found");
		}
	}

	/**
	 * @param driver
	 *            Method to click search button
	 */
	public void clickSearchButton(WebDriver driver) {
		searchButton = driver.findElement(By.cssSelector(
				"#block-content > div > header > div.container > div > form > div.form__actions > button"));
		if (searchButton.isDisplayed()) {
			searchButton.click();
		}
	}

	public void selectFromList(WebDriver driver) {
		searchResult = driver.findElement(By.cssSelector("#search > div > div > div:nth-child(2) > h3 > a"));
		itemName = searchResult.getText();
		System.out.println("Item Name:" + itemName);
		searchResult.click();
	}

	public void clickFindLocationTab(WebDriver driver) {
		locateUsButton = driver
				.findElement(By.cssSelector("#block-global-header-menu > div > ul > li:nth-child(3) > a"));
		locateUsButton.click();
	}

	public void enterSuburbText(WebDriver driver, String suburbText) {
		suburbTextBox = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.elementToBeClickable(By.id("#locatorTextSearch")));
		if (searchTextBox.isDisplayed()) {
			System.out.println("The searchbox is found");
			searchTextBox.click();
			searchTextBox.sendKeys(suburbText);
		} else {
			System.out.println("The search Box is not found");
		}
	}

	public void verifyItemsAvailable(WebDriver driver, String centreName) {
		boolean item1Available = driver.findElement(By.xpath("//a[contains(text(),'" + centreName + "')]"))
				.isDisplayed();
		Assert.assertTrue(item1Available);

	}

}
