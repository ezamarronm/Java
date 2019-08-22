package com.eduardocode.util;

import java.util.Scanner;

public class AmazonUtil {
	
	public static int validateUserResponseMenu(int min, int max) {
		//Read user answer
		Scanner sc = new Scanner(System.in);
		
		//To validate answer int
		while(!sc.hasNextInt()) {
			sc.next();
			System.out.println("Please select a valid option");
			System.out.println("Try Again");
		}
		
		int response = sc.nextInt();
		
		//Validar from 0 to 6
		while(response < min || response > max) {
			//Ask answer again
			System.out.println("Please select a valid option");
			System.out.println("Try Again");
			
			while(!sc.hasNextInt()) {
				sc.next();
				System.out.println("Please select a valid option");
				System.out.println("Try Again");
			}
			response = sc.nextInt();
		}
		System.out.println("Your answer was: " + response + "\n");
		return response;
	}

}
