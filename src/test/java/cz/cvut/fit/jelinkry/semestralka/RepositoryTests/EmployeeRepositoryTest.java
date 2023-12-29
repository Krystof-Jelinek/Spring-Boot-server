package cz.cvut.fit.jelinkry.semestralka.RepositoryTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import cz.cvut.fit.jelinkry.semestralka.domain.Order;
import cz.cvut.fit.jelinkry.semestralka.repository.OrderRepository;

@DataJpaTest
public class EmployeeRepositoryTest {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Test
    void isRepositoryEmptyAtInicialization(){
        assertIterableEquals(Collections.emptyList(), orderRepository.findAll());
    }

    @Test
    void findByCostTest(){
        Order first = new Order(1000, LocalDate.of(2000, 2, 2));
        Order second = new Order(1000, LocalDate.of(2001,2 ,2));
        Order third = new Order(500, LocalDate.of(2002,2 ,2));
        
        orderRepository.save(first);
        orderRepository.save(second);
        orderRepository.save(third);

        assertEquals(1000, orderRepository.findById(1L).orElseThrow().getCost());
        assertEquals(1000, orderRepository.findById(2L).orElseThrow().getCost());
        assertEquals(500, orderRepository.findById(3L).orElseThrow().getCost());
        
        assertNull(orderRepository.findById(11L).orElse(null));
        assertNull(orderRepository.findById(4L).orElse(null));

        assertFalse(orderRepository.findByCost(1000).isEmpty());
        assertFalse(orderRepository.findByCost(500).isEmpty());

        assertTrue(orderRepository.findByCost(999).isEmpty());
        assertTrue(orderRepository.findByCost(1001).isEmpty());
        assertTrue(orderRepository.findByCost(1).isEmpty());

        assertEquals(2, orderRepository.findByCost(1000).size());
        assertEquals(1,orderRepository.findByCost(500).size());

        List<Order> res = orderRepository.findByCost(1000);

        assertTrue(res.contains(first));
        assertTrue(res.contains(second));

        assertFalse(res.contains(third));

    }

    @Test
    void findByCostTestWhenRepoEmpty(){
        assertTrue(orderRepository.findByCost(1000).isEmpty());
    }

}
