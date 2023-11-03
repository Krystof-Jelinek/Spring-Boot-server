package cz.cvut.fit.jelinkry.semestralka.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import cz.cvut.fit.jelinkry.semestralka.domain.Employee;
import cz.cvut.fit.jelinkry.semestralka.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    //@Autowired
    EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployee(Long id){
        if(!employeeRepository.existsById(id)){
            throw new RuntimeException("This employee doesnt exits");
        }
        return employeeRepository.findById(id).get();

    }

    public void create_employee(){
        LocalDate datum = LocalDate.of(2000, 10, 12);
        Employee tmp = new Employee(1L, "jemno", "jop", datum);
        employeeRepository.save(tmp);
    }
}
