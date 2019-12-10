/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {
	public static String equation = "";

	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation

		// Asks user to input equation and uses equation for method produceAnswer
		// continues to prompt for input until user inputs "quit"
		System.out.println("This will help you solve arithmetic operations betwen integers and/or fractions.");
		Scanner console = new Scanner(System.in);
		while (!equation.equalsIgnoreCase("quit")) {

			System.out.println("Input your equation here: (type \"quit\" to exit the fraction calculator)");
			equation = console.nextLine();
			if (!equation.contentEquals("quit")) {
				System.out.println(produceAnswer(equation));
			}
		}
		console.close();
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

	public static String produceAnswer(String input) {

		// splits up the elements of the user inputed equation
		// splits into firstOperand, operator, and secondOperand
		int indexSpace = input.indexOf(" ");
		String firstOperand = input.substring(0, indexSpace);
		String newEquation = input.substring(indexSpace + 1);
		int indexSpace2 = newEquation.indexOf(" ");
		String operator = newEquation.substring(0, indexSpace2);
		String newEquation1 = newEquation.substring(indexSpace2 + 1);
		String secondOperand = newEquation1.substring(0);

		// checks to see if there are more spaces after secondOperand
		// if so, runs multipleOps method because indicates there are more operands
		// after secondOperand
		if (secondOperand.indexOf(" ") > 0) {
			return multipleOps(firstOperand, operator, secondOperand);
		}

		// finds the index of the underscore and the slash
		int underscore = firstOperand.indexOf("_");
		int slash1 = firstOperand.indexOf("/");

		// parses the integer and splits the first operand into whole number, numerator,
		// and denominator
		int whole1;
		int num1;
		int den1;
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

		// finds the index of the underscore and slash of the second operand
		int underscore2 = secondOperand.indexOf("_");
		int slash2 = secondOperand.indexOf("/");

		// parses the integer and splits the second operand into whole number,
		// numerator, and denominator
		int whole2;
		int num2;
		int den2;
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

		// error handling
		// for case where divided by 0 and when input is in invalid form
		if (den1 == 0 || den2 == 0) {
			return "ERROR: Can't divide by 0";
		}

		// error handling
		// for case where operator is in invalid form
		if (operator.length() > 1) {
			return "ERROR: Input is in invalid form";
		}

		// turns 1st and 2nd operand into improper fractions
		num1 = num1 + Math.abs(whole1) * den1;
		num2 = num2 + Math.abs(whole2) * den2;

		// turns numerator of operands negative if whole number was negative
		if (whole1 < 0) {
			num1 *= -1;
		}
		if (whole2 < 0) {
			num2 *= -1;
		}

		// depending on the operator, performs math
		// results in num3 and den3, which are answers in improper format
		int num3 = 0;
		int den3 = 0;
		int whole4 = 0;
		if (operator.equals("+")) {
			num3 = (num1 * den2) + (num2 * den1);
			den3 = (den1 * den2);
		} else if (operator.equals("-")) {
			num3 = (num1 * den2) - (num2 * den1);
			den3 = (den1 * den2);
		} else if (operator.equals("*")) {
			num3 = (num1 * num2);
			den3 = (den1 * den2);
			if (whole1 == 0 || whole2 == 0) {
				whole4 = 0;
			}
		} else if (operator.equals("/")) {
			num3 = (num1 * den2);
			den3 = (den1 * num2);
			if (num2 == 0) {
				return "ERROR: Can't divide by 0";
			}
		}

		// num4 and den4 are absolute value of num3 and den3 for simplifying
		int num4;
		int den4;
		num4 = Math.abs(num3);
		den4 = Math.abs(den3);

		// converts the improper fraction into a mixed fraction
		if (num4 % den4 == 0) {
			whole4 = num4 / den4;
		} else if (!(num4 % den4 == 0)) {
			if (num4 > den4) {
				whole4 = num4 / den4;
				num4 = num4 - whole4 * den4;
				if (den4 == 1) {
					whole4 = num4;
				}
			}
		} else {
			whole4 = 0;
		}

		// finds the greatest common divisor by finding greatest number that is
		// divisible by both denominator and numerator
		int gcd = 0;
		for (int i = 1; i <= den4 && i <= num4; i++) {
			if (den4 % i == 0 && num4 % i == 0) {
				gcd = i;
			}
		}

		// simplifies by dividing numerator and denominator by greatest common divisor
		// doesn't run in cases where gcd = 0
		if (gcd != 0) {
			num4 = (num4 / gcd);
			den4 = (den4 / gcd);
		}

		// handles negatives if the numerator or denominator is negative
		if (num3 < 0 || den3 < 0) {
			whole4 *= -1;
			num4 = Math.abs(num4);
			if (whole4 == 0) {
				num4 *= -1;
			}
		}

		// for the case if numerator and denominator are negative and cancel each other
		// out
		if (num3 < 0 && den3 < 0) {
			num4 = Math.abs(num4);
			den4 = Math.abs(den4);
			whole4 = Math.abs(whole4);
		}

		// returns result in format depending on whether there is a whole number or not
		String result;
		if (num4 == 0) {
			result = (whole4 + "");
		} else if (den4 == 1) {
			result = (whole4 + "");
			if (whole4 == 0) {
				result = (num4 + "");
			}
		} else if (whole4 == 0) {
			result = (num4 + "/" + den4);
			if (num4 == 0) {
				result = (0 + "");
			}
		} else {
			result = (whole4 + "_" + num4 + "/" + den4);
		}
		return result;
	}

	// multiple operations
	// calls the firstOperand, operator, and second operator
	// generates newValue which runs produceAnswer with only those two operands
	// replaces firstOperand with newValue and newEquation with the remainder of the
	// equation to run through produceAnswer
	public static String multipleOps(String firstOperand, String operator, String secondOperand) {
		int indexSpace2 = secondOperand.indexOf(" ");
		String operator2 = secondOperand.substring((indexSpace2 + 1), (indexSpace2 + 2));
		String operand2 = secondOperand.substring(0, indexSpace2);
		String newEquation = secondOperand.substring(indexSpace2 + 3);
		String equation1 = firstOperand + " " + operator + " " + operand2;
		String newValue = produceAnswer(equation1);
		String equation2 = newValue + " " + operator2 + " " + newEquation;
		String result = produceAnswer(equation2);
		return result;
	}

}

// TODO: Fill in the space below with any helper methods that you think you will
// need                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       