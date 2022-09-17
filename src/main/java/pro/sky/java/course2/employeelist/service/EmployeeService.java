package pro.sky.java.course2.employeelist.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeelist.Employee;
import pro.sky.java.course2.employeelist.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.employeelist.exception.EmployeeNotFoundException;
import pro.sky.java.course2.employeelist.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employeeList;

    public EmployeeService() {
        this.employeeList = new ArrayList<>();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public Employee addEmployee(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);

        if (this.employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            this.employeeList.add(employee);
            return employee;
        }
    }

    public Employee findEmployee(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);

        if (this.employeeList.contains(employee)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    public Employee removeEmployee(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);

        if (this.employeeList.contains(employee)) {
            this.employeeList.remove(employee);
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }
}
