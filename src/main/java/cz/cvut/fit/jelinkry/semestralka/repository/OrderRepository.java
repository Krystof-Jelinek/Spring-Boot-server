package cz.cvut.fit.jelinkry.semestralka.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.jelinkry.semestralka.domain.Order;
import jakarta.transaction.Transactional;
import java.util.List;


@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

    List<Order> findByCost(int cost);

    @Override
    @Query("SELECT o FROM Order o ORDER BY o.id ASC")
    Iterable<Order> findAll();

    @Transactional
    @Modifying
    @Query("UPDATE Order o SET o.cost = :cost, o.dateOfPayment = :dateOfPayment WHERE o.id = :orderId")
    void updateOrderInfo(
        @Param("orderId") Long orderId,
        @Param("cost") int cost,
        @Param("dateOfPayment") LocalDate dateOfPayment
    );

    @Transactional
    @Modifying
    @Query("UPDATE Order o SET o.vehicle = null WHERE o.vehicle.id = :id")
    void setVehicleWithIdToNull(@Param("id") Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ORDER_NOT_KEYWORD SET VEHICLE_ID = :vehicleId WHERE ID = :orderId", nativeQuery = true)
    void modifyVehicleOrderAssociation(@Param("vehicleId") Long vehicleId, @Param("orderId") Long orderId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ORDER_NOT_KEYWORD SET VEHICLE_ID = null WHERE ID = :orderId", nativeQuery = true)
    void removeVehicleOrderAssociation(@Param("orderId") Long orderId);
}