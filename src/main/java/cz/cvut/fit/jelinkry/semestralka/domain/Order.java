package cz.cvut.fit.jelinkry.semestralka.domain;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Order implements EntityWithId<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cost;
    private Date date;
    
    @ManyToOne
    private Vehicle vehicle;
    @ManyToMany(mappedBy = "orders")
    private Set<Employee> employees = new HashSet<>();

    public Order(){
    }
    
    public Order(Long id, int cost, Date date){
        this.id = id;
        this.cost = cost;
        this.date = date;
    }

    public Order(int cost, Date date){
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}