package spot;

import enums.VehicleType;
import model.Vehicle;

import java.util.Set;

public class MotorcycleSpot extends ParkingSpot {

    public MotorcycleSpot(String id) { super(id); }

    @Override
    public Set<VehicleType> getSupportedTypes() { return Set.of(VehicleType.MOTORCYCLE); }
}
