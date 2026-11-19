package spot;

import enums.VehicleType;

import java.util.Set;

public class CompactSpot extends ParkingSpot {

    public CompactSpot(String id) { super(id);}

    @Override
    public Set<VehicleType> getSupportedTypes() {
        return Set.of(VehicleType.MOTORCYCLE, VehicleType.CAR);
    }
}
