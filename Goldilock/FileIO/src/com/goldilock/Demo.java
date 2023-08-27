package com.goldilock;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo {
	public static void main(String[] args) {
        String inputFileName = "input.csv";
        String outputFileName = "output.csv";

        try {
        	FileReader file = new FileReader(inputFileName);
            BufferedReader reader = new BufferedReader(file);
            FileWriter writer = new FileWriter(outputFileName);

            
            writer.write("Number1,Number2,Number3,Sum\n");

            String line;
            while ((line = reader.readLine()) != null) {
                String[] numbers = line.split(",");
                int sum = 0;

                for (String num : numbers) {
                    double numValue = Double.parseDouble(num);
                    writer.write(num + ","); 
                    sum += numValue; 
                }

                writer.write(sum + "\n"); 
            }

            reader.close();
            writer.close();
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
