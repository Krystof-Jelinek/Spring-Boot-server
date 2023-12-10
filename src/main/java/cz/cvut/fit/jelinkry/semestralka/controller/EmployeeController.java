package cz.cvut.fit.jelinkry.semestralka.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cz.cvut.fit.jelinkry.semestralka.domain.Employee;
import cz.cvut.fit.jelinkry.semestralka.service.EmployeeService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class EmployeeController {

    private final EmployeeService employeeService;

    //@Autowired
    EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    
    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee data){
        try{
            employeeService.create(data);
        }
        catch(IllegalArgumentException ex){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        Optional<Employee> tmp = employeeService.readById(id);
        if(tmp.isPresent()){
            return ResponseEntity.ok(tmp.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    
    @GetMapping("/employee")
    public Iterable<Employee> getAllEmployee(){
        return employeeService.readAll();
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<String> modifyEmployee(@PathVariable Long id, @RequestBody Employee data) {
        if(id != data.getId()){
            return ResponseEntity.badRequest().body("You cant modify the id of employee");
        }
        try{
            employeeService.update(id, data);
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("employee got modified succesfully");
    }

    @DeleteMapping("employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        try{
            employeeService.deleteById(id);
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body("There is no employee with this id: " + id);
        }
        return ResponseEntity.ok("employee with id: " + id + " deleted succesfully");
    }

}
