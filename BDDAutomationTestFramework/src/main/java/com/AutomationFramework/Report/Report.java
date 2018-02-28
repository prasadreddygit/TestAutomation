package com.AutomationFramework.Report;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

import org.apache.commons.io.FileUtils;

import gherkin.formatter.Formatter;
import gherkin.formatter.Reporter;
import gherkin.formatter.model.Background;
import gherkin.formatter.model.Examples;
import gherkin.formatter.model.Feature;
import gherkin.formatter.model.Match;
import gherkin.formatter.model.Result;
import gherkin.formatter.model.Scenario;
import gherkin.formatter.model.ScenarioOutline;
import gherkin.formatter.model.Step;

import com.AutomationFramework.Screenshot.ScreenshotManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Report implements Reporter, Formatter {
	String Reportpath;
	String extentReportImage;
	LinkedList<Step> Stepss = new LinkedList<Step>();
	// ArrayList<Step>Stepss=new ArrayList<Step>();
	ExtentReports extent;
	ExtentTest extentTest;
	ExtentTest parent;
	int counter = 0;
	File scrFile;

	public static void start() {

	}

	public static void closereport() {

	}

	public void background(Background arg0) {
		// TODO Auto-generated method stub

	}

	public void close() {
		// TODO Auto-generated method stub

	}

	public void done() {
		// TODO Auto-generated method stub

	}

	public void endOfScenarioLifeCycle(Scenario arg0) {
		parent.appendChild(extentTest);
		extent.endTest(extentTest);

		// writing everything to document.
		extent.flush();
		counter = 0;

	}

	public void eof() {
		// TODO Auto-generated method stub

	}

	public void examples(Examples arg0) {
		// TODO Auto-generated method stub

	}

	public void feature(Feature arg0) {
			Reportpath = System.getProperty("user.dir")+"//Reports//" +"Run"+ System.currentTimeMillis()+"//";
		ScreenshotManager.getInstace().setHtmlFolder(Reportpath);
		System.out.println(Reportpath);
		String extentReportFile = Reportpath + "extentReportFile.html";
		
		extent = new ExtentReports(extentReportFile, false);
		extent.addSystemInfo("Host Name", "SoftwareTestingMaterial").addSystemInfo("Environment", "Automation Testing")
				.addSystemInfo("User Name", "prasad goguri");
		// loading the external xml file (i.e., extent-config.xml) which was placed
		// under the base directory
		// You could find the xml file below. Create xml file in your project and copy
		// past the code mentioned below
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		parent = extent.startTest(arg0.getName());

	}

	public void scenario(Scenario arg0) {
		// TODO Auto-generated method stub
		extentTest = extent.startTest(arg0.getName(), arg0.getKeyword());
	}

	public void scenarioOutline(ScenarioOutline arg0) {
		// TODO Auto-generated method stub

	}

	public void startOfScenarioLifeCycle(Scenario arg0) {

	}

	public void step(Step step) {
		// TODO Auto-generated method stub

		Stepss.add(step);
	}

	public void syntaxError(String arg0, String arg1, List<String> arg2, String arg3, Integer arg4) {
		// TODO Auto-generated method stub

	}

	public void uri(String arg0) {
		// TODO Auto-generated method stub

	}

	public void after(Match arg0, Result arg1) {
		// TODO Auto-generated method stub

	}

	public void before(Match arg0, Result arg1) {
		// TODO Auto-generated method stub

	}

	public void embedding(String arg0, byte[] arg1) {
		// TODO Auto-generated method stub

	}

	public void match(Match arg0) {
		// TODO Auto-generated method stub

	}

	public void result(Result result) {

		// TODO Auto-generated method stub

		// Now you can do whatever you need to do with it, for example copy somewhere
		extentReportImage = ScreenshotManager.getInstace().getScreenShotFolder();
		counter = counter + 1;
		Step step1 = Stepss.poll();
		try {
			scrFile = ScreenshotManager.getInstace().take_screenshot();
			if (scrFile != null) {
				FileUtils.copyFile(scrFile, new File(extentReportImage+ counter + ".png"));
				System.out.println(extentReportImage+ counter + ".png");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (scrFile != null) {
			if ("passed".equals(result.getStatus())) {
				extentTest.log(LogStatus.PASS, step1.getKeyword() + step1.getName(),
						extentTest.addScreenCapture(extentReportImage+ counter + ".png"));
			}
		} else {
			if ("passed".equals(result.getStatus()))
				extentTest.log(LogStatus.PASS, step1.getKeyword() + step1.getName(), "No screebshot");

		}
		ScreenshotManager.getInstace().setFlagAsTrue();

	}

	public void write(String arg0) {
		// TODO Auto-generated method stub

	}

}
