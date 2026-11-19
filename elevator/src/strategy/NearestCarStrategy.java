package strategy;

import model.Direction;
import model.Elevator;
import model.Request;
import state.IdleState;
import state.MovingDownState;
import state.MovingUpState;

import java.util.List;

public class NearestCarStrategy implements SchedulingStrategy{

    @Override
    public Elevator selectElevator(List<Elevator> elevators, Request request){

        Elevator best = null;
        int bestDist = Integer.MAX_VALUE;

        for (Elevator e : elevators){
            int dist = e.distanceTo(request.getFloor());
            boolean suitable = e.getState() instanceof IdleState || sameDirection(e, request);
            if(suitable && dist < bestDist){
                bestDist = dist;
                best = e;
            }
        }

        if(best == null){
            for (Elevator e : elevators){
                int dist = e.distanceTo(request.getFloor());
                if(dist < bestDist) {
                    bestDist = dist;
                    best = e;
                }
            }
        }

        return best;
    }

    private boolean sameDirection(Elevator e, Request r){
        if(e.getState() instanceof MovingUpState) return r.getDirection() == Direction.UP;
        if(e.getState() instanceof MovingDownState) return r.getDirection() == Direction.DOWN;
        return false;
    }
}
