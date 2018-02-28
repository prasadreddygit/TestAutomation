package com.AutomationFramework.Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserManager {
	protected static WebDriver driver;
	private static BrowserManager instance = null;
    	
	public WebDriver getDriver() {
		return driver;
	}
	public static BrowserManager getInstace() {
		if (instance == null) {
			instance = new BrowserManager();
		}
		return instance;
	}
	public void openBrowser() {
		if (System.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("DriverLocation")+"chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		} else if (System.getProperty("Browser").equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("DriverLocation")+"");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (System.getProperty("Browser").equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("DriverLocation"));
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		} else if (System.getProperty("Browser").equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("DriverLocation")+"MicrosoftWebDriver");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}

	}
	public void closeBrowser()
	{
		driver.quit();
	}
	
}
