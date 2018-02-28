package com.AutomationFramework.GherkinImplementaion;

import com.AutomationFramework.Excel.ExcelManager;
import com.AutomationFramework.Excel.TestDataManager;
import com.AutomationFramework.Excel.TestIDSetupManager;
import com.AutomationFramework.Report.Report;
import com.AutomationFramework.Report.VideoRecordManager;
import com.AutomationFramework.Screenshot.ScreenshotManager;
import com.AutomationFramework.UI.UIManager;

import atu.testrecorder.exceptions.ATUTestRecorderException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class StepDefinationManager extends UIManager{
	@Given("^user open Browser$")
	public void user_open_Browser() throws Throwable {

		openBrowser();
		VideoRecordManager.getInstace().startRecording();
		
	}
	
	@And("^user open Application \"([^\"]*)\"$")
	public void user_open_Application(String URL) throws Throwable {
		URL=TestDataManager.getInstace().getData(URL);

		getDriver().get(URL);
		//System.out.println(driver.getPageSource());
	}
	
	@And("^user wait for page load$")
	public void user_wait_for_page_load() throws Throwable {

		checkPageIsReady();
	}
	@Given("^user read Test data from Excel file$")
	public void user_read_Test_data_from_Excel_file() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ScreenshotManager.getInstace().setFlagAsFalse();
		ExcelManager.getInstace().setTestData();
		
	}
	@Given("^user set test id \"([^\"]*)\"$")
	public void user_set_test_id(String testID) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		/*Screenshot.getInstace().setFlagAsFalse();
	   */
		ScreenshotManager.getInstace().setFlagAsFalse();
		TestIDSetupManager.getInstace().setTestID(testID);
		ScreenshotManager.getInstace().setScreenShotFolder();
		ScreenshotManager.getInstace().setVideoFolder();
		Report.start();
	}
	@Given("^user enter text \"([^\"]*)\"into text box \"([^\"]*)\"$")
	public void user_enter_text_into_text_box(String value, String Xpath) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		String Text= TestDataManager.getInstace().getData(value);
	    enterValueIntoTextBox(Xpath, Text);
	}
	@And("^user click on button \"([^\"]*)\"$")
	public void user_click_on_button(String xpath) throws Throwable {
	   
	    clickOnAnyElement(xpath);
	}
@Before
	public void user_start_video_recording() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		Report.start();
	}
	
	@Given("^user add two numbers \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_add_two_numbers_and(int arg1, int arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println(arg1+arg2);
	}


	@After
	public void close() throws ATUTestRecorderException {
		//Report.closereport();
		VideoRecordManager.getInstace().stopRecording();
		closeBrowser();
		
		
	}
	
	
	
}
