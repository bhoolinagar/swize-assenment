package com.employee.Employee.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Employee {
	 private int id;
	    private String firstName;
	    private String lastName;
	    private double salary;
	    private Integer managerId;

}
