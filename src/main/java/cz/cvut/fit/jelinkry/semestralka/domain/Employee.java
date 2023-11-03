package cz.cvut.fit.jelinkry.semestralka.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table
public class Employee implements EntityWithId<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    
    @ManyToMany
    @JoinTable(name = "employee_order",
               joinColumns = @JoinColumn(name = "employee_id"),
               inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Set<Order> orders = new HashSet<>();

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