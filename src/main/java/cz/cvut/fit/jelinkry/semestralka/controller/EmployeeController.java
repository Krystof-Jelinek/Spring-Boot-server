package cz.cvut.fit.jelinkry.semestralka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cz.cvut.fit.jelinkry.semestralka.domain.Employee;

@RestController
public class EmployeeController {
    
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Long id){
        Employee ret = new Employee();

        ret.setId(id);
        ret.setFirstName("Jop");
        ret.setLastName("novak");

        return ret;
    }

    @GetMapping("/")
    public String tmp(){
        return "Hello World";
    }

}
