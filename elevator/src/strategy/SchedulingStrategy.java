package strategy;

import model.Elevator;
import model.Request;

import java.util.List;

public interface SchedulingStrategy {
    Elevator selectElevator(List<Elevator> elevators, Request request);
}
