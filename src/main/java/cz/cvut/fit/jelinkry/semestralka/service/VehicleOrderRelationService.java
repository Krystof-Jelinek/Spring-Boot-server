package cz.cvut.fit.jelinkry.semestralka.service;

public interface VehicleOrderRelationService {
    
    public void AddVehicleToOrder(Long employeeId, Long orderId);
    public void RemoveVehicleFromOrder(Long employeeId, Long orderId);

}
