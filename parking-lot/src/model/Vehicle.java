package model;

import enums.VehicleType;

public abstract class Vehicle {
    protected final String licensePlate;
    protected final VehicleType type;

    protected Vehicle(String licensePlate, VehicleType type){
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate() { return licensePlate; }
    public VehicleType getType() { return type; }
}
