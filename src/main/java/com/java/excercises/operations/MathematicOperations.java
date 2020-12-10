package com.java.excercises.operations;

public class MathematicOperations {

	// void no espera ningun retorno
	public double getResidue(double numA, double numB) {
		double result;
		result = numA % numB;
		return result;

	}

	public double getSubstraction(double numC, double numD) {
		double result;
		result = numC - numD;
		return result;
	}
	
	public double getDivide(double numE, double numF) {
		double result;
		result = numE / numF;
		return result;
	}
	
	public double getSmall (double num1, double num2) {
		double SmallNumber;
		
		if(num1<num2) {
			SmallNumber = num1;
		}else {
			SmallNumber = num2;
		}
			
		return SmallNumber;
	}
	

	public static void main(String[] args) {
		MathematicOperations operation = new MathematicOperations();
		//double result;
		double result;
		result = operation.getSmall(2, 10);
		//result = operation.getDivide(25, 2);
		System.out.println("El numero es:" + result);

	}
	
}


