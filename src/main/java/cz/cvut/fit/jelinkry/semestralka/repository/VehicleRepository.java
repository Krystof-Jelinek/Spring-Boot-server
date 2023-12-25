package cz.cvut.fit.jelinkry.semestralka.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.jelinkry.semestralka.domain.Vehicle;
import jakarta.transaction.Transactional;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long>{
    
    @Transactional
    @Modifying
    @Query("UPDATE Vehicle v SET v.spz = :spz, v.color = :color, v.equipmentLevel = :equipmentLevel WHERE v.id = :vehicleId")
    void updateVehicleInfo(
        @Param("vehicleId") Long vehicleId,
        @Param("spz") String spz,
        @Param("color") String color,
        @Param("equipmentLevel") int equipmentLevel
    );

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM VEHICLE v WHERE v.id NOT IN (SELECT DISTINCT o.vehicle_id FROM ORDER_NOT_KEYWORD o WHERE o.vehicle_id IS NOT NULL)", nativeQuery = true)
    void deleteVehiclesThatAreNotInAnyOrder();


}
