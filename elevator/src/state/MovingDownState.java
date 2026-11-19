package state;

import model.Direction;
import model.Elevator;

public class MovingDownState implements ElevatorState{

    @Override
    public void handle(Elevator elevator){
        elevator.moveOneFloor(Direction.DOWN);
        if (elevator.shouldStopAtCurrentFloor()){
            elevator.setState(new DoorOpenState());
        } else if (!elevator.hasStopsBelow()) {
            elevator.setState(elevator.hasPendingStops() ? new MovingUpState() : new IdleState());
        }
    }
}
