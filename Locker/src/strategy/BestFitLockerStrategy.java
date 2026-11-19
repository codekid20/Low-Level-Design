package strategy;

import enums.LockerSize;
import model.Locker;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BestFitLockerStrategy implements LockerAssignmentStrategy {

    @Override
    public Locker findLocker(List<Locker> lockers, LockerSize packageSize) {
        Optional<Locker> best = lockers.stream().filter(l -> l.canFit(packageSize)).min(Comparator.comparingInt(l -> l.getSize().ordinal()));
        return best.orElse(null);
    }
}
