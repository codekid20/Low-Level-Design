package model;

import observer.ElevatorObserver;
import state.ElevatorState;
import state.IdleState;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Elevator {

    private final int id;
    private int currentFloor;
    private ElevatorState state;
    private final Door door;
    private final TreeSet<Integer> upStops = new TreeSet<>();
    private final TreeSet<Integer> downStops = new TreeSet<>();
    private final List<ElevatorObserver> observers = new ArrayList<>();

    public Elevator(int id, int startFloor){

        this.id = id;
        this.currentFloor = startFloor;
        this.door = new Door();
        this.state = new IdleState();
    }

    public void addStop(int floor){
        if(floor > currentFloor) upStops.add(floor);
        else if (floor < currentFloor) {
            downStops.add(floor);
        }
        notifyObservers();
    }

    public void step(){
        state.handle(this);
        notifyObservers();
    }

    public void moveOneFloor(Direction dir){
        currentFloor += (dir == Direction.UP) ? 1 : -1;
        System.out.println("Elevator " + id + "now at floor " + currentFloor);
    }

    public boolean shouldStopAtCurrentFloor(){
        return upStops.contains(currentFloor) || downStops.contains(currentFloor);
    }

    public void clearStopAtCurrentFloor(){
        upStops.remove(currentFloor);
        downStops.remove(currentFloor);
    }

    public boolean hasStopsAbove() {
        return !upStops.isEmpty() && upStops.last() > currentFloor;
    }

    public boolean hasStopsBelow(){
        return !downStops.isEmpty() && downStops.first() < currentFloor;
    }

    public boolean hasPendingStops(){
        return !upStops.isEmpty() || !downStops.isEmpty();
    }

    public Direction nextDirection(){
        if(!upStops.isEmpty()) return Direction.UP;
        if(!downStops.isEmpty()) return Direction.DOWN;
        return Direction.IDLE;
    }

    public int distanceTo(int floor){
        return Math.abs(currentFloor - floor);
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }

    public ElevatorState getState() { return state; }
    public Door getDoor() { return door; }
    public int getId() { return id; }
    public int getCurrentFloor() { return currentFloor; }

    public void addObserver(ElevatorObserver o ) { observers.add(o); }
    private void notifyObservers() { observers.forEach(o -> o.onElevatorUpdate(this)); }

}
