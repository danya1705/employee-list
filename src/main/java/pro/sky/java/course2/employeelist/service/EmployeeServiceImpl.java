package pro.sky.java.course2.employeelist.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.employeelist.model.Employee;
import pro.sky.java.course2.employeelist.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.employeelist.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employeeList;

    public EmployeeServiceImpl() {
        this.employeeList = new ArrayList<>(List.of(
                new Employee(
                        "Ivan",
                        "Ivanov",
                        1,
                        1000.0),
                new Employee(
                        "Petr",
                        "Petrov",
                        1,
                        2000.0),
                new Employee(
                        "Sidor",
                        "Sidorov",
                        2,
                        3000.0),
                new Employee(
                        "Lena",
                        "Lenina",
                        2,
                        4000.0),
                new Employee(
                        "Dart",
                        "Veider",
                        2,
                        5000.0)
        ));
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int departmentId, double salary) {

        Employee employee = new Employee(firstName, lastName, departmentId, salary);

        if (this.employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            this.employeeList.add(employee);
            return employee;
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);

        if (this.employeeList.contains(employee)) {
            return this.employeeList.get(this.employeeList.indexOf(employee));
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {

        Employee employee = new Employee(firstName, lastName);

        if (this.employeeList.contains(employee)) {
            this.employeeList.remove(employee);
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee getMaxSalaryByDepartment(int departmentId) {
        return this.employeeList
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow()
                ;
    }

    @Override
    public Employee getMinSalaryByDepartment(int departmentId) {
        return this.employeeList
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow()
                ;
    }

    @Override
    public List<Employee> findAllByDepartment(int departmentId) {
        return this.employeeList
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList())
                ;
    }

    @Override
    public StringBuilder printAllByDepartments() {
        StringBuilder result = new StringBuilder();
        for (Integer departmentId : this.employeeList
                .stream()
                .map(Employee::getDepartmentId)
                .collect(Collectors.toSet())) {
            result.append("department #").append(departmentId).append("<br>");
            result.append(findAllByDepartment(departmentId).toString()).append("<br>---------------------<br>");
        }
        return result;
    }
}
