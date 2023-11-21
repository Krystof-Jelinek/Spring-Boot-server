package cz.cvut.fit.jelinkry.semestralka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.cvut.fit.jelinkry.semestralka.domain.Order;
import cz.cvut.fit.jelinkry.semestralka.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order getOrder(Long id){
        if(!orderRepository.existsById(id)){
            throw new RuntimeException("This Order doesnt exits");
        }
        return orderRepository.findById(id).get();
    }

    public Iterable<Order> getAllOrders(){
        return orderRepository.findAll();
    }


    public void create_order(Order newOrder){
        if(orderRepository.existsById(newOrder.getId())){
            throw new RuntimeException("Order with this id already exists");
        }
        orderRepository.save(newOrder);
    }

    //TODO implements crudservice
}
