package com.employee.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.employee.Employee.Model.Employee;
import com.employee.Employee.service.service;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      
         String filePath = "C:\\Users\\bhool\\eclipse-workspace\\Employee\\resource\\data.csv";// Your CSV file path here
        List<Employee> employees = readEmployeesFromCSV(filePath);

      service analyzer = new service(employees);

        System.out.println("Salary Analysis:");
        analyzer.analyzeSalaries();

        System.out.println("\nReporting Line Analysis:");
        analyzer.analyzeReportingLineDepth();
        
    }
    
// function for to get data from data.csv file
    private static List<Employee> readEmployeesFromCSV(String filePath) {
        List<Employee> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean skipHeader = true;
            while ((line = br.readLine()) != null) {
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }
                String[] cols = line.split(",");
                if (cols.length >= 4) {
                    int id = Integer.parseInt(cols[0]);
                    String fname = cols[1];
                    String lname = cols[2];
                    double salary = Double.parseDouble(cols[3]);
                    Integer managerId = (cols.length > 4 && !cols[4].isEmpty()) ? Integer.parseInt(cols[4]) : null;

                    list.add(new Employee(id, fname, lname, salary, managerId));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    }

