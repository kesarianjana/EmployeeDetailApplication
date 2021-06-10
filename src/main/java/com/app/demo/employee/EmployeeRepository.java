package com.app.demo.employee;

import java.util.List;

public interface EmployeeRepository {
    String create(Employee employee);

    Employee fetchBy(Integer employeeId);

    List<Employee> fetchAll();

    String update(int id, Employee employee);

    String delete(int id);
}
