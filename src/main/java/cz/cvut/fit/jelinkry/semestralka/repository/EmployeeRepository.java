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
    
    @Transactional
    @Modifying
    @Query("UPDATE Employee e SET e.firstName = :firstName, e.lastName = :lastName, e.birthDate = :birthDate WHERE e.id = :employeeId")
    void updateEmployeeInfo(
        @Param("employeeId") Long employeeId,
        @Param("firstName") String firstName,
        @Param("lastName") String lastName,
        @Param("birthDate") LocalDate birthDate
    );

}
