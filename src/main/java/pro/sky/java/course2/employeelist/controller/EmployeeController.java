package pro.sky.java.course2.employeelist.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.employeelist.Employee;
import pro.sky.java.course2.employeelist.service.EmployeeService;

import java.util.Arrays;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/find")
    public Employee showFindedEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/add")
    public String addEmployeeToList(@RequestParam String firstName, @RequestParam String lastName) {
        employeeService.addEmployee(firstName, lastName);
        return firstName + " " + lastName + " is added to list";
    }

    @GetMapping("/remove")
    public String removeEmployeeFromList(@RequestParam String firstName, @RequestParam String lastName) {
        employeeService.removeEmployee(firstName, lastName);
        return firstName + " " + lastName + " is removed from list";
    }

    @GetMapping("/print")
    public String printList() {
        return Arrays.toString(employeeService.getEmployeeList());
    }
}
