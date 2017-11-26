// NAME: COMPLEX
// PURPOSE:  create and manipulate Complex Number objects
// AUTHOR:  LillAnne Jackson
// DATE: June 2013
// CREDITS: none - But many others have written complex number classes before me!

public class Complex1 {
	private int real;
	private int imaginary;
	
	// Default Constructor
	public Complex1 () {
		this.real = 0;
		this.imaginary = 0;
	}
	
	// Constructor for a new complex number, with:
	// - real component = r
	// - imaginary component = i
	public Complex1 (int r, int i) {
		this.real = r;
		this.imaginary = i;
	}
	
	// Accessor for the real attribute
	public int getReal() {
		return this.real;
	}
	
	// Mutator for the real attribute
	public void setReal(int real) {
		this.real = real;
	}

	// Accessor for the imaginary attrubute
	public int getImaginary() {
		return this.imaginary;
	}

	// Mutator for the imaginary attribute
	public void setImaginary(int imaginary) {
		this.imaginary = imaginary;
	}

	// Convert result to string 
	public String toString() {
		String result = "";
		result += real + " + " + imaginary + "i";
		return result;
	}
}
