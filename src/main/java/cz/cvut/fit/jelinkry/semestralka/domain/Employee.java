package cz.cvut.fit.jelinkry.semestralka.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table
public class Employee implements EntityWithId<Long>{
    @Id
    @GeneratedValue(generator = "sequence-generator-employee")
    @GenericGenerator(
          name = "sequence-generator-employee",
          strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
          parameters = {
            @Parameter(name = "sequence_name", value = "employee_sequence"),
            @Parameter(name = "initial_value", value = "11"),
            @Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    
    @ManyToMany(mappedBy = "employees", fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"employees", "vehicle"})
    private List<Order> orders;

    public Employee(){
    }

    public Employee(Long id, String fname, String lname, LocalDate birth){
        this.id = id;
        this.firstName = fname;
        this. lastName = lname;
        this.birthDate = birth;
    }

    public Employee(String fname, String lname, LocalDate birth){
        this.firstName = fname;
        this. lastName = lname;
        this.birthDate = birth;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

}