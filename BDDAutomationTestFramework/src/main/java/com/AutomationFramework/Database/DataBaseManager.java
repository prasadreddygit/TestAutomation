package com.AutomationFramework.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


public class DataBaseManager {
	Connection con;
	Statement stmt;
	ResultSet rs;
	ResultSetMetaData rsmd;
	private static DataBaseManager instance = null;
	public void connectToMySQL(String userName,String Password,String dataBase) throws Exception
	{
		
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/"+dataBase+"",userName,Password);  
		//here sonoo is database name, root is username and password  
		stmt=con.createStatement();  
		
	}
	public void verifyColumnsValues(String tableName,String columnsNames,String columnsValues,String whereColumnNames, String whereColumnsValues) throws Exception
	{
		
		System.out.println("select "+columnsNames+" from "+tableName+" where "+whereColumnNames+"='"+whereColumnsValues+"'");
		rs=stmt.executeQuery("select"+columnsNames+" from "+tableName+" where "+whereColumnNames+"='"+whereColumnsValues+"'");
		rsmd = rs.getMetaData();
	    int NumOfCol=0;
	    NumOfCol=rsmd.getColumnCount();
	    System.out.println("Query Executed!! No of Colm="+NumOfCol);
		while(rs.next()) 
		{
			for(int i=1;i<=NumOfCol;i++)
			{
				System.out.print(rs.getObject(i)+"  ");
				
			}
		System.out.println();
		}
		 
		 
	}
	public static DataBaseManager getInstace() {
		if (instance == null) {
			instance = new DataBaseManager();
		}
		return instance;
	}
	public static void main(String[] args) throws Exception {
		DataBaseManager obj = new DataBaseManager();
		obj.connectToMySQL("root", "Prasad123", "world");
		obj.verifyColumnsValues("city","*", "", "CountryCode", "IND");
		
		
		
	}
}

