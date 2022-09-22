package pro.sky.java.course2.employeelist.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeelist.Employee;
import pro.sky.java.course2.employeelist.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.employeelist.exception.EmployeeNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    private final Map<Integer,Employee> employeeList;

    public EmployeeService() {
        this.employeeList = new HashMap<>();
    }

    public Map<Integer, Employee> getEmployeeList() {
        return employeeList;
    }

    public Employee addEmployee(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);
        int employeeID = employee.hashCode();

        if (this.employeeList.containsKey(employeeID)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            this.employeeList.put(employeeID,employee);
            return employee;
        }
    }

    public Employee findEmployee(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);
        int employeeID = employee.hashCode();

        if (this.employeeList.containsKey(employeeID)) {
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    public Employee removeEmployee(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);
        int employeeID = employee.hashCode();

        if (this.employeeList.containsKey(employeeID)) {
            this.employeeList.remove(employeeID);
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }
}
