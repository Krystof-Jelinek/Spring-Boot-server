package cz.cvut.fit.jelinkry.semestralka.domain;

import java.time.LocalDate;

public class OrderDTO {
    private int cost;
    private LocalDate dateOfPayment;

    public OrderDTO(int cost, LocalDate dateOfPayment) {
        this.cost = cost;
        this.dateOfPayment = dateOfPayment;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public LocalDate getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDate dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }
}
