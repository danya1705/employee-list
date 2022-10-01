package pro.sky.java.course2.employeelist.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.employeelist.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/find")
    public String showFindedEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployee(firstName, lastName).toString();
    }

    @GetMapping("/add")
    public String addEmployeeToList(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam int departmentId,
            @RequestParam double salary) {
        return employeeService.addEmployee(firstName, lastName, departmentId, salary).toString();
    }

    @GetMapping("/remove")
    public String removeEmployeeFromList(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.removeEmployee(firstName, lastName).toString();
    }

    @GetMapping("")
    public String printList() {
        return employeeService.getEmployeeList().toString();
    }

    @GetMapping("/departments/max-salary")
    public String getMaxSalaryByDepartment(@RequestParam int departmentId) {
        return employeeService.getMaxSalaryByDepartment(departmentId).toString();
    }

    @GetMapping("/departments/min-salary")
    public String getMinSalaryByDepartment(@RequestParam int departmentId) {
        return employeeService.getMinSalaryByDepartment(departmentId).toString();
    }

    @GetMapping(value="/departments/all", params = { "departmentId" })
    public String printAllByDepartment(@RequestParam(value = "departmentId") int departmentId) {
        return employeeService.findAllByDepartment(departmentId).toString();
    }

    @GetMapping("/departments/all")
    public StringBuilder printAll() {
        return employeeService.printAllByDepartments();
    }
}
