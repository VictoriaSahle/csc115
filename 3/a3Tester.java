// NAME: a3Tester
// PURPOSE:  Solve Mathematical functions, like x^n and e^x iteratively and then recursively
//     and then more efficiently using recursion.
// AUTHOR:  LillAnne Jackson
// DATE: Januayr 2014
// CREDITS: The ideas for the problems: from the Carrano and Prichard textbook
/*
*************************************************************************************************************
*** ID                  : V00765211
*** Name                : Victoria Sahle
*** Date                : January 22, 2014
*** Program Name        : a3Tester.java
*** Program Description : Assignment 3: This program reads a TestData.txt file and uses both iterative 
***                       and recursive methods to calcualte powers, factorials, and exponential equations.
***                       Results are then compared with those in TestResult.txt, and printed to the console.
*** Program Input       : TestData.txt, TestResult.txt
*** Program Output      : All (true) calculations printed to console. 
*************************************************************************************************************
*/

import java.util.*;
import java.io.*;

public class a3Tester {
	//nthTerm: divisor used in method eThree()
	private static long nthTerm;
	
	 /*
        **************************************************************************************
        * Method Name : powerOne
        *       Input : Some x value, some n value from TestData.txt
        *      Output : x^n
        *     Purpose : Iterative static method. This computes and returns x^n for some n >= 0
        **************************************************************************************
        */
	public static double powerOne(double x, long n){
		double result = 1.0;
		//If power equal to 0, then x^0 = 1
		if(n == 0){
			return result;
		//If power equal to 1, the x^1 = x
		}else if(n == 1){
			return x;
		//Else iteratively calculate the power of x^n
		}else {
			for(int i =0; i < n; i++){
				result = x * result;
			}
			return result;
		}
	}
	
	 /*
        **************************************************************************************
        * Method Name : powerTwo
        *       Input : Some x value, some n value from TestData.txt
        *      Output : x^n
        *     Purpose : Recursive static method. This computes and returns x^n for some n >= 0
        **************************************************************************************
        */
	public static double powerTwo(double x, long n){
		//Base Case:
		//If power equal to 0, then x^0 = 1
		if(n == 0){
			return 1.0;
		//Else recursively calculate the result of x^n
		}else {
			return x * powerTwo(x, n-1);
		}
	}
	
	 /*
        **************************************************************************************
        * Method Name : powerThree
        *       Input : Some x value, some n value from TestData.txt
        *      Output : x^n
        *     Purpose : Recursive static method. This computes and returns x^n for some n >= 0
        **************************************************************************************
        */
	public static double powerThree(double x, long n){
		//Base Case:
		//If power equal to 0, then x^0 = 1
		if(n == 0){
			return 1.0;
		//Else recursively calculate the result of x^n
		}else if(n%2 == 0){
			//If power is even calculate
			return powerThree(x, n/2) * powerThree(x, n/2);
		}else {
			//If power is odd calculate
			return x * powerThree(x, n/2) * powerThree(x, n/2);
		}
	}
	
	 /*
        **************************************************************************************
        * Method Name : factOne
        *       Input : Some x value from TestData.txt
        *      Output : x!
        *     Purpose : Iterative static method. This computes and returns x! for some x >= 0
        **************************************************************************************
        */
	public static double factOne(double x){
		double product = 1.0;
		//0! = 1
		if(x == 0.0){
			return product;
		//Else iteratively calculate x!
		}else {
			for(int i = 1; i <= (int)x; i++){
				product = (double)i * product;
			}
		}
		return product;
	}
	
	 /*
        **************************************************************************************
        * Method Name : factTwo
        *       Input : Some x value from TestData.txt
        *      Output : x!
        *     Purpose : Recursive static method. This computes and returns x! for some x >= 0
        **************************************************************************************
        */
	public static double factTwo(double x){
		//Base case: 0! = 1
		if(x == 0){
			return 1.0;
		//Else recursively calculate x!
		}else {
			return x * factTwo(x-1);
		}
	}
	
	 /*
        ***************************************************************************************
        * Method Name : eOne
        *       Input : Some x value, some n value from TestData.txt
        *      Output : e^x
        *     Purpose : Iterative static method. This computes and returns e^x for all x, using
        *               an n+1 term MacLaurin series.
        ***************************************************************************************
        */
	public static double eOne(double x, long n){
		double result = 0.0;
		//Iteratively calculate e^x
		//Use MacLaurin series
		for(int i = 0; i < (n + 1); i++){
			//Calculate x^i / i!
			result += powerOne(x, i) / factOne(i);
		}
		return result;
	}
	
	 /*
        ***************************************************************************************
        * Method Name : eTwo
        *       Input : Some x value, some n value from TestData.txt
        *      Output : e^x
        *     Purpose : Recursive static method. This computes and returns e^x for all x, using
        *               an n+1 term MacLaurin series.
        ***************************************************************************************
        */
	public static double eTwo(double x, long n){
		//Base Case: e^0 = 1
		if(n == 0){
			return 1.0;
		//Calculate e^x recursively
		//Using MacLaurin series
		}else {
			//Calculate e^x + x^n/n!
			return eTwo(x, n-1) + powerTwo(x, n)/factTwo((double)n);
		}
	}
	
	 /*
        ***************************************************************************************
        * Method Name : eThree
        *       Input : Some x value, some n value from TestData.txt
        *      Output : e^x
        *     Purpose : Recursive static method. This computes and returns e^x for all x, using
        *               the MacLaurin series, and by using less recursive calls.
        ***************************************************************************************
        */
	public static double eThree(double x, long n){
		//Base Case: e^0 = 1
		if(n == 0){
			return 1.0;
		//Use MacLaurin series to compute e^x
		//Less recursive calls (expansion of terms)
		}else {
			return 1 + (x / nthTerm++) * eThree(x, n-1);
		}	
	}
	
	//Test if results in TestResult.txt match results from all methods
	public static boolean test(double result, Scanner testData) {
			return (Math.abs(result - testData.nextDouble()) < 0.00000000001);
	}
	
	public static void main (String [] args) throws FileNotFoundException{

		// File input
		Scanner in = new Scanner(new File("TestData.txt"));
		Scanner testIn = new Scanner(new File("TestResult.txt"));

		System.out.println(" M A T H   T E S T E R \n\n" );
		System.out.println(" Methods Written by: Victoria Sahle");
		System.out.println("   ID:  V00765211  February 2014");

		// First line of file is number of data points:
		int numPoints = in.nextInt();

	    for (int i=0; i < numPoints; i++ ) {

			//skip title line in file
			in.next();

			// Data for testing x^n methods
			double base = in.nextDouble();
			int exponent = in.nextInt();

			// x^n test calls
			System.out.println(" *********************************");
			System.out.println(" Iterative x^n with x= " + base + " and n= " + exponent + ": ");
			//Iterative method call
			double data = powerOne(base, exponent);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));
			
			System.out.println(" *********************************");
			System.out.println(" Recursive x^n (#1) with x= " + base + " and n= " + exponent + ": ");
			//Recursive method #1 call
			data = powerTwo(base, exponent);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));

			System.out.println(" *********************************");
			System.out.println(" Recursive x^n (#2) with x= " + base + " and n= " + exponent + ": ");
			//Recursive method #2 call
			data = powerThree(base, exponent);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));
			
			// Data for testing n! methods
			//skip title line in file
			in.next();
			int n = in.nextInt();

			// n! test calls
			
			System.out.println(" *********************************");
			System.out.println(" Iterative n! with n= " + n +  ": ");
			//Iterative method call
			data = factOne(n);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));
			
			System.out.println(" *********************************");
			System.out.println(" Recursive n! with n= " + n + ": ");
			//Recursive method call 
			data = factTwo(n);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));
			
			// Data for testing e^x methods
			//skip title line in file
			in.next();
			double x = in.nextDouble();
			n = in.nextInt();
			
			// e^x test calls
			
			System.out.println(" *********************************");
			System.out.println(" Iterative e^x with x= " + x + "("+ n + " terms): ");
			//Iterative method call
			data = eOne(x, n);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));
			
			System.out.println(" *********************************");
			System.out.println(" Recursive e^x (#1) with x= " + x + "("+ n + " terms): ");
			//Recurive method #1 call
			data = eTwo(x, n);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));
			
			System.out.println(" *********************************");
			System.out.println(" Recursive e^x (#2) with x= " + x + "("+ n + " terms): ");
			//Will reset divisor each time method eThree is called
			nthTerm = 1;
			//Recursive method #2 call
			data = eThree(x, n);
			System.out.println("    " + data);
			System.out.println("  \t\t\t\t\tTest: " + test(data, testIn));
			
			//in.nextLine();
			
		}
	}


}


