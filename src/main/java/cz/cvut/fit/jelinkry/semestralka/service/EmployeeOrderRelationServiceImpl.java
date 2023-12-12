package cz.cvut.fit.jelinkry.semestralka.service;

import org.springframework.stereotype.Service;

import cz.cvut.fit.jelinkry.semestralka.repository.EmployeeRepository;
import cz.cvut.fit.jelinkry.semestralka.repository.OrderRepository;

@Service
public class EmployeeOrderRelationServiceImpl implements EmployeeOrderRelationService{
    private final EmployeeRepository employeeRepository;
    private final OrderRepository orderRepository;

    EmployeeOrderRelationServiceImpl(EmployeeRepository empRep, OrderRepository ordRep){
        employeeRepository = empRep;
        orderRepository = ordRep;
    }

    @Override
    public void addOrderToEmployee(Long employeeId, Long orderId){
        if((!employeeRepository.findById(employeeId).isPresent()) || (!orderRepository.findById(orderId).isPresent())){
            throw new IllegalArgumentException("Entity with ID " + employeeId + "or" + orderId + " not found");
        }

        employeeRepository.addEmployeeAssociation(employeeId, orderId);

    }

    @Override
    public void removeOrderFromEmployee(Long employeeId, Long orderId){
        if((!employeeRepository.findById(employeeId).isPresent()) || (!orderRepository.findById(orderId).isPresent())){
            throw new IllegalArgumentException("Entity with ID " + employeeId + "or" + orderId + " not found");
        }
        employeeRepository.removeEmployeeAssociations(employeeId, orderId);
    }

}
