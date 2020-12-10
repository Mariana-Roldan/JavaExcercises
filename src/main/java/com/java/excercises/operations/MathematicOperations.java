package com.java.excercises.operations;

public class MathematicOperations {
  
	//void no espera ningun retorno
	public double getResidue(double numA, double numB ) {
		double result;
		result= numA%numB;
		return result;
		
	}
	
	public double getRest( double numC, double numD) {
		double result;
		result= numC-numD;
		return result;
	}
	
	
	public static void main(String[] args) {
		MathematicOperations operation = new MathematicOperations();
		double result;
		//result = operation.getResidue(10, 3);
		result = operation.getRest(10, 3);
		System.out.println("Result:" +result);
		
		
		
		
		
		
	}
}
