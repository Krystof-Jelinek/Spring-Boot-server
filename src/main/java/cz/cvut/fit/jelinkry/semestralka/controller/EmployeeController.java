package cz.cvut.fit.jelinkry.semestralka.controller;

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

    @GetMapping("/")
    public String tmp(){
        employeeService.create_employee();
        return "Hello World";
    }

}
