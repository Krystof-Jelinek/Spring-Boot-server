package cz.cvut.fit.jelinkry.semestralka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.jelinkry.semestralka.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
