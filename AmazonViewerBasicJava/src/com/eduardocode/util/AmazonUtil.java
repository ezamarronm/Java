package com.eduardocode.util;

import java.util.Scanner;

public class AmazonUtil {
	
	public static int validateUserResponseMenu(int min, int max) {
		//Read user answer
		Scanner sc = new Scanner(System.in);
		
		//To validate answer int
		while(!sc.hasNextInt()) {
			sc.next();
			System.out.println("No ingresaste una opción válida1");
			System.out.println("Intenta otra vez1");
		}
		
		int response = sc.nextInt();
		
		//Validar from 0 to 6
		while(response < min || response > max) {
			//Ask answer again
			System.out.println("No ingresaste una opción válida");
			System.out.println("Intenta otra vez");
			
			while(!sc.hasNextInt()) {
				sc.next();
				System.out.println("No ingresaste una opción válida");
				System.out.println("Intenta otra vez");
			}
			response = sc.nextInt();
		}
		System.out.println("Tu Respuesta fue: " + response + "\n");
		return response;
	}

}
