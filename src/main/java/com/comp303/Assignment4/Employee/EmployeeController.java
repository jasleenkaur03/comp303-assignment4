package com.comp303.Assignment4.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public String login() {
        return "login";
    }

    @GetMapping("/employee/signup")
    public String regsiter() {
        return "signup";
    }

    @RequestMapping(value = "/employee/signup", method = RequestMethod.POST)
    public String newEmployee(@RequestParam(name = "userName", required = true) String userName,
            @RequestParam(name = "password", required = true) String password,
            @RequestParam(name = "empId", required = true) String empId,
            @RequestParam(name = "empName", required = true) String empName, Model model) throws Exception {
        try {
            Employee employee = new Employee(empId, empName, userName, password);
            employeeService.createEmployee(employee);
            return "redirect:/employee";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());

            return "signup";
        }

    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String verifyEmployee(@RequestParam(name = "userName", required = true) String userName,
            @RequestParam(name = "password", required = true) String password, Model model) {
        try {
            String password1 = employeeService.getPassword(userName);
            if (password1.equals(password)) {
                return "redirect:/admin";
            }
            model.addAttribute("error", "Invalid user");
            return "login";
        } catch (Exception e) {
            model.addAttribute("error", "Invalid user");

            return "login";
        }
    }
}
