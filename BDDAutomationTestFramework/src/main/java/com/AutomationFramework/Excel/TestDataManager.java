package com.AutomationFramework.Excel;

import java.util.LinkedHashMap;

public class TestDataManager {

private static TestDataManager instance = null;
	
	public static TestDataManager getInstace() {
		if (instance == null) {
			instance = new TestDataManager();
		}
		return instance;
	}
	public String getData(String Value)
	{
		if(Value.startsWith("#"))
		{
			Value=Value.substring(1, Value.length());
			//System.out.println(TestIDSetupManager.getInstace().getTestID());
			//System.out.println(ExcelManager.getInstace().getTestData().get(TestIDSetupManager.getInstace().getTestID()).get(Value));
			String TestID=TestIDSetupManager.getInstace().getTestID();
			LinkedHashMap<String,String> TestRow=ExcelManager.getInstace().getTestData().get(TestID);
			 return TestRow.get(Value);
		}
		else
		{
			return Value;
		}
	}

}
