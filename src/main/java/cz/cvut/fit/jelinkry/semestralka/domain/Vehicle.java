package cz.cvut.fit.jelinkry.semestralka.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Vehicle implements EntityWithId<Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String spz;
    private String color;
    private int equipmentLevel;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Order> orders = new ArrayList<>();

    public Vehicle(){
    }

    public Vehicle(Long id, String spz, String color, int equipmentLevel){
        this.id = id;
        this.spz = spz;
        this.color = color;
        this.equipmentLevel = equipmentLevel;
    }

    public Vehicle(String spz, String color, int equipmentLevel){
        this.spz = spz;
        this.color = color;
        this.equipmentLevel = equipmentLevel;
    }

    @Override
    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpz() {
        return spz;
    }

    public void setSpz(String spz) {
        this.spz = spz;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEquipmentLevel() {
        return equipmentLevel;
    }

    public void setEquipmentLevel(int equipmentLevel) {
        this.equipmentLevel = equipmentLevel;
    }
}