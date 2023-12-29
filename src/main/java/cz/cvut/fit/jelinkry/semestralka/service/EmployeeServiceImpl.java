package cz.cvut.fit.jelinkry.semestralka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import cz.cvut.fit.jelinkry.semestralka.domain.Employee;
import cz.cvut.fit.jelinkry.semestralka.domain.EmployeeDTO;
import cz.cvut.fit.jelinkry.semestralka.repository.EmployeeRepository;
import jakarta.transaction.Transactional;


@Service
public class EmployeeServiceImpl extends CrudServiceImpl<Employee, Long> implements EmployeeService{
    
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository empRep){
        this.employeeRepository = empRep;
    }

    @Override
    protected CrudRepository<Employee, Long> getRepository() {
        return employeeRepository;
    }

    @Override
    public void updateOnlyEmployeeRelated(Long id, EmployeeDTO e) {
        employeeRepository.updateEmployeeInfo(id , e.getFirstName(), e.getLastName(), e.getBirthDate());
    }

    @Transactional
    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Employee not found with id: " + id));

        employeeRepository.deleteAllEmployeeAssociations(id);

        employeeRepository.delete(employee);
    }
    
}
