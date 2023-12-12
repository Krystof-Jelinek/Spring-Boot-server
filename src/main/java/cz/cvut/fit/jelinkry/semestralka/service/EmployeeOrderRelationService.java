package cz.cvut.fit.jelinkry.semestralka.service;

public interface EmployeeOrderRelationService {

    public void addOrderToEmployee(Long employeeId, Long orderId);
    public void removeOrderFromEmployee(Long employeeId, Long orderId);
}