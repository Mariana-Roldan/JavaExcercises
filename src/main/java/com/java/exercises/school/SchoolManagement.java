package com.java.exercises.school;

import java.util.ArrayList;
import java.util.List;

public class SchoolManagement {

	public static List<Student> studentList = new ArrayList<>();

	public void addStudentToList(Student student) {
		studentList.add(student);
	}

	public List <Student> showStudentList() {

		for (int i = 0; i < studentList.size(); i++) { 
			System.out.println(studentList.get(i));
		}

		 return studentList;
	}

	public static void main(String[] args) {
		SchoolManagement schoolManagement = new SchoolManagement();
		
		Student studentObj1 = new Student(1,"Natalia","Diseño Industrial",3500);
		Student studentObj2 = new Student(2,"Raymundo","Informática",1500);
		Student studentObj3 = new Student(3,"Evelyn","Sistemas Computacionales",2000);
		
		schoolManagement.addStudentToList(studentObj1);
		schoolManagement.addStudentToList(studentObj2);
		schoolManagement.addStudentToList(studentObj3);
		
		schoolManagement.showStudentList(); 
	}

}
