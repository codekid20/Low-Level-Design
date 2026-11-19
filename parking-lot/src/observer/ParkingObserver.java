package observer;

import spot.ParkingSpot;

public interface ParkingObserver {
    void onSpotStatusChanged(ParkingSpot spot);
}
