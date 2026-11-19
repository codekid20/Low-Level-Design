package model;

import enums.VehicleType;

public class VehicleFactory {

    public static Vehicle createVehicle(VehicleType type, String licensePlate){

        switch (type) {
            case CAR: return new Car(licensePlate);
            case TRUCK: return new Truck(licensePlate);
            case MOTORCYCLE: return new Motorcycle(licensePlate);
            default: throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}
