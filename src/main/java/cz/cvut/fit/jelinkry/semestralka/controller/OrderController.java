package cz.cvut.fit.jelinkry.semestralka.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cz.cvut.fit.jelinkry.semestralka.domain.Order;
import cz.cvut.fit.jelinkry.semestralka.service.OrderService;

@Controller
public class OrderController {
    
    private final OrderService orderService;

    //@Autowired
    OrderController(OrderService inService){
        orderService = inService;
    }

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable Long id){
        return orderService.readById(id).get();
    }

    
    @GetMapping("/order")
    public Iterable<Order> getAllOrders(){
        return orderService.readAll();
    }

    @GetMapping("/idk")
    public String tmp(){
        orderService.create(new Order(1L, 2000,LocalDate.of(2000, 1, 1)));
        orderService.create(new Order(2L, 2000,LocalDate.of(2000, 1, 1)));
        orderService.create(new Order(3L, 2000,LocalDate.of(2000, 1, 1)));
        return "Hello World";
    }
}
