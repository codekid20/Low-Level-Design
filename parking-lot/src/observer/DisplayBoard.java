package observer;

import spot.ParkingSpot;

public class DisplayBoard implements ParkingObserver {

    @Override
    public void onSpotStatusChanged(ParkingSpot spot){
        System.out.println("[Display] Spot " + spot.getId() + " is now " + spot.getStatus());
    }
}
