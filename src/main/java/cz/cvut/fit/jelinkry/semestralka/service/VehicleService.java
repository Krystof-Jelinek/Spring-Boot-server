package cz.cvut.fit.jelinkry.semestralka.service;

import cz.cvut.fit.jelinkry.semestralka.domain.Vehicle;
import cz.cvut.fit.jelinkry.semestralka.domain.VehicleDTO;

public interface VehicleService extends CrudService<Vehicle, Long>{

    public void setVehicleWithIdToNull(Long id);
    public void updateOnlyVehicleRelated(Long id, VehicleDTO vehicle);
} 
