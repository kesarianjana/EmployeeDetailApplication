package com.app.demo.employee_resource;

import com.app.demo.employee.Employee;
import com.app.demo.employee.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class EmployeeHandler {

    private EmployeeService employeeService;

    public Employee fetch(int id) {
        return employeeService.fetchBy(id);
    }

    public List<Employee> fetchAll() {
        return employeeService.fetchAll();
    }

    public String create(Employee employee) {
            return employeeService.create(employee);
    }

    public String update(int id, Employee employee) {return employeeService.update(id, employee);}

    public String delete(int id) {return employeeService.delete(id);}

}
