package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.model.Address;
import com.model.Course;
import com.model.MyDate;
import com.model.Student;

@SpringBootApplication
public class StudentManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);

		 Address address = new Address("456 Elm St", "Othertown", "OT", "54321");
		 MyDate dob = new MyDate(1, 1, 2000);
		 Course course = new Course("Python", 20, 800.0);
		 Student student2 = new Student("Jane Doe", address, dob, course);
		 System.out.println(student2);
	}

}
