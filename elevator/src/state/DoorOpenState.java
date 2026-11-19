package state;

import model.Elevator;

public class DoorOpenState implements ElevatorState{

    @Override
    public void handle(Elevator elevator){
        elevator.getDoor().open();
        elevator.clearStopAtCurrentFloor();
        elevator.getDoor().close();
        elevator.setState(new IdleState());
    }
}
