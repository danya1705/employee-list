package pro.sky.java.course2.employeelist.service;

import pro.sky.java.course2.employeelist.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeeList();

    Employee addEmployee(String firstName, String lastName, int departmentId, double salary);

    Employee findEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee getMaxSalaryByDepartment(int departmentId);

    Employee getMinSalaryByDepartment(int departmentId);

    List<Employee> findAllByDepartment(int departmentId);

    StringBuilder printAllByDepartments();

    void checkNames(String firstName, String lastName);
}
