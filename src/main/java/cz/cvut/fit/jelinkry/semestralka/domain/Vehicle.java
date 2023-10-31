package cz.cvut.fit.jelinkry.semestralka.domain;

import jakarta.persistence.Entity;

@Entity
public class Vehicle implements EntityWithId<Long>{
    private Long id;
    private String spz;
    private String color;
    private int equipmentLevel;

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