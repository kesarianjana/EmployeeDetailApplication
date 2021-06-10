package com.app.demo.employee_resource;

import com.app.demo.employee.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private EmployeeHandler employeeHandler;

    @Operation(summary = "Fetch All Employees", description = "Fetch All Given employees in an organization")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "Check all fields in request!")
    })
    @GetMapping("/employee")
    public ResponseEntity<List<?>> findAll() {
        return ResponseEntity.ok().body(employeeHandler.fetchAll());
    }

    @Operation(summary = "Fetch employee by id", description = "Fetch employee with given id as path variable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "Check all fields in request!")
    })
    @GetMapping("/employee/{id}")
    public ResponseEntity<?> findById(@NonNull @PathVariable int id) {
        return ResponseEntity.ok().body(employeeHandler.fetch(id));
    }

    @Operation(summary = "Create an employee", description = "Provide values against the key in request body json")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "Record Successfully created!"),
            @ApiResponse(responseCode = "404", description = "Data Resource Not found"),
            @ApiResponse(responseCode = "400", description = "Check all fields in request!")
    })
    @PostMapping("/employee/create")
    public ResponseEntity<?> save(@NonNull @RequestBody Employee employee) {
        return ResponseEntity.ok().body(employeeHandler.create(employee));
    }

    @Operation(summary = "Update an employee Record", description = "Change the fields of an employee record")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "Record Successfully created!"),
            @ApiResponse(responseCode = "404", description = "Data Resource Not found"),
            @ApiResponse(responseCode = "400", description = "Check all fields in request!")
    })
    @PutMapping("/employee/{id}")
    public ResponseEntity<?> update(@NonNull@PathVariable int id, @NonNull@RequestBody Employee employee) {
        return ResponseEntity.ok().body(employeeHandler.update(id, employee));
    }

    @Operation(summary = "Delete an employee Record", description = "Remove Employee Details From System!")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "200", description = "Record Successfully created!"),
            @ApiResponse(responseCode = "404", description = "Data Resource Not found"),
            @ApiResponse(responseCode = "400", description = "Check all fields in request!")
    })
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return ResponseEntity.ok().body(employeeHandler.delete(id));
    }

}
