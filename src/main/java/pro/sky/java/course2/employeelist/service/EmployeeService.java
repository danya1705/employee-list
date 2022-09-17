package pro.sky.java.course2.employeelist.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeelist.Employee;
import pro.sky.java.course2.employeelist.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.employeelist.exception.EmployeeNotFoundException;
import pro.sky.java.course2.employeelist.exception.EmployeeStorageIsFullException;

import java.util.Arrays;

@Service
public class EmployeeService {
    private Employee[] employeeList;

    public EmployeeService() {
        this.employeeList = new Employee[5];
    }

    public Employee[] getEmployeeList() {
        return employeeList;
    }

    public void addEmployee(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);

        for (int i = 0; i < this.employeeList.length; i++) {
            if (employee.equals(this.employeeList[i])) {
                throw new EmployeeAlreadyAddedException();
            }
        }

        for (int i = 0; i < this.employeeList.length; i++) {
            if (this.employeeList[i] == null) {
                this.employeeList[i] = employee;
                return;
            }
        }

        throw new EmployeeStorageIsFullException();
    }

    public Employee findEmployee(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);

        for (int i = 0; i < this.employeeList.length; i++) {
            if (employee.equals(this.employeeList[i])) {
                return employee;
            }
        }

        throw new EmployeeNotFoundException();
    }

    public void removeEmployee(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);

        for (int i = 0; i < this.employeeList.length; i++) {
            if (employee.equals(this.employeeList[i])) {
                this.employeeList[i] = null;
                return;
            }
        }

        throw new EmployeeNotFoundException();
    }
}
