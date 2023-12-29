package cz.cvut.fit.jelinkry.semestralka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import cz.cvut.fit.jelinkry.semestralka.service.EmployeeOrderRelationService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class EmployeeOrderRelationController {

    private final EmployeeOrderRelationService employeeOrderRelationService;
    
    EmployeeOrderRelationController(EmployeeOrderRelationService in){
        employeeOrderRelationService = in;
    }

    
    @PostMapping("/employee/order/{employeeId}/{orderId}")
    public ResponseEntity<String> createEmployeeOrderRelation(@PathVariable Long employeeId, @PathVariable Long orderId){
        try{
            employeeOrderRelationService.addOrderToEmployee(employeeId, orderId);
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body("There is no order or employee with these ids");
        }
        
        return ResponseEntity.ok().body("Order with id " + orderId + " was added to employee with id " + employeeId);
    }

    @DeleteMapping("/employee/order/{employeeId}/{orderId}")
    public ResponseEntity<String> deleteEmployeeOrderRelation(@PathVariable Long employeeId, @PathVariable Long orderId){
        try{
            employeeOrderRelationService.removeOrderFromEmployee(employeeId, orderId);
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body("There is no order or employee with this id");
        }
        
        return ResponseEntity.ok().body("Order with id " + orderId + " was removed from employee with id "+ employeeId);
    }

}
