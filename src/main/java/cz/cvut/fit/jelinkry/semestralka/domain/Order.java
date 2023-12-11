package cz.cvut.fit.jelinkry.semestralka.domain;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderNotKeyword") //Order is key word that creates a colision here
public class Order implements EntityWithId<Long>{
    @Id
    @GeneratedValue(generator = "sequence-generator-order")
    @GenericGenerator(
          name = "sequence-generator-order",
          strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
          parameters = {
            @Parameter(name = "sequence_name", value = "user_sequence"),
            @Parameter(name = "initial_value", value = "11"),
            @Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;
    private int cost;
    private LocalDate dateOfPayment;
    

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id", nullable = false)
    @JsonManagedReference
    @JsonIgnoreProperties("orders")
    private Vehicle vehicle;
    
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("orders")
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
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