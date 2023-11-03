package cz.cvut.fit.jelinkry.semestralka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.jelinkry.semestralka.domain.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

    
}