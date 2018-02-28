package com.AutomationFramework.Screenshot;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.AutomationFramework.Browser.BrowserManager;
import com.AutomationFramework.Excel.TestIDSetupManager;

public class ScreenshotManager {
Boolean screenShotFlag=true;
	
	private static ScreenshotManager instance = null;
	File scrFile;
	public String screenShotfolder=null;
	public String htmlFolder=null;
	public String videoFolder=null;
	public static ScreenshotManager getInstace() {
		if (instance == null) {
			instance = new ScreenshotManager();
		}
		return instance;
	}
public void setFlagAsFalse()
{
	screenShotFlag=false;
}
public void setFlagAsTrue()
{
	screenShotFlag=true;
}
	public File take_screenshot() {
		if(screenShotFlag)
		{
		 scrFile = ((TakesScreenshot) BrowserManager.getInstace().getDriver()).getScreenshotAs(OutputType.FILE);
		}
		return scrFile;
	}
	public void setScreenShotFolder()
	{
		String TestID=TestIDSetupManager.getInstace().getTestID();
		screenShotfolder= htmlFolder+"Images//"+TestID+"//";
		
	}
	public String getScreenShotFolder()
	{
		return screenShotfolder;
	}
	public void setHtmlFolder(String htmlFolder)
	{
		this.htmlFolder=htmlFolder;
	}
	public void setVideoFolder()
	{
		String TestID=TestIDSetupManager.getInstace().getTestID();
		File i= new File(htmlFolder+"Videos//"+TestID+"//");
		if (!i.exists()) {
		    System.out.println("creating directory: " + i.getName());
		    i.mkdirs();
		}
		videoFolder= htmlFolder+"Videos//"+TestID+"//";
		
	}
	public String getVideoFolder()
	{
		return videoFolder;
	}
}
