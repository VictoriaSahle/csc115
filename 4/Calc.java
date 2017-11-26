/*
***************************************************************************************************
*** ID                  : V00765211
*** Name                : Victoria Sahle
*** Date                : March 12, 2014
*** Program Name        : Calc.java
*** Program Description : Assignment 4: Accepts postfix expressions on the command line and outputs
***                       the result of evaluating the expression. 
*** Program Input       : Postfix expressions on the command line.
*** Program Output      : Result of evaluating the expression to the console.
***************************************************************************************************
*/

public class Calc{
	public static void main(String[] args){
		//Beginning of try
		try{
			//Create Stack of String value
			Stack<Integer> calculator = new LLStack<Integer>();
			//Checking command line arguments
			for(int i = 0; i < args.length; i++){
				String x = args[i];
				//Start of switch statement
				//If 'integer' value push on Stack
				//Else call method popAndCalculate
				switch(x){
					case "+": popAndCalculate(calculator, "+");
						   break;
				        case "-": popAndCalculate(calculator, "-");
				        	   break;
				        case "/": popAndCalculate(calculator, "/");
				        	   break;
				        case "x": popAndCalculate(calculator, "x");
				        	   break;
				        default : calculator.push(Integer.parseInt(x));
				                  break;
				}
			}
			if(calculator.size() != 0){
				finalResult(calculator);
			}
		
		}//End of try
		catch(StackEmptyException ex){
			System.out.println("Invalid expression.");
		}
		catch(NumberFormatException e){
			System.out.println("Invalid expression.");
		}//End of catch
	}
	/*
        ****************************************************************************
        * Method Name : popAndCalculate
        *       Input : LLStack, String operator
        *     Purpose : Pop two values from the stack, apply operator to the integer 
        *               values, and call returnToStack to push value back onto stack
        ****************************************************************************
        */
	public static void popAndCalculate(Stack<Integer> calc, String operator) throws StackEmptyException{
		int result = 0;
		//Pop two elements, store in integer value
		int first = calc.pop();
		int second = calc.pop();
		//Beginning of switch statement
		//Apply correct operator
		switch(operator){
			case "+": result = second + first;
				  break;
			case "-": result = second - first;
				  break;
		        case "/": result = second / first;
				  break;
		        case "x": result = second * first;
				  break;
				}
			//Call returnToStack
			returnToStack(calc, result);
	}
	/*
        ********************************************************************************
        * Method Name : returnToStack
        *       Input : LLStack, integer result
        *     Purpose : Push result of two integer values back on the stack
        ********************************************************************************
        */
	public static void returnToStack(Stack<Integer> calc, int result){
		//Push back onto Stack
		calc.push(result);
	}
	/*
        ****************************************************************************
        * Method Name : finalResult
        *       Input : LLStack
        *     Purpose : Once one element left on stack, pop the value and display it
        ****************************************************************************
        */
	public static void finalResult(Stack<Integer> calc) throws StackEmptyException{
		//Store last element(final result) into integer value
		int finalResult = calc.pop();
		//Display result on console
		System.out.println(finalResult);
	}
	
}
