package cz.cvut.fit.jelinkry.semestralka.RepositoryTests;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import cz.cvut.fit.jelinkry.semestralka.repository.EmployeeRepository;

@DataJpaTest
@TestPropertySource(properties = "spring.datasource.url=jdbc:h2:mem:testdb")
public class EmployeeRepositoryTest {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Test
    void isRepositoryEmptyAtInicialization(){
        assertIterableEquals(Collections.emptyList(), employeeRepository.findAll());
    }

}
