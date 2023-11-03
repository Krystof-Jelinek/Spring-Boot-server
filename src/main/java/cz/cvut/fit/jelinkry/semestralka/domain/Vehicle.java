package cz.cvut.fit.jelinkry.semestralka.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vehicle implements EntityWithId<Long>{
    @Id
    private Long id;
    private String spz;
    private String color;
    private int equipmentLevel;

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