package com.goldilock;
import java.util.*;
public class Demo {
	 public static void main(String[] args) {
	        
	        Scanner sc = new Scanner(System.in);

	        
	        while (sc.hasNextLine()) {
	            String input = sc.nextLine();
	            System.out.println("Recieved Command-line Input: "+input);
	        }

	        
	        sc.close();
	        
	    }
}
