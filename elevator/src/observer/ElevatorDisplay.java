package observer;

import model.Elevator;

public class ElevatorDisplay implements ElevatorObserver {

    @Override
    public void onElevatorUpdate(Elevator elevator){
        System.out.println("[Display] Elevator " + elevator.getId()
                + " -> floor " + elevator.getCurrentFloor()
                + " state=" + elevator.getState().getClass().getSimpleName());
    }
}
