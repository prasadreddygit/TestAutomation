package com.AutomationFramework.Report;

import com.AutomationFramework.Screenshot.ScreenshotManager;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class VideoRecordManager {
	ATUTestRecorder recorder;
	
	private static VideoRecordManager instance = null;
	public static VideoRecordManager getInstace() {
		if (instance == null) {
			instance = new VideoRecordManager();
		}
		return instance;
	}
	public void startRecording() throws ATUTestRecorderException
	{
		String videopath = ScreenshotManager.getInstace().getVideoFolder();
		recorder = new ATUTestRecorder(videopath,"run"+System.currentTimeMillis()+"",false);
        //To start video recording.
		
        recorder.start(); 
	}
	public void stopRecording() throws ATUTestRecorderException
	{
		recorder.stop();
	}
}
