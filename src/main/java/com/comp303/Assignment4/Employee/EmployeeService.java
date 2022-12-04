package com.comp303.Assignment4.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void createEmployee(Employee e) throws Exception{
        employeeRepository.save(e);
    }

    public String getPassword(String username) throws Exception {
        Employee employee = employeeRepository.getPassword(username);
        return employee.password;
    }
}
