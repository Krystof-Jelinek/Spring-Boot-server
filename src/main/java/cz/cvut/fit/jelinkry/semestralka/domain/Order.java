package cz.cvut.fit.jelinkry.semestralka.domain;

import java.util.List;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderNotKeyword") //Order is key word that creates a colision here
public class Order implements EntityWithId<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cost;
    private LocalDate date;
    
    @ManyToOne
    private Vehicle vehicle;

    @ManyToMany
    private List<Employee> employees;

    public Order(){
    }
    
    public Order(Long id, int cost, LocalDate date){
        this.id = id;
        this.cost = cost;
        this.date = date;
    }

    public Order(int cost, LocalDate date){
        this.cost = cost;
        this.date = date;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }
    
    public void setCost(int cost) {
        this.cost = cost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}