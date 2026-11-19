package spot;

import enums.VehicleType;
import model.Vehicle;

import java.util.Set;

public class LargeSpot extends ParkingSpot {

    public LargeSpot(String id) { super(id);}

    @Override
    public Set<VehicleType> getSupportedTypes(){
        return Set.of(VehicleType.MOTORCYCLE, VehicleType.CAR, VehicleType.TRUCK);
    }
}
