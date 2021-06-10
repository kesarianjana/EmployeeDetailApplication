package com.app.demo.spring_adapter;

import com.app.demo.employee.EmployeeRepository;
import com.app.demo.employee.EmployeeService;
import com.app.demo.employee.EmployeeServiceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    @Bean
    public EmployeeService employeeService(EmployeeRepository employeeRepository) {
        return new EmployeeServiceAdapter(employeeRepository);
    }
}
