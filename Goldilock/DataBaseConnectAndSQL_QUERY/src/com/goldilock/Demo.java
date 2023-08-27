package com.goldilock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo {
	public static void insertEmployee(Scanner sc) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/goldilock","root","root");
			
			
			System.out.println("Enter Name: ");
			String name = sc.next();
			
			System.out.println("Enter Age: ");
			int age = sc.nextInt();
			String quuey = "Insert into test values('"+name+"',"+age+")";
			
			Statement st = conn.createStatement();
			
			int rs = st.executeUpdate(quuey);

			if(rs>0) {
				System.out.println("Employee is Added");
			}else {
				System.out.println("Employee Not Added");
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void viewEmployee() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/goldilock","root","root");
			
			
			
			Statement st = conn.createStatement();
			String quuey = "Select * from test";
			ResultSet rs = st.executeQuery(quuey);
			
			
			// HASHMAP
			Map<String,Integer> map = new HashMap<>();
			if(!rs.isBeforeFirst() && rs.getRow()==0) {
				System.out.println("No Data Found");
			}else {
				while(rs.next()) {
					System.out.println("Name "+rs.getString(1)+" Age "+ rs.getInt(2));
				
				map.put(rs.getString(1), rs.getInt(2));
				}
			}
			System.out.println(map);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void searchEmployees() throws ClassNotFoundException,SQLException {
		
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/goldilock","root","root");
		
			Statement st = conn.createStatement();
			//SQL QUERY
			String quuey = "Select * from test where empAge < 30 and empName like 's%'";
			 
			ResultSet rs = st.executeQuery(quuey);
			if(!rs.isBeforeFirst() && rs.getRow()==0) {
				System.out.println("No Data Found");
			}else {
				while(rs.next()) {
					System.out.println("Name "+rs.getString(1)+" Age "+ rs.getInt(2));	
				
				}
			}
		
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	} 
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Scanner sc = new Scanner(System.in);
		int choice =0;
		
		do {
			
			System.out.println("1 for Add Employee");
			System.out.println("2 for view Employees");
			System.out.println("3 for search Employees");
			System.out.println("Please Enter Number ");
			choice = sc.nextInt();
			if(choice==1) {
				insertEmployee(sc);
			}else if(choice==2) {
				viewEmployee();
			}else if(choice==3) {
				searchEmployees();
			}
			
			
		}while(choice!=0);
	}
}
