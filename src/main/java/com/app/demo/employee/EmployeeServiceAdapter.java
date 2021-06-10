package com.app.demo.employee;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class EmployeeServiceAdapter implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Override
    public String create(Employee employee) {
        return employeeRepository.create(employee);
    }

    @Override
    public Employee fetchBy(Integer employeeId) {
       return employeeRepository.fetchBy(employeeId);
    }

    @Override
    public List<Employee> fetchAll() {
        return employeeRepository.fetchAll();
    }

    @Override
    public String update(int id, Employee employee) { return employeeRepository.update(id, employee);}

    @Override
    public String delete(int id) { return employeeRepository.delete(id);}
}
