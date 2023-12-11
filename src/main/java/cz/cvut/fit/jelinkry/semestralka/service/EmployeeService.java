package cz.cvut.fit.jelinkry.semestralka.service;


import cz.cvut.fit.jelinkry.semestralka.domain.Employee;
import cz.cvut.fit.jelinkry.semestralka.domain.EmployeeDTO;


public interface EmployeeService extends CrudService<Employee, Long>{

    public void updateOnlyEmployeeRelated(Long id, EmployeeDTO e);
    public void deleteEmployee(Long id);

}
