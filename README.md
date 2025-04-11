# 📊 Employee Hierarchy & Salary Analysis – Swiss Re Case Study

This project is a Java-based solution for the Swiss Re Application Engineer case study. It reads employee data from a CSV file, analyzes salary distributions between managers and their direct reports, and checks the length of reporting lines within the organization.

---

## ✅ Problem Statement

Swiss Re provided a case study that required analyzing:

1. **Salary fairness** – Identify managers who are:
   - Underpaid compared to their team.
   - Overpaid (between 20–50% more) than their team's average salary.

2. **Organizational inefficiency** – Detect employees with excessively long reporting lines.

---

## 🧰 Tech Stack

- **Java 17**
- **Maven** – for build automation
- **Lombok** – to reduce boilerplate code
- **CSV (data.csv)** – as the input dataset

---

## 📁 Folder Structure

swize-assenment/
├── src/
│   └── com/
│       └── employee/
│           ├── Employee/
│           │   ├── App.java               # Main entry point
│           │   ├── Model/
│           │   │   └── Employee.java      # POJO using Lombok
│           │   ├── service/
│           │   │   └── service.java       # Business logic
├── resource/
│   └── data.csv                            # Employee dataset
├── pom.xml                                 # Maven config
└── README.md                               # This file

📊 Features
1️⃣ Manager Salary Analysis
Underpaid Managers: Managers earning less than the average of their team.

Overpaid Managers: Managers earning 20–50% more than the average team salary.

2️⃣ Reporting Line Analysis
Identifies the employee with the deepest reporting chain.

Measures how many levels of management exist between an employee and the top.
📁 Input Format (data.csv)
csv

id,firstName,lastName,salary,managerId
1,Alice,Smith,100000,
2,Bob,Johnson,80000,1
3,Charlie,Williams,75000,1
4,Diana,Brown,60000,2
5,Ethan,Davis,55000,2
6,Fiona,Garcia,50000,4
managerId is optional (empty for top-level employees).

Each employee is uniquely identified by id.

▶️ How to Run
1. Clone the Repository
bash

git clone https://github.com/bhoolinagar/swize-assenment.git
cd swize-assenment
2. Modify CSV File Path
In App.java, update this line to point to your local CSV file:

String filePath = "path/to/data.csv";
3. Build and Run
bash
Copy
Edit
mvn clean install
mvn exec:java -Dexec.mainClass="com.employee.Employee.App"

📌 Sample Output

Salary Analysis:
Manager Alice earns LESS than their team's average by 12500.00
Manager Bob earns MORE than their team's average by 20000.00

Reporting Line Analysis:
Employee Fiona has a reporting line TOO LONG by 3 levels


💡 Design Highlights
Uses Map<Integer, Employee> and Map<Integer, List<Employee>> for efficient traversal.

Robust null checks to avoid NullPointerException.

Stream API for clean average salary calculations.

Modular code separated by data, logic, and I/O responsibilities.
