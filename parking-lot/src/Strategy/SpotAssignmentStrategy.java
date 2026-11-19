package Strategy;

import model.Vehicle;
import spot.ParkingFloor;
import spot.ParkingSpot;

import java.util.List;

public interface SpotAssignmentStrategy {
    ParkingSpot findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}
