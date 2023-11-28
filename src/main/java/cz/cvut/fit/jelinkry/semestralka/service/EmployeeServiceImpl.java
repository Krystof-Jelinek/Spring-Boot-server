package cz.cvut.fit.jelinkry.semestralka.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import cz.cvut.fit.jelinkry.semestralka.domain.Employee;
import cz.cvut.fit.jelinkry.semestralka.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl extends CrudServiceImpl<Employee, Long> implements EmployeeService{
    
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository empRep){
        this.employeeRepository = empRep;
    }

    @Override
    protected CrudRepository<Employee, Long> getRepository() {
        return employeeRepository;
    }
}
