package com.employee.Employee.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.employee.Employee.Model.Employee;

public class service {
	private Map<Integer, Employee> employeeMap = new HashMap<>();
    private Map<Integer, List<Employee>> managerMap = new HashMap<>();
    
// to storing employees ,manager details in hashmap
    public service(List<Employee> employees) {
        for (Employee e : employees) {
            employeeMap.put(e.getId(), e);
            if (e.getManagerId() != null) {
                managerMap.computeIfAbsent(e.getManagerId(), k -> new ArrayList<>()).add(e);
            }
        }

    }
//which managers earn less than they should, and by how much
    //which managers earn more than they should, and by how much
    public void analyzeSalaries() {
        for (Map.Entry<Integer, List<Employee>> entry : managerMap.entrySet()) {
            int managerId = entry.getKey();
            List<Employee> subordinates = entry.getValue();

            double avgSalary = subordinates.stream().mapToDouble(Employee::getSalary).average().orElse(0);
            Employee manager = employeeMap.get(managerId);


            if (manager == null) {
				continue;
			}

         double percentage= Math.abs((avgSalary-manager.getSalary())*100/avgSalary);
          if (manager.getSalary() < avgSalary ) {



                System.out.printf("Manager %s earns LESS than their team's average by %.2f%n",
                        manager.getFirstName(), avgSalary - manager.getSalary());
            } else if (manager.getSalary() > avgSalary && percentage>=20 && percentage<=50) {

            	System.out.printf("Manager %s earns MORE than their team's average by %.2f%n",
                        manager.getFirstName(), manager.getSalary() - avgSalary);
            }
        }
        }
    
    //which employees have a reporting line which is too long, and by how much
    public void analyzeReportingLineDepth() {
    	int maxd=Integer.MIN_VALUE;
    	String name="";
        for (Employee e : employeeMap.values()) {
            int depth = 0;
            Integer managerId = e.getManagerId();
            while (managerId != null) {
                depth++;
                Employee manager = employeeMap.get(managerId);
                if (manager == null) {
					break;
				}
                managerId = manager.getManagerId();
            }

            if (depth > maxd) {
            	name=e.getFirstName();
            	maxd=depth;
                 }

        }

        System.out.printf("Employee %s has a reporting line TOO LONG by %d levels%n",
                      name, maxd);
    }


}
