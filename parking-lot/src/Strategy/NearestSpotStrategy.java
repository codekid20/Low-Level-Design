package Strategy;

import com.sun.source.tree.BreakTree;
import model.Vehicle;
import spot.ParkingFloor;
import spot.ParkingSpot;

import java.util.List;

public class NearestSpotStrategy implements SpotAssignmentStrategy{

    @Override
    public ParkingSpot findSpot(List<ParkingFloor> floors, Vehicle vehicle){
        for (ParkingFloor floor : floors){
            for (ParkingSpot spot: floor.getSpots()){
                if (spot.canFit(vehicle)) return spot;
            }
        }

        return null;
    }
}
