package com.app.demo.employee_adapter;

import com.app.demo.employee.Employee;
import com.app.demo.employee.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.webjars.NotFoundException;

import java.util.List;

@AllArgsConstructor
@Component
@Slf4j
public class EmployeeAdapter implements EmployeeRepository {

    private static final String JPA_EXCEPTION = "Exception occurred while saving employee into DB!";
    private static final String SUCCESS_MESSAGE = "Record Creation Successful!";
    private static final String SUCCESSFUL_UPDATE_MESSAGE = "Record Updation Successful!";
    private static final String SUCCESSFUL_DELETION_MESSAGE = "Record Deletion Successful!";
    private static final String FAILURE_MESSAGE = "Record Creation Failed!";

    private final EmployeeDataRepository employeeDataRepository;

    @Override
    public String create(Employee employee) {
        try {
             employeeDataRepository.save(employee);
             return SUCCESS_MESSAGE;
        } catch (Exception e) {
            log.error(JPA_EXCEPTION, e);
            return FAILURE_MESSAGE;
        }
    }

    @Override
    public Employee fetchBy(Integer employeeId) {
      return employeeDataRepository.findById(employeeId).
              orElseThrow(() -> new NotFoundException("Employee not found for id : " + employeeId +"!"));

    }

    @Override
    public List<Employee> fetchAll() {
        return employeeDataRepository.findAll();
    }

    @Override
        public String update(int id, Employee employee) {
        employeeDataRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found for id : " + id+"!"));

        Employee modifiedEmployee = Employee.builder()
                .id(id)
                .dateOfJoining(employee.getDateOfJoining())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .performanceRating(employee.getPerformanceRating())
                .teamName(employee.getTeamName())
                .build();
         employeeDataRepository.save(modifiedEmployee);
         return SUCCESSFUL_UPDATE_MESSAGE;
    }

    @Override
    public String delete(int id) {
        employeeDataRepository.findById(id).ifPresent(Employee -> employeeDataRepository.delete(Employee));
        return SUCCESSFUL_DELETION_MESSAGE;
    }
}
