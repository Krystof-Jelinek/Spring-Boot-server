package cz.cvut.fit.jelinkry.semestralka.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    private LocalDate dateOfPayment;
    

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;


    @ManyToMany
    private List<Employee> employees;

    public Order(){
    }
    
    public Order(Long id, int cost, LocalDate date){
        this.id = id;
        this.cost = cost;
        this.dateOfPayment = date;
    }

    public Order(int cost, LocalDate date){
        this.cost = cost;
        this.dateOfPayment = date;
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
        return dateOfPayment;
    }

    public void setDate(LocalDate date) {
        this.dateOfPayment = date;
    }
}