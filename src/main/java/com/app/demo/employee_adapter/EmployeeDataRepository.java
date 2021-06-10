package com.app.demo.employee_adapter;

import com.app.demo.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDataRepository extends JpaRepository<Employee, Integer> {

}
