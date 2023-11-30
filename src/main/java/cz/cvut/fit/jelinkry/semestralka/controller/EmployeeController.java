package cz.cvut.fit.jelinkry.semestralka.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
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
public class EmployeeController {

    private final EmployeeService employeeService;

    //@Autowired
    EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping("/employee")
    public Employee create(@RequestBody Employee data){
        return employeeService.create(data);
    }
    
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Long id){
        Optional<Employee> tmp = employeeService.readById(id);
        if(tmp.isPresent()){
            return tmp.get();
        }
        else{
            return tmp.get();
        }
    }

    @GetMapping("/employee")
    public Iterable<Employee> getAllEmployee(){
        return employeeService.readAll();
    }

    @GetMapping("/create")
    public String tmp(){
        employeeService.create(new Employee(1L,"petr", "jeden" , LocalDate.of(2002,12,12)));
        employeeService.create(new Employee(2L,"petr", "dva" , LocalDate.of(2002,12,12)));
        employeeService.create(new Employee(3L,"petr", "tri" , LocalDate.of(2002,12,12)));

        return "Hello World";
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<String> modifyEmployee(@PathVariable Long id, @RequestBody Employee data) {
        employeeService.update(id, data);
        return ResponseEntity.ok("employee got modified succesfully");
    }

    @DeleteMapping("employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        employeeService.deleteById(id);
        return ResponseEntity.ok("employee with id: " + id + "deleted succesfully");
    }

}
