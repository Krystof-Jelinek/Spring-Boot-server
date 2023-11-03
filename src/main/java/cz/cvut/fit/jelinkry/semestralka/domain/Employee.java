package cz.cvut.fit.jelinkry.semestralka.domain;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
public class Employee implements EntityWithId<Long>{
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;

    public Employee(){
    }

    public Employee(Long id, String fname, String lname, Date birth){
        this.id = id;
        this.firstName = fname;
        this. lastName = lname;
        this.birthDate = birth;
    }

    public Employee(String fname, String lname, Date birth){
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}