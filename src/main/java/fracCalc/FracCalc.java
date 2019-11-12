/**
 * @author Mr. Rasmussen
 */

package fracCalc;

import java.util.*;

public class FracCalc {

	// Asks user to input equation and uses for method produceAnswer
	public static void main(String[] args) {
		// TODO: Read the input from the user and call produceAnswer with an equation
		Scanner console = new Scanner(System.in);
		System.out.println("This will help you solve arithmetic operations betwen integers and/or fractions.");
		System.out.println("Input your equation here: ");
		String equation = console.nextLine();
		produceAnswer(equation);
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
		// TODO: Implement this function to produce the solution to the input
		int indexSpace = input.indexOf(" ");
		String firstOperand = input.substring(0, indexSpace);
		String operator = input.substring((indexSpace + 1), (indexSpace + 2));
		String secondOperand = input.substring(indexSpace + 3);
		return secondOperand;

	}

	// TODO: Fill in the space below with any helper methods that you think you will
	// need

}
