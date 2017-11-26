/*
*******************************************************************************************************
*** ID                  : xxxxxxxxx
*** Name                : xxxxxxxxx
*** Date                : January 22, 2014
*** Program Name        : ComplexExerciser1.java
*** Program Description : Assignment 1: Part 1: This program instantiates complex numbers using the file 
***                       Complex1.java and prints them them to the console. This program reads in a 
***                       data file (ComplexData.txt) that contains integers which need to be converted
***                       into complex numbers.
*** Program Input       : ComplexData.txt
*** Program Output      : Complex numbers printed to the console.
*******************************************************************************************************
*/

import java.io.*;
import java.util.*;

public class ComplexExerciser1{
	public static void main(String [] args){
			
		// Create first object: myComplex, print to console
		Complex1 myComplex = new Complex1(2,4);
		System.out.println("First complex number:" + myComplex);
		// Create second object: myComplex2, print to console
		Complex1 myComplex2 = new Complex1(4, -5);
		System.out.println("Second complex number:" + myComplex2);
		
		try{
			
			System.out.println("From File:");
			Scanner myFile = new Scanner(new File("ComplexData.txt"));
			while(myFile.hasNext()){
				// Read the first line of the file
				// Number is the size/length of Complex1 array
				int size = myFile.nextInt();
				Complex1[] a = new Complex1[size];
				// Create array twice the size of Complex1 array
				int[] b = new int[size*2];
				// Store integer values from file in array b
				for(int i = 0; i < b.length; i++){
					b[i] = myFile.nextInt();	
				}
				
				int count = 0;
				// Fill Complex1 array with values from array b
				for(int i = 0; i < size; i++){
					a[i] = new Complex1(b[count],b[count+1]);
					count+=2;
				}
				// Print all complex values from Complex1 array to the console
				for(int i = 0; i < a.length; i++){
					System.out.println(a[i].toString());
				}
			}// End of while
			
		}
		catch(FileNotFoundException ex){
			System.out.println("Sorry. File does not exist.");
		}
		catch(NoSuchElementException ex){
			System.out.println("Sorry. No such element exists.");
		}
	}// End of main
}
