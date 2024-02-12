package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Product;
import services.CalculationService;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
	
		List<Product> list = new ArrayList<>();
				
		try (BufferedReader br = new BufferedReader(new FileReader("C://KevDev//in.txt"))){
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}
			
			Product p = CalculationService.max(list);
			System.out.println("Most expensive: " + p);
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		scan.close();
	}
}
