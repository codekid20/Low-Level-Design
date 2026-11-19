package state;

import model.Direction;
import model.Elevator;

public class MovingUpState implements ElevatorState {

    @Override
    public void handle(Elevator elevator){
        elevator.moveOneFloor(Direction.UP);
        if(elevator.shouldStopAtCurrentFloor()){
            elevator.setState(new DoorOpenState());
        } else if (!elevator.hasStopsAbove()) {
            elevator.setState(elevator.hasPendingStops() ? new MovingDownState() : new IdleState());
        }
    }
}
