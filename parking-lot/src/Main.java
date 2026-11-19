import enums.VehicleType;
import lot.ParkingLot;
import model.Ticket;
import model.Vehicle;
import model.VehicleFactory;
import spot.CompactSpot;
import spot.LargeSpot;
import spot.MotorcycleSpot;
import spot.ParkingFloor;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ParkingLot lot = ParkingLot.getInstance();

        ParkingFloor floorOne = new ParkingFloor(1, List.of(
                new MotorcycleSpot("F1-M1"),
                new CompactSpot("F1-C1"),
                new LargeSpot("F1-L1")
        ));

        lot.setFloors(List.of(floorOne));

        Vehicle car = VehicleFactory.createVehicle(VehicleType.CAR, "KA-01-1234");
        Ticket ticket = lot.parkVehicle(car);

        double fee = lot.unparkVehicle(ticket.getTicketId());
        System.out.println("Paid: $" + fee);
    }
}
