package com.StudentManagmentApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.manage.Student;
import com.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws IOException
	{
		System.out.println("Welcome to our Student Managment App:----");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("PRESS 1 to Add Student");
			System.out.println("PRESS 2 to Delete Student");
			System.out.println("PRESS 3 to Display Student");
			System.out.println("PRESS 4 to Update Student");
			System.out.println("PRESS 5 to Exit App");
			
			int c = Integer.parseInt(br.readLine());
			
			if(c == 1) {
				//Add Student
				System.out.println("Enter user name : ");
				String name = br.readLine();
				
				System.out.println("Enter user phone : ");
				String phone = br.readLine();
				
				System.out.println("Enter user city : ");
				String city = br.readLine();
				
				//create Student object to store student
				Student st = new Student(name, phone, city);
				
				boolean addAnswer = StudentDao.insertStudenttoDB(st);
				if (addAnswer) {
					System.out.println("Student is Added Successfully...");
				} else {
					System.out.println("Something went Wrong...!");
				}
				System.out.println(st);
			} else if(c == 2) {
				//Delete Student
				System.out.println("Enter Student Id to delete : ");
				int userId = Integer.parseInt(br.readLine());
				boolean deleteAnswer = StudentDao.deleteStudent(userId);
				
				if (deleteAnswer) {
					System.out.println("Student Id is Deleted Successfully..");
				} else {
					System.out.println("Something went Wrong...!");
				}
				
			} else if(c == 3) {
				//Display Student
				System.out.println("Showing All Students Data....");
				StudentDao.showAllStudent();
				
			} else if(c == 4) {
				//Update Student
				
				System.out.println("Enter user Id to update : ");
				int updateId = Integer.parseInt(br.readLine());
				
				System.out.println("Enter user name : ");
				String name = br.readLine();
				
				System.out.println("Enter user phone : ");
				String phone = br.readLine();
				
				System.out.println("Enter user city : ");
				String city = br.readLine();
				
				//create Student object to store student
				Student ust = new Student(updateId, name, phone, city);
				boolean updateAnswer = StudentDao.updateStudent(ust);
				
				if (updateAnswer) {
					System.out.println("Updated Students Data....");
				} else {
					System.out.println("Something went Wrong...!");
				}
				
			} else if(c == 5) {
				//Exit Application
				break;
			} else {
				
			}
		}
		System.out.println("Thank you using my Application....");
		System.out.println("See you soon....");
	}

}
