package cz.cvut.fit.jelinkry.semestralka.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table
public class Employee implements EntityWithId<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    
    @ManyToMany(mappedBy = "employees", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

    public void setId(Long id) {
        this.id = id;
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