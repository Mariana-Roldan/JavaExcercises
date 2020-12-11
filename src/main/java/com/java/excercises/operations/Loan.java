package com.java.excercises.operations;

public class Loan {

	public double getCalculateLoan(double salary) {
		double loan = 0.0;

		if (salary >= 80000) {
			loan = 5000000;
		} else if (salary >= 50000 && salary < 80000) {
			loan = 3000000;

		} else if (salary >= 20000 && salary < 50000) {
			loan = 15000000;

		}
		else if (salary <=20000) {
			loan = 500000;
		}
		return loan;
	}

	public double getCalculateInterest(double loan) {
		double bankInterest = 0.0;

		bankInterest = (loan * .05);

		return bankInterest;

	}

	public static void main(String[] args) {
		Loan objectLoan = new Loan();
		double result;
		double resultInterest;
		result = objectLoan.getCalculateLoan(90000);
		resultInterest = objectLoan.getCalculateInterest(result);
		System.out.println("El prestamo es de : $" + result +" Con un interés de: $" + resultInterest);

	}

} // 