package controller;

import model.Elevator;
import model.Request;
import model.RequestType;
import strategy.NearestCarStrategy;
import strategy.SchedulingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ElevatorController {

    private static final ElevatorController INSTANCE = new ElevatorController();
    private final List<Elevator> elevators = new ArrayList<>();
    private final ConcurrentLinkedQueue<Request> pendingRequests = new ConcurrentLinkedQueue<>();
    private SchedulingStrategy strategy = new NearestCarStrategy();

    private ElevatorController(){}

    public static ElevatorController getInstance() { return INSTANCE ; }

    public void registerElevator(Elevator e) {
        elevators.add(e);
    }

    public void setStrategy(SchedulingStrategy strategy){
        this.strategy = strategy;
    }

    public synchronized void submitRequest(Request request){
        if(request.getType() == RequestType.CABIN_CALL){
            pendingRequests.add(request);
            return;
        }

        Elevator chosen = strategy.selectElevator(elevators, request);
        chosen.addStop(request.getFloor());
    }

    public void step(){
        for (Elevator e : elevators) e.step();
    }
}
