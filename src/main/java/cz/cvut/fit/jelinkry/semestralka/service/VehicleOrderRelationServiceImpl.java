package cz.cvut.fit.jelinkry.semestralka.service;

import org.springframework.stereotype.Service;

import cz.cvut.fit.jelinkry.semestralka.repository.OrderRepository;
import cz.cvut.fit.jelinkry.semestralka.repository.VehicleRepository;

@Service
public class VehicleOrderRelationServiceImpl implements VehicleOrderRelationService{
    
    private final VehicleRepository vehicleRepository;
    private final OrderRepository orderRepository;
    
    
    VehicleOrderRelationServiceImpl(VehicleRepository vehRep, OrderRepository ordRep){
        vehicleRepository = vehRep;
        orderRepository = ordRep;
    }

    public void AddVehicleToOrder(Long vehicleId, Long orderId){
        if((!vehicleRepository.findById(vehicleId).isPresent()) || (!orderRepository.findById(orderId).isPresent())){
            throw new IllegalArgumentException("Entity with ID " + vehicleId + "or" + orderId + " not found");
        }

        orderRepository.modifyVehicleOrderAssociation(vehicleId, orderId);
    }


    public void RemoveVehicleFromOrder(Long vehicleId, Long orderId){
        if((!vehicleRepository.findById(vehicleId).isPresent()) || (!orderRepository.findById(orderId).isPresent())){
            throw new IllegalArgumentException("Entity with ID " + vehicleId + "or" + orderId + " not found");
        }

        orderRepository.removeVehicleOrderAssociation(orderId);

    }


}
