package cz.cvut.fit.jelinkry.semestralka.domain;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
public class Employee implements EntityWithId<Long>{
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;

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