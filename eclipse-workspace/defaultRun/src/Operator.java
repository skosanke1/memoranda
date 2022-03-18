//**************************************************************************************************
// CLASS: Operator
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Summer 2021
// Project Number: P04
//
// AUTHOR
//Steven Kosanke
//skosanke
//skosanke@asu.edu
//**************************************************************************************************

/**
 * Operator is the superclass of all binary and unary operators.
 */
abstract class Operator extends Token{
	
	public Operator() {
	}
	
	public abstract boolean isBinaryOperator();
	public abstract int precedence();
	public abstract int stackPrecedence();

}
