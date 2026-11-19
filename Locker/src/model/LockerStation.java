package model;

import java.util.List;

public class LockerStation {

    private final List<Locker> lockers;

    public LockerStation(List<Locker> lockers) {
        this.lockers = lockers;
    }

    public List<Locker> getLockers() { return lockers; }
}
