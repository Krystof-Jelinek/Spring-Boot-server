package cz.cvut.fit.jelinkry.semestralka.domain;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Order implements EntityWithId<Long>{
    @Id
    private Long id;
    private int cost;
    private Date date;

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