package state;

import model.Direction;
import model.Elevator;

public class IdleState implements ElevatorState {
    @Override
    public void handle(Elevator elevator){
        if(!elevator.hasPendingStops()) return; // stay idle
        Direction dir = elevator.nextDirection();
        elevator.setState(dir == Direction.UP ? new MovingUpState() : new MovingDownState());
    }
}
