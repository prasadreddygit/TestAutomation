package com.AutomationFramework.UI;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.AutomationFramework.Browser.BrowserManager;

public class UIManager extends BrowserManager {
	private Set<String> windows;

	protected void checkPageIsReady() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();

		if (js.executeScript("return document.readyState").toString().equals("complete")) {

			return;
		}

		for (int i = 0; i < 25; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}

	}

	protected void clickOnAnyElement(String xPath) {
		getDriver().findElement(By.xpath(xPath)).click();
	}

	protected void enterValueIntoTextBox(String xPath, String textValue) {
		getDriver().findElement(By.xpath(xPath)).sendKeys(textValue);
	}

	protected void verifyMessageOnScreen(String Message) {
		getDriver().findElement(By.xpath("//*[contains(text(),'" + Message + "')]")).isDisplayed();
	}

	protected void switchWindow(int index) {
		windows = getDriver().getWindowHandles();
		ArrayList<String> allWindows = new ArrayList<String>(windows);
		for (int i = 0; i < allWindows.size(); i++) {
			if (index == i) {
				getDriver().switchTo().window(allWindows.get(index));
			}
		}

	}

	protected void switchFrame(int index) {

	}

}
