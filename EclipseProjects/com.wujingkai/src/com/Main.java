package com;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
	public static void main(String[] args) {
		// JDK 1.7
		Scanner sc = new Scanner(System.in);
		try {			
			byte select = sc.nextByte();
			System.out.println(String.format("Your choose is: %d", select));
		}
		catch(InputMismatchException e) {
			System.out.println("Your choose was rejected");
		} finally {
			sc.close();			
		}
		
	}

}
