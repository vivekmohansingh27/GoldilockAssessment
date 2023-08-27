package com.goldilock;
import java.util.*;

public class Demo {
	
	public static void addEmployee(Scanner sc,HashMap<String,Integer> map) {
		
		
		System.out.println("Enter Name: ");
		String name = sc.next();
		System.out.println("Enter Age: ");
		int age = sc.nextInt();
		
		if(map.containsKey(name)==false) {
			map.put(name, age);
		}else {
			System.out.println("Employee is Already present with same name ");
		}
		
	}
	
	public static void viewAllEmployee(HashMap<String,Integer> map) {
		for(Map.Entry<String,Integer> entry : map.entrySet()) {
			System.out.println("Name   Age");
			System.out.println(entry.getKey()+" "+entry.getValue());
			
		}
	}
	
	public static void searchEmployee(Scanner sc,HashMap<String,Integer> map) {
		
		System.out.println("Enter Name: ");
		String name = sc.next();
		
		if(map.containsKey(name)) {
			System.out.println("Employee is Present with name: "+name +" of Age "+map.get(name));
		}else {
			System.out.println("Employee is Not Present");
		}
	}
	
	public static void main(String args []) {
		
		HashMap<String,Integer> map = new HashMap<>();
		
		Scanner sc = new Scanner(System.in);
		int choice =0;
		
		do {
			
			System.out.println("1 for Add Employee");
			System.out.println("2 for view Employees");
			System.out.println("3 for Search Employee");
			System.out.println("Please Enter Number ");
			choice = sc.nextInt();
			if(choice==1) {
				 addEmployee(sc,map);
			}else if(choice==2) {
				viewAllEmployee(map);
			}else if(choice==3) {
				searchEmployee(sc,map);
			}
			
			
		}while(choice!=0);
		
	}


}
