package cz.cvut.fit.jelinkry.semestralka.service;


import cz.cvut.fit.jelinkry.semestralka.domain.Order;
import cz.cvut.fit.jelinkry.semestralka.domain.OrderDTO;


public interface OrderService extends CrudService<Order, Long>{

    public void updateOnlyOrderRelated(Long id, OrderDTO e);
} 
