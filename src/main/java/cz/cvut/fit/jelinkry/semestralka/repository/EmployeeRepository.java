package cz.cvut.fit.jelinkry.semestralka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.jelinkry.semestralka.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

    /*
    public Employee getEmployee(Long id){
        Employee ret = new Employee();

        ret.setId(id);
        ret.setFirstName("Jop");
        ret.setLastName("novak");

        return ret;
    }*/
}