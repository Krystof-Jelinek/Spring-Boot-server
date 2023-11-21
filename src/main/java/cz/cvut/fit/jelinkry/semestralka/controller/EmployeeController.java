package cz.cvut.fit.jelinkry.semestralka.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cz.cvut.fit.jelinkry.semestralka.domain.Employee;
import cz.cvut.fit.jelinkry.semestralka.service.EmployeeService;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    //@Autowired
    EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    @GetMapping("/employee")
    public Iterable<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/")
    public String tmp(){
        employeeService.create_employee(new Employee(1L,"petr", "jeden" , LocalDate.of(2002,12,12)));
        employeeService.create_employee(new Employee(2L,"petr", "dva" , LocalDate.of(2002,12,12)));
        employeeService.create_employee(new Employee(3L,"petr", "tri" , LocalDate.of(2002,12,12)));
        return "Hello World";
    }

}
