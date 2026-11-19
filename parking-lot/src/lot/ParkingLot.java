package lot;

import Strategy.HourlyPricingStrategy;
import Strategy.NearestSpotStrategy;
import Strategy.PricingStrategy;
import Strategy.SpotAssignmentStrategy;
import model.Ticket;
import model.Vehicle;
import spot.ParkingFloor;
import spot.ParkingSpot;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {

    private static final ParkingLot INSTANCE = new ParkingLot();
    private List<ParkingFloor> floors;
    private SpotAssignmentStrategy assignmentStrategy = new NearestSpotStrategy();
    private PricingStrategy pricingStrategy = new HourlyPricingStrategy();
    private final Map<String, Ticket> activeTickets = new ConcurrentHashMap<>();

    private ParkingLot() {}

    public static ParkingLot getInstance() { return INSTANCE; }
    public void setFloors(List<ParkingFloor> floors) { this.floors = floors; }
    public void setAssignmentStrategy(SpotAssignmentStrategy s) { this.assignmentStrategy = s; }
    public void setPricingStrategy(PricingStrategy s) { this.pricingStrategy = s; }

    public synchronized Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = assignmentStrategy.findSpot(floors, vehicle);
        if(spot == null){
            throw new IllegalStateException("No available spot for " + vehicle.getType());
        }

        spot.assignVehicle(vehicle);
        Ticket ticket = new Ticket(vehicle, spot);
        activeTickets.put(ticket.getTicketId(), ticket);
        System.out.println("Parked " + vehicle.getLicensePlate() + " at spot " + spot.getId());
        return ticket;
    }

    public synchronized double unparkVehicle(String ticketId) {

        Ticket ticket = activeTickets.remove(ticketId);
        if(ticket == null){
            throw new IllegalArgumentException("Invalid ticket");
        }
        ticket.markExit();
        double fee = pricingStrategy.calculateFee(ticket);
        ticket.getSpot().removeVehicle();
        System.out.println("Vehicle " + ticket.getVehicle().getLicensePlate() + " exited. Fee: $" + fee);
        return fee;
    }
}
