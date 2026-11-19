import enums.LockerSize;
import model.Locker;
import model.LockerStation;
import model.Package;
import observer.ConsoleNotificationObserver;
import system.LockerSystem;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LockerSystem system = LockerSystem.getInstance();
        system.setStation(new LockerStation(List.of(
                new Locker("L1", LockerSize.SMALL),
                new Locker("L2", LockerSize.MEDIUM),
                new Locker("L3", LockerSize.LARGE)
        )));

        system.addObserver(new ConsoleNotificationObserver());

        Package pkg = system.depositPackage("customer-42", LockerSize.SMALL);
        System.out.println("Deposited. Code: " + pkg.getPickupCode());

        boolean success = system.pickupPackage(pkg.getPickupCode());
        System.out.println("Pickup success: " + success);

        boolean secondTry = system.pickupPackage(pkg.getPickupCode());
        System.out.println("Second pickup attempt: " + secondTry); // false
    }
}