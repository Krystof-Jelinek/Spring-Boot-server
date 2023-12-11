package cz.cvut.fit.jelinkry.semestralka.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.jelinkry.semestralka.domain.Order;
import jakarta.transaction.Transactional;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

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
}