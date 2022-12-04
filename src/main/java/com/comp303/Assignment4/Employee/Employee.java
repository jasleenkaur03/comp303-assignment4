package com.comp303.Assignment4.Employee;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("employees")
public class Employee {
    @Id
    public String empId;
    public String empName;
    public String userName;
    public String password;
    
    public Employee() {
    }

    public Employee(String empId, String empName, String userName, String password) {
        this.empId = empId;
        this.empName = empName;
        this.userName = userName;
        this.password = password;
    }

}
