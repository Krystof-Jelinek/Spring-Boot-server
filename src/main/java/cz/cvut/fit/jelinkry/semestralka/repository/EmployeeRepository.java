package cz.cvut.fit.jelinkry.semestralka.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.jelinkry.semestralka.domain.Employee;
import jakarta.transaction.Transactional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

    @Override
    @Query("SELECT e FROM Employee e ORDER BY e.id ASC")
    Iterable<Employee> findAll();
    
    @Transactional
    @Modifying
    @Query("UPDATE Employee e SET e.firstName = :firstName, e.lastName = :lastName, e.birthDate = :birthDate WHERE e.id = :employeeId")
    void updateEmployeeInfo(
        @Param("employeeId") Long employeeId,
        @Param("firstName") String firstName,
        @Param("lastName") String lastName,
        @Param("birthDate") LocalDate birthDate
    );

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM ORDER_NOT_KEYWORD_EMPLOYEES WHERE EMPLOYEES_ID = :employeeId", nativeQuery = true)
    void deleteAllEmployeeAssociations(@Param("employeeId") Long employeeId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO ORDER_NOT_KEYWORD_EMPLOYEES (ORDERS_ID, EMPLOYEES_ID) " +
        "SELECT :orderId, :employeeId " +
        "WHERE NOT EXISTS (SELECT 1 FROM ORDER_NOT_KEYWORD_EMPLOYEES WHERE ORDERS_ID = :orderId AND EMPLOYEES_ID = :employeeId)", nativeQuery = true)
    void addEmployeeAssociation(@Param("employeeId") Long employeeId, @Param("orderId") Long orderId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM ORDER_NOT_KEYWORD_EMPLOYEES WHERE EMPLOYEES_ID = :employeeId AND ORDERS_ID = :orderId", nativeQuery = true)
    void removeEmployeeAssociations(@Param("employeeId") Long employeeId, @Param("orderId") Long orderId);


}
