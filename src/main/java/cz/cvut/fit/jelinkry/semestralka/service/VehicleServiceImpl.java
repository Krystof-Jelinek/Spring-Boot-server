package cz.cvut.fit.jelinkry.semestralka.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import cz.cvut.fit.jelinkry.semestralka.domain.Vehicle;
import cz.cvut.fit.jelinkry.semestralka.repository.VehicleRepository;

@Service
public class VehicleServiceImpl extends CrudServiceImpl<Vehicle, Long> implements VehicleService{
    
    private VehicleRepository vehicleRepository;

    VehicleServiceImpl(VehicleRepository vhlRep){
        vehicleRepository = vhlRep;
    }

    @Override
    protected CrudRepository<Vehicle, Long> getRepository() {
        return vehicleRepository;
    }
}
