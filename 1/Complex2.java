/*
***************************************************************************************************
*** ID                  : xxxxxxxxx
*** Name                : xxxxxxxxx
*** Date                : January 22, 2014
*** Program Name        : Complex2.java
*** Program Description : Assignment 1: Part2: Tests the functionality of the created class by 
***                       instantiating objects and manipulating attributes using instance methods.
*** Program Input       : N/A 
*** Program Output      : Complex numbers printed to the console.
***************************************************************************************************
*/

/*
* STATIC METHOD: A static method is called by a class. There is only one copy of a static method. 
*                which can be used as is, without any instantiation (use of the word 'new'). 
*                These methods cannot access instance methods/variables but rather use object referencing.
*
* INSTANCE METHOD: When creating new objects you create many instances of it from a
*                  blueprint class. Until an object is created these methods can not be used. 
*/

public class Complex2 {
	// Name for real attribute in complex number
	private int real;
	// Name for imaginary attribute in complex number
	private int imaginary;
	
	// Default Constructor
	public Complex2 () {
		this.real = 0;
		this.imaginary = 0;
	}
	
	// Constructor for a new complex number, with:
	//  - real component = r
	//  - imaginary component = i
	public Complex2 (int r, int i) {
		this.real = r;
		this.imaginary = i;
	}
	
	// Constructor for a new complex number, with:
	//  - real component = r
	//  - imaginary = 0
	public Complex2 (int r) {
		this.real = r;
		this.imaginary = 0;
	}
	
	// Accessor for the real attribute
	public int getReal() {
		return this.real;
	}
	
	// Mutator for the real attribute
	public void setReal(int real) {
		this.real = real;
	}
	
	// Accessor for the imaginary attribute
	public int getImaginary() {
		return this.imaginary;
	}
	
	// Mutator for the imaginary attribute
	public void setImaginary(int imaginary) {
		this.imaginary = imaginary;
	}
	
       /*
        ****************************************************************************
        * Method Name : add
        *       Input : object - Complex2 val.
        *      Output : object - returns a new complex number.
        *     Purpose : This returns a complex number whose value is the sum of the 
        *               existing (Complex2) number plus the parameter val.
        ****************************************************************************
        */
	public Complex2 add(Complex2 val) {	
		Complex2 sum = new Complex2();
                sum.setReal(this.real + val.real);
		sum.setImaginary(this.imaginary + val.imaginary);
		return sum;
	}
       
       /*
        ****************************************************************************
        * Method Name : subtract
        *       Input : object - Complex2 val.
        *      Output : object - returns a new complex number.
        *     Purpose : This returns a complex number whose value is the difference
        *               between the existing (Complex2) number minus the parameter
        *               val.
        ****************************************************************************
        */
	public Complex2 subtract(Complex2 val) {
		Complex2 difference = new Complex2();
                difference.setReal(this.real - val.real);
		difference.setImaginary(this.imaginary - val.imaginary);
		return difference;
	}
	
       /*
        ****************************************************************************
        * Method Name : multiply
        *       Input : object - Complex2 val.
        *      Output : object - returns a new complex number.
        *     Purpose : This returns a complex number whose value is the product
        *               of the existing (Complex2) number multiplied by the parameter
        *               val.
        ****************************************************************************
        */
	public Complex2 multiply(Complex2 val) {
		Complex2 product = new Complex2();
		product.setReal((this.real * val.real) - (this.imaginary * val.imaginary));
		product.setImaginary((this.imaginary * val.real) + (this.real * val.imaginary));
		return product;
	}
	
       /*
        ****************************************************************************
        * Method Name : divide
        *       Input : object - Complex2 val.
        *      Output : object - returns a new complex number.
        *     Purpose : This returns a complex number whose value is the quotient
        *               of the existing (Complex2) number divided by the parameter
        *               val.
        ****************************************************************************
        */
	public Complex2 divide(Complex2 val) {
		Complex2 divisor = new Complex2();
		Complex2 quotient = new Complex2();
		divisor.setReal(val.real * val.real);
		divisor.setImaginary(val.imaginary * val.imaginary);
		quotient.setReal((int)(((this.real * val.real) + (this.imaginary * val.imaginary)) / (divisor.real + divisor.imaginary)));
		quotient.setImaginary((int)(((this.imaginary * val.real) - (this.real * val.imaginary)) / (divisor.real + divisor.imaginary)));
		return quotient;
	}

       /*
        ****************************************************************************
        * Method Name : toString
        *       Input : object - some Complex2 value.
        *      Output : returns some complex value converted to String.
        *     Purpose : This prints a complex number to the console.
        ****************************************************************************
        */
	public String toString() {
		String result = "";
		// When imaginary component is negative replace the plus sign between
		// both parts with a minus sign
		if(imaginary < 0){
			result += real + " - " + (imaginary*(-1)) + "i";
		// When imaginary component is zero, do not output the imaginary part
		// or the sign between the parts
		}else if(imaginary == 0){
			result += real;
		// Otherwise do not alter signs between compenents
		// Print both values to the console
		}else{
			result += real + " + " + imaginary + "i";
		}
		return result;
	}
	
	public static void main(String [] args) {

		System.out.println("Complex Number Tester Output:");
		System.out.println();
		// Test the new constructor for Real (only) numbers
		Complex2 aReal = new Complex2(423);
		System.out.print("Real Constructor Test: Should Output 423 : ");
		System.out.println(aReal.toString());

		// Instantiate some more complex numbers
		Complex2 oneValue = new Complex2(-3,4);
		Complex2 anotherValue = new Complex2(2,-1);

		// Test add:  oneValue + anotherValue
		System.out.print("Add Tester: Should Output -1 + 3i : ");
                System.out.println(oneValue.add(anotherValue).toString());            
		
		// Test subtract:  oneValue - anotherValue
		System.out.print("Subtract Tester: Should Output -5 + 5i : ");
		System.out.println(oneValue.subtract(anotherValue).toString());
		
		// Test multiply:  oneValue * anotherValue
		System.out.print("Multiply Tester: Should Output -2 + 11i : ");
		System.out.println(oneValue.multiply(anotherValue));
		
		
		// Test divide:  oneValue / anotherValue
		System.out.print("Divide Tester: Should Output -2 + 1i : ");
		System.out.println(oneValue.divide(anotherValue));
		
		
	}// End of main
}