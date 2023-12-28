package cz.cvut.fit.jelinkry.semestralka.ControllerTests;

import static org.mockito.Mockito.doThrow;

import java.time.LocalDate;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import cz.cvut.fit.jelinkry.semestralka.controller.EmployeeController;
import cz.cvut.fit.jelinkry.semestralka.domain.Employee;
import cz.cvut.fit.jelinkry.semestralka.service.EmployeeService;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    void createEmployeeTest() throws Exception{
        var emp = new Employee("Jakub", "Durkovic", LocalDate.of(2003, 7, 9));
        Mockito.when(employeeService.create(Mockito.any())).thenReturn(emp);
        
        mockMvc.perform(
            MockMvcRequestBuilders
            .post("/employee")
            .contentType(MediaType.APPLICATION_JSON)
            .content
            ("""
                {
                    "firstName": "Jakub",
                    "lastName": "Durkovic",
                    "birthDate": "2003-07-09"
                }
            """)
        )
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.firstName", Matchers.is("Jakub")))
        .andExpect(MockMvcResultMatchers.jsonPath("$.lastName", Matchers.is("Durkovic")))
        .andExpect(MockMvcResultMatchers.jsonPath("$.birthDate", Matchers.is("2003-07-09")));

    }

    @Test
    void deleteEmployeeTestFailed() throws Exception{
        var emp = new Employee(1L,"Jakub", "Durkovic", LocalDate.of(2003, 7, 9));
        doThrow(new IllegalArgumentException("Employee not found with id: " + emp.getId())).when(employeeService).deleteEmployee(emp.getId());

         mockMvc.perform(
            MockMvcRequestBuilders
            .delete("/employee/" + emp.getId())
            .contentType(MediaType.APPLICATION_JSON)
        )
        .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }

}
