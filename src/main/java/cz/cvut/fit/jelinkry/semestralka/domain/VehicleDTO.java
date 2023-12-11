package cz.cvut.fit.jelinkry.semestralka.domain;

public class VehicleDTO {
    private String spz;
    private String color;
    private int equipmentLevel;

    public VehicleDTO(String spz, String color, int equipmentLevel) {
        this.spz = spz;
        this.color = color;
        this.equipmentLevel = equipmentLevel;
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
