package cz.cvut.fit.jelinkry.semestralka.RepositoryTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import cz.cvut.fit.jelinkry.semestralka.domain.Employee;
import cz.cvut.fit.jelinkry.semestralka.repository.EmployeeRepository;

@DataJpaTest
public class EmployeeRepositoryTest {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Test
    void isRepositoryEmptyAtInicialization(){
        //assertIterableEquals(Collections.emptyList(), employeeRepository.findAll());
        Optional<Employee> foundEmployee = employeeRepository.findById(1L);
        assertEquals("John", foundEmployee.get().getFirstName());
    }

}
