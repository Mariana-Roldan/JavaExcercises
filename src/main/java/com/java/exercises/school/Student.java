package com.java.exercises.school;

public class Student {

	// Modelado
	
	private int idStudent;
	private String studentName;
	private String career;
	private double payment;
	
	
	
	
public Student() {}

//	Constructor
	public Student(int idStudent, String studentName, String career, double payment) {
		super();
		this.idStudent = idStudent;
		this.studentName = studentName;
		this.career = career;
		this.payment = payment;
	}

	
	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "idStudent=" + idStudent + ", studentName=" + studentName + ", career=" + career + ", payment="
       		+ payment + "\n";
	}
	
	
	
	
}
