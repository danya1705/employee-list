package pro.sky.java.course2.employeelist.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeelist.Employee;
import pro.sky.java.course2.employeelist.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.employeelist.exception.EmployeeNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    private final Map<String,Employee> employeeList;

    public EmployeeService() {
        this.employeeList = new HashMap<>();
    }

    public Map<String, Employee> getEmployeeList() {
        return employeeList;
    }

    public Employee addEmployee(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);

        if (this.employeeList.containsKey(employee.getName())) {
            throw new EmployeeAlreadyAddedException();
        } else {
            this.employeeList.put(employee.getName(),employee);
            return employee;
        }
    }

    public Employee findEmployee(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);

        if (this.employeeList.containsKey(employee.getName())) {
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    public Employee removeEmployee(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);

        if (this.employeeList.containsKey(employee.getName())) {
            this.employeeList.remove(employee.getName());
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }
}
