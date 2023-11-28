package cz.cvut.fit.jelinkry.semestralka.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import cz.cvut.fit.jelinkry.semestralka.domain.Order;
import cz.cvut.fit.jelinkry.semestralka.repository.OrderRepository;

@Service
public class OrderServiceImpl extends CrudServiceImpl<Order, Long> implements OrderService{
    
    private OrderRepository orderRepository;

    OrderServiceImpl(OrderRepository ordRep){
        orderRepository = ordRep;
    }

    @Override
    protected CrudRepository<Order, Long> getRepository() {
        return orderRepository;
    }

}
