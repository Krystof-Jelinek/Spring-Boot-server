package cz.cvut.fit.jelinkry.semestralka.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import cz.cvut.fit.jelinkry.semestralka.domain.Vehicle;
import cz.cvut.fit.jelinkry.semestralka.domain.VehicleDTO;
import cz.cvut.fit.jelinkry.semestralka.repository.OrderRepository;
import cz.cvut.fit.jelinkry.semestralka.repository.VehicleRepository;

@Service
public class VehicleServiceImpl extends CrudServiceImpl<Vehicle, Long> implements VehicleService{
    
    private VehicleRepository vehicleRepository;
    private OrderRepository orderRepository;


    VehicleServiceImpl(VehicleRepository vhlRep, OrderRepository ordRep){
        vehicleRepository = vhlRep;
        orderRepository = ordRep;
    }

    @Override
    protected CrudRepository<Vehicle, Long> getRepository() {
        return vehicleRepository;
    }

    public void setVehicleWithIdToNull(Long id){
        if(!vehicleRepository.existsById(id)){
            throw new IllegalArgumentException("Vehicle with ID " + id + " not found");
        }
        orderRepository.setVehicleWithIdToNull(id);
    }

    @Override
    public void deleteById(Long id) {
        if(!vehicleRepository.existsById(id)){
            throw new IllegalArgumentException("Entity with ID " + id + " not found");
        }
        setVehicleWithIdToNull(id);
        vehicleRepository.deleteById(id);
    }

    public void updateOnlyVehicleRelated(Long id, VehicleDTO vehicle){
        vehicleRepository.updateVehicleInfo(id, vehicle.getSpz(), vehicle.getColor(), vehicle.getEquipmentLevel());
    }




}
