package com.app.demo.employee_resource;

import com.app.demo.employee.Employee;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeControllerTest {
    private static final String SUCCESS_MESSAGE = "Record Creation Successful!";
    private static final String UPDATE_SUCCESS_MESSAGE = "Record Update Successful!";
    private static final String DELETE_SUCCESS_MESSAGE = "Record Delete Successful!";

    private MockMvc mockMvc;

    @Mock
    private EmployeeHandler employeeHandler;

    @InjectMocks
    private EmployeeController employeeController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    public void testShouldReturnSuccessResponseForGetEmployees() throws Exception {
        //Given
        Employee employee1 = Employee.builder()
                .id(1)
                .firstName("Anjana")
                .lastName("Kesari")
                .dateOfJoining(LocalDate.now())
                .teamName("C2E")
                .performanceRating("A1")
                .build();
        Employee employee2 = Employee.builder()
                .id(1)
                .firstName("Elsa")
                .lastName("Frozen")
                .dateOfJoining(LocalDate.now())
                .teamName("C2E")
                .performanceRating("A2")
                .build();
        Mockito.when(employeeHandler.fetchAll()).thenReturn(List.of(employee1, employee2));

        //When
        mockMvc.perform(get("/employee"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[0].firstName", Matchers.is("Anjana")))
                .andExpect(jsonPath("$[1].firstName", Matchers.is("Elsa")));

    }

    @Test
    public void testShouldReturnSuccessResponseForGetEmployeeById() throws Exception {
        //Given
        LocalDate date = LocalDate.of(2019,4,9);
        Employee employee1 = Employee.builder()
                .id(1)
                .firstName("Anjana")
                .lastName("Kesari")
                .dateOfJoining(date)
                .teamName("C2E")
                .performanceRating("A1")
                .build();
        Mockito.when(employeeHandler.fetch(anyInt())).thenReturn(employee1);

        //When
        mockMvc.perform(get("/employee/{id}",1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", Matchers.is("Anjana")))
                .andExpect(jsonPath("$.lastName", Matchers.is("Kesari")))
//                .andExpect(jsonPath("$.dateOfJoining", Matchers.is(date)))
                .andExpect(jsonPath("$.teamName", Matchers.is("C2E")))
                .andExpect(jsonPath("$.performanceRating", Matchers.is("A1")));

    }

    @Test
    public void testShouldReturnSuccessResponseForCreateEmployee() throws Exception {
        //Given
        String empJson = "{\n" +
                "   \"firstName\":\"Anjana\",\n" +
                "   \"lastName\":\"Kesari\",\n" +
                "   \"performanceRating\":\"A1\",\n" +
                "   \"teamName\":\"C2E\",\n" +
                "   \"dateOfJoining\":\"2021-06-09\"\n" +
                "}";
        Mockito.when(employeeHandler.create(any())).thenReturn("Record Creation Successful!");

        //When
        mockMvc.perform(post("/employee/create").contentType("application/json").content(empJson))
                .andExpect(status().isOk())
                .andExpect(content().string(SUCCESS_MESSAGE));

    }

    @Test
    public void testShouldReturnSuccessResponseForUpdateEmployee() throws Exception {
        //Given
        String empJson = "{\n" +
                "   \"firstName\":\"Anjana\",\n" +
                "   \"lastName\":\"Kesari\",\n" +
                "   \"performanceRating\":\"A1\",\n" +
                "   \"teamName\":\"I&I\",\n" +
                "   \"dateOfJoining\":\"2021-06-09\"\n" +
                "}";
        Mockito.when(employeeHandler.update(anyInt(), any())).thenReturn("Record Update Successful!");

        //When
        mockMvc.perform(put("/employee/{id}",1).contentType("application/json").content(empJson))
                .andExpect(status().isOk())
                .andExpect(content().string(UPDATE_SUCCESS_MESSAGE));

    }

    @Test
    public void testShouldReturnSuccessResponseForDeleteEmployee() throws Exception {
        //Given
        String empJson = "{\n" +
                "   \"firstName\":\"Anjana\",\n" +
                "   \"lastName\":\"Kesari\",\n" +
                "   \"performanceRating\":\"A1\",\n" +
                "   \"teamName\":\"I&I\",\n" +
                "   \"dateOfJoining\":\"2021-06-09\"\n" +
                "}";
        Mockito.when(employeeHandler.delete(anyInt())).thenReturn("Record Delete Successful!");

        //When
        mockMvc.perform(delete("/employee/{id}",1).contentType("application/json").content(empJson))
                .andExpect(status().isOk())
                .andExpect(content().string(DELETE_SUCCESS_MESSAGE));

    }

}