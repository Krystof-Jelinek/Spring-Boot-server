package cz.cvut.fit.jelinkry.semestralka.service;


import cz.cvut.fit.jelinkry.semestralka.domain.Employee;


public interface EmployeeService extends CrudService<Employee, Long>{

    public void updateOnlyEmployeeRelated(Long id, Employee e);

}
