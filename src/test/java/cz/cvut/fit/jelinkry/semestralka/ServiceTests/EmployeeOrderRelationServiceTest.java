package cz.cvut.fit.jelinkry.semestralka.ServiceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cz.cvut.fit.jelinkry.semestralka.domain.Employee;
import cz.cvut.fit.jelinkry.semestralka.domain.Order;
import cz.cvut.fit.jelinkry.semestralka.repository.EmployeeRepository;
import cz.cvut.fit.jelinkry.semestralka.repository.OrderRepository;
import cz.cvut.fit.jelinkry.semestralka.service.EmployeeOrderRelationService;

@SpringBootTest
public class EmployeeOrderRelationServiceTest {
    
    @Autowired
    private EmployeeOrderRelationService employeeOrderRelationService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @MockBean
    private OrderRepository orderRepository;

    @Test
    void addOrderToEmployeeSuccess(){
        Employee employee = new Employee(1L,"Jakub", "Durkovic", LocalDate.of(2003, 9, 7));
        Order order = new Order(1L,500, LocalDate.of(2000, 2, 2));

        Mockito.when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));
        Mockito.when(orderRepository.findById(order.getId())).thenReturn(Optional.of(order));

        employeeOrderRelationService.addOrderToEmployee(employee.getId(), order.getId());

        Mockito.verify(employeeRepository, Mockito.times(1)).addEmployeeAssociation(Mockito.any(), Mockito.any());
        Mockito.verify(employeeRepository, Mockito.times(1)).findById(Mockito.any());
        Mockito.verify(orderRepository, Mockito.times(1)).findById(Mockito.any());

    }

    @Test
    void addOrderToEmployeeInvalidEmployeeIdThrowsException(){
        Employee employee = new Employee(1L,"Jakub", "Durkovic", LocalDate.of(2003, 9, 7));
        Order order = new Order(1L,500, LocalDate.of(2000, 2, 2));

        Mockito.when(employeeRepository.findById(employee.getId())).thenReturn(Optional.empty());
        //simulationg that the employee is not in repository so it should throw exception
        Mockito.when(orderRepository.findById(order.getId())).thenReturn(Optional.of(order));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            employeeOrderRelationService.addOrderToEmployee(employee.getId(), order.getId());
        });

        assertEquals("Entity with ID " + employee.getId() + " or " + order.getId() + " not found", exception.getMessage());

        Mockito.verify(employeeRepository, Mockito.never()).addEmployeeAssociation(Mockito.any(), Mockito.any());
        Mockito.verify(employeeRepository, Mockito.times(1)).findById(Mockito.any());
        //it already failed at the first
        Mockito.verify(orderRepository, Mockito.never()).findById(Mockito.any());

    }

    @Test
    void addOrderToEmployeeInvalidOrderIdThrowsException(){
        Employee employee = new Employee(1L,"Jakub", "Durkovic", LocalDate.of(2003, 9, 7));
        Order order = new Order(1L,500, LocalDate.of(2000, 2, 2));

        Mockito.when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));
        Mockito.when(orderRepository.findById(order.getId())).thenReturn(Optional.empty());
        //simulationg that the order is not in repository so it should throw exception

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            employeeOrderRelationService.addOrderToEmployee(employee.getId(), order.getId());
        });

        assertEquals("Entity with ID " + employee.getId() + " or " + order.getId() + " not found", exception.getMessage());

        Mockito.verify(employeeRepository, Mockito.never()).addEmployeeAssociation(Mockito.any(), Mockito.any());
        Mockito.verify(employeeRepository, Mockito.times(1)).findById(Mockito.any());
        Mockito.verify(orderRepository, Mockito.times(1)).findById(Mockito.any());
        //now it failed after the second condition so it should invoke both methods
    }

    @Test
    void addOrderToEmployeeInvalidOrderIdAndEmployeeIdThrowsException(){
        Employee employee = new Employee(1L,"Jakub", "Durkovic", LocalDate.of(2003, 9, 7));
        Order order = new Order(1L,500, LocalDate.of(2000, 2, 2));

        Mockito.when(employeeRepository.findById(employee.getId())).thenReturn(Optional.empty());
        Mockito.when(orderRepository.findById(order.getId())).thenReturn(Optional.empty());
        //simulationg that both the order and employee is not in repository so it should throw exception

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            employeeOrderRelationService.addOrderToEmployee(employee.getId(), order.getId());
        });

        assertEquals("Entity with ID " + employee.getId() + " or " + order.getId() + " not found", exception.getMessage());

        Mockito.verify(employeeRepository, Mockito.never()).addEmployeeAssociation(Mockito.any(), Mockito.any());
        Mockito.verify(employeeRepository, Mockito.times(1)).findById(Mockito.any());
        //it already failed at the first
        Mockito.verify(orderRepository, Mockito.never()).findById(Mockito.any());

    }


}
