package observer;

import model.Elevator;

public interface ElevatorObserver {

    void onElevatorUpdate(Elevator elevator);
}
