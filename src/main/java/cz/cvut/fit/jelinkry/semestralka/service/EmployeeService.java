package cz.cvut.fit.jelinkry.semestralka.service;

import org.springframework.stereotype.Service;

import cz.cvut.fit.jelinkry.semestralka.domain.Employee;
import cz.cvut.fit.jelinkry.semestralka.repository.EmployeeRepository;


@Service
public class EmployeeService{
    //TODO implements crudservice
    
    private EmployeeRepository employeeRepository;

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

    public Iterable<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public void create_employee(Employee src){
        if(employeeRepository.existsById(src.getId())){
            throw new RuntimeException("Employee with this id already exists");
        }
        employeeRepository.save(src);
    }
}
