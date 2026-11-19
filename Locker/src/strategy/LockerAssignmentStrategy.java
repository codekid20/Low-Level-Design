package strategy;

import enums.LockerSize;
import model.Locker;

import java.util.List;

public interface LockerAssignmentStrategy {
    Locker findLocker(List<Locker> lockers, LockerSize packageSize);
}
