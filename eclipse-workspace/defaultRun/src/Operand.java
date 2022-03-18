//**************************************************************************************************
// CLASS: Operand
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
 * An operand is a numeric value represented as a Double.
 */
public class Operand extends Token{
	Double mValue;
	public Operand(Double pValue) {
		mValue = pValue;
	}
	
	public Double getValue() {
		return mValue;
	}
	
	public void setValue(Double pValue) {
		mValue = pValue;
	}
}
