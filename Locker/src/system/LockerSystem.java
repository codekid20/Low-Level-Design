package system;

import enums.LockerSize;
import enums.PackageStatus;
import model.Locker;
import model.LockerStation;
import model.Package;
import observer.NotificationObserver;
import strategy.BestFitLockerStrategy;
import strategy.CodeGenerationStrategy;
import strategy.LockerAssignmentStrategy;
import strategy.RandomNumericCodeStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class LockerSystem {

    private static final LockerSystem INSTANCE = new LockerSystem();
    private LockerStation station;
    private LockerAssignmentStrategy assignmentStrategy = new BestFitLockerStrategy();
    private CodeGenerationStrategy codeStrategy = new RandomNumericCodeStrategy();
    private final List<NotificationObserver> observers = new ArrayList<>();
    private final Map<String, Package> activeByCode = new ConcurrentHashMap<>();
    private final Map<String, Locker> lockerByPackageId = new ConcurrentHashMap<>();

    private LockerSystem() {}

    public static LockerSystem getInstance() { return INSTANCE; }
    public void setStation(LockerStation station) { this.station = station; }
    public void addObserver(NotificationObserver o) { observers.add(o); }

    public synchronized Package depositPackage(String recipientId, LockerSize size) {
        Locker locker = assignmentStrategy.findLocker(station.getLockers(), size);
        if(locker == null) {
            throw new IllegalStateException("No available locker for size " + size);
        }

        String code;
        do {
            code = codeStrategy.generateCode();
        } while (activeByCode.containsKey(code));

        Package pkg = new Package(UUID.randomUUID().toString(), recipientId, size, code);
        locker.assign(pkg);
        activeByCode.put(code, pkg);
        lockerByPackageId.put(pkg.getId(), locker);

        observers.forEach(o-> o.onPackageDeposited(pkg));
        return pkg;
    }

    public synchronized boolean pickupPackage(String code) {
        Package pkg = activeByCode.get(code);
        if(pkg == null || pkg.getStatus() == PackageStatus.PICKED_UP) {
            return false;
        }

        Locker locker = lockerByPackageId.remove(pkg.getId());
        locker.release();
        pkg.markPickedUp();
        activeByCode.remove(code);

        observers.forEach(o -> o.onPackagePickedUp(pkg));
        return true;
    }
}
