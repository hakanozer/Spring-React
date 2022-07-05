package com.iea.oracle.hr.employees.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main 
{

	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_PASSWORD = "hr";	
	private static final String DB_USER = "hr";

	public static void main(String[] args) 
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try 
		{
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery("SELECT * FROM EMPLOYEES");

			List<Employee> employeeList = new ArrayList<Employee>();
			while (resultSet.next()) 
			{		
				employeeList.add( varlikOlustur(resultSet) );
				
			}
			
			for (int i = 0; i < employeeList.size(); i++) 
			{
				System.out.println((i+1) + "'inci eleman: " + employeeList.get(i));
			}
			
		} 
		catch (SQLException e) 
		{
			System.out.println("Ýstisna mesajý: " + e.getMessage());
		}
		finally 
		{
			if(connection != null)
			{
				try 
				{
					connection.close();
				} 
				catch (SQLException e) 
				{
					System.out.println("Ýstisna mesajý: " + e.getMessage());
				}
			}
		}
	}

	private static Employee varlikOlustur(ResultSet resultSet) throws SQLException 
	{
		int employeeID = resultSet.getInt(EmployeesColumnName.EMPLOYEE_ID.toString());
		String firstName = resultSet.getString(EmployeesColumnName.FIRST_NAME.toString());
		String lastName = resultSet.getString(EmployeesColumnName.LAST_NAME.toString());
		double salary = resultSet.getDouble(EmployeesColumnName.SALARY.toString());
		
		return new Employee(employeeID, firstName, lastName, salary);
	}

}
