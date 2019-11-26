/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {
	public static String equation = "";

	// Asks user to input equation and uses for method produceAnswer
	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation

		System.out.println("This will help you solve arithmetic operations betwen integers and/or fractions.");
		while (!equation.contentEquals("quit")) {
			Scanner console = new Scanner(System.in);
			System.out.println("Input your equation here: (type \"quit\" to exit the fraction calculator)");
			equation = console.nextLine();
			if (!equation.contentEquals("quit")) {
				System.out.println(produceAnswer(equation));

			}

		}
	}

	// ** IMPORTANT ** DO NOT DELETE THIS FUNCTION. This function will be used to
	// test your code
	// This function takes a String 'input' and produces the result
	//
	// input is a fraction string that needs to be evaluated. For your program, this
	// will be the user input.
	// e.g. input ==> "1/2 + 3/4"
	//
	// The function should return the result of the fraction after it has been
	// calculated
	// e.g. return ==> "1_1/4"

	// Splits the equation up into operand 1, operator, and second operand and then
	// returns second operand
	static int whole1;
	static int num1;
	static int den1;
	static int whole2;
	static int num2;
	static int den2;
	static int wholeResult;
	static int numResult;
	static int denResult;
	static int num3;
	static int den3;
	public static String produceAnswer(String input) {
		// TODO: Implement this function to produce the solution to the input
		int indexSpace = input.indexOf(" ");
		String firstOperand = input.substring(0, indexSpace);
		String operator = input.substring((indexSpace + 1), (indexSpace + 2));
		String secondOperand = input.substring(indexSpace + 3);
		int underscore = firstOperand.indexOf("_");
		int slash1 = firstOperand.indexOf("/");
		if (underscore > 0) {
			whole1 = Integer.parseInt(firstOperand.substring(0, underscore));
			if (slash1 > 0) {
				num1 = Integer.parseInt(firstOperand.substring(underscore + 1, slash1));
				den1 = Integer.parseInt(firstOperand.substring(slash1 + 1));
			} else {
				num1 = 0;
				den1 = 1;
			}
		} else {
			if (slash1 > 0) {
				whole1 = 0;
				num1 = Integer.parseInt(firstOperand.substring(0, slash1));
				den1 = Integer.parseInt(firstOperand.substring(slash1 + 1));
			} else {
				whole1 = Integer.parseInt(firstOperand.substring(0));
				num1 = 0;
				den1 = 1;
			}
		}
		int underscore2 = secondOperand.indexOf("_");
		int slash2 = secondOperand.indexOf("/");

		if (underscore2 > 0) {
			whole2 = Integer.parseInt(secondOperand.substring(0, underscore2));
			if (slash2 > 0) {
				num2 = Integer.parseInt(secondOperand.substring(underscore2 + 1, slash2));
				den2 = Integer.parseInt(secondOperand.substring(slash2 + 1));
			} else {
				num2 = 0;
				den2 = 1;
			}
		} else {
			if (slash2 > 0) {
				whole2 = 0;
				num2 = Integer.parseInt(secondOperand.substring(0, slash2));
				den2 = Integer.parseInt(secondOperand.substring(slash2 + 1));
			} else {
				whole2 = Integer.parseInt(secondOperand.substring(0));
				num2 = 0;
				den2 = 1;
			}
		}
		num1 = num1 + Math.abs(whole1) * den1; 
		num2 = num2 + Math.abs(whole2) * den2;
		if (whole1 < 0 ) {
			num1 *= -1; 
		}
		if (whole2 < 0) {
			num2 *= -1; 
		}
	
		if (operator.equals("+")) {
			num3 = (num1 * den2) + (num2 * den1);
			den3 = (den1 * den2);
		} else if (operator.equals("-")) {
			num3 = (num1 * den2) - (num2 * den1);
			den3 = (den1 * den2);
		} else if (operator.equals("*")) {
			num3 = (num1 * num2);
			den3 = (den1 * den2);
		} else if (operator.equals("/")) {
			num3 = (num1 * den2);
			den3 = (den1 *num2);
		}
	
		String result = (num3 + "/" + den3);
		return result; 
	}
	

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}
