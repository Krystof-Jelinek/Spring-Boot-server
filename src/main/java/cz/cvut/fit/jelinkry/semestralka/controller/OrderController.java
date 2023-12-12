package cz.cvut.fit.jelinkry.semestralka.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cz.cvut.fit.jelinkry.semestralka.domain.Order;
import cz.cvut.fit.jelinkry.semestralka.domain.OrderDTO;
import cz.cvut.fit.jelinkry.semestralka.service.OrderService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class OrderController {
    
    private final OrderService orderService;

    //@Autowired
    OrderController(OrderService inService){
        orderService = inService;
    }

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO data){
        Order tmp = new Order(data.getCost(), data.getDateOfPayment());

        try{
            orderService.create(tmp);
        }
        catch(IllegalArgumentException ex){
            return ResponseEntity.badRequest().build();
        }
        

        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id){
        Optional<Order> tmp = orderService.readById(id);
        if(tmp.isPresent()){
            return ResponseEntity.ok(tmp.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/order")
    public Iterable<Order> getAllOrder(){
        return orderService.readAll();
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<String> modifyOrder(@PathVariable Long id, @RequestBody OrderDTO data) {
        if(!orderService.readById(id).isPresent()){
            return ResponseEntity.badRequest().body("There is no order with this id");
        }
        try{
            orderService.updateOnlyOrderRelated(id, data);
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        
        return ResponseEntity.ok("order got modified succesfully");
    }

    @DeleteMapping("order/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id){
        try{
            orderService.deleteById(id);
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body("There is no order with this id: " + id);
        }
        
        return ResponseEntity.ok("order with id: " + id + " deleted succesfully");
    }
}
