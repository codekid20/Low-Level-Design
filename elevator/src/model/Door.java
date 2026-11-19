package model;

public class Door {

    private DoorState state = DoorState.CLOSED;

    public void open(){
        state = DoorState.OPEN;
        System.out.println("Door Opened");
    }

    public void close(){
        state = DoorState.CLOSED;
        System.out.println("Door Closed");
    }

    public DoorState getState() { return state; }
}
