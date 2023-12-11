package cz.cvut.fit.jelinkry.semestralka.domain;

import java.time.LocalDate;

public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
