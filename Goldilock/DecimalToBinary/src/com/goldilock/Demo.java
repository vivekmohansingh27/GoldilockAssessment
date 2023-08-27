package com.goldilock;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
	
		
		Scanner sc = new Scanner(System.in);
		try {
			StringBuilder sb = new StringBuilder();
			System.out.println("Enter Number");
			String s = sc.next();
			Integer num = Integer.parseInt(s);
			while(num > 0){
				int n = num%2;
				sb.append(n);
				num=num/2;
			}
			
			sb.reverse();
			System.out.println(sb.toString());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
