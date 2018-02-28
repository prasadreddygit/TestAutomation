package com.AutomationFramework.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URL;
public class BS {

	public static final String USERNAME = "prasad211";
	  public static final String AUTOMATE_KEY = "7gpJRGz8s1S77Roz23aZ";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	  public static void main(String[] args) throws Exception {

	   /* DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browserName", "iPhone");
	    caps.setCapability("device", "iPhone 7");
	    caps.setCapability("realMobile", "true");
	    caps.setCapability("os_version", "10.3");

	    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
	    driver.get("http://www.google.com");
	    WebElement element = driver.findElement(By.name("q"));

	    element.sendKeys("BrowserStack");
	    element.submit();

	    System.out.println(driver.getTitle());
	    driver.quit();*/
		  
		  File i= new File("E:\\SpringWorkspace\\AutomationFramework\\Reports\\Run1519836874913\\Videos\\Test1");
			if (!i.exists()) {
			    System.out.println("creating directory: " + i.getName());
			    i.mkdirs();
			}

}
}
