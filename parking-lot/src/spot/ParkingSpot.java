package spot;

import enums.SpotStatus;
import enums.VehicleType;
import model.Vehicle;
import java.util.Set;

public abstract class ParkingSpot {

    protected final String id;
    protected SpotStatus status = SpotStatus.FREE;
    protected Vehicle parkedVehicle;

    protected ParkingSpot(String id) { this.id = id; }
    public abstract Set<VehicleType> getSupportedTypes();

    public boolean canFit(Vehicle vehicle) {
        return status == SpotStatus.FREE && getSupportedTypes().contains(vehicle.getType());
    }

    public void assignVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        this.status = SpotStatus.OCCUPIED;
    }

    public void removeVehicle() {
        this.parkedVehicle = null;
        this.status = SpotStatus.FREE;
    }

    public String getId() { return id; }
    public SpotStatus getStatus() { return status; }
}
