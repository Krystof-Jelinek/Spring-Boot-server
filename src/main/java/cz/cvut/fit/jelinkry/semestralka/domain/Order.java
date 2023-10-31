package cz.cvut.fit.jelinkry.semestralka.domain;

import java.sql.Date;

import jakarta.persistence.Entity;

@Entity
public class Order implements EntityWithId<Long>{
    
    private Long id;
    private int cost;
    private Date date;
    
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