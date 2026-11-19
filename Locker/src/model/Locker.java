package model;

import enums.LockerSize;
import enums.LockerStatus;

public class Locker {
    private final String id;
    private final LockerSize size;
    private LockerStatus status = LockerStatus.FREE;
    private Package currentPackage;

    public Locker(String id, LockerSize size) {
        this.id = id;
        this.size = size;
    }

    public boolean canFit(LockerSize packageSize) {
        return status == LockerStatus.FREE && size.ordinal() >= packageSize.ordinal(); // ??
    }

    public void assign(Package pkg) {
        this.currentPackage = pkg;
        this.status = LockerStatus.OCCUPIED;
    }

    public void release() {
        this.currentPackage = null;
        this.status = LockerStatus.FREE;
    }

    public String getId() { return id; }
    public LockerSize getSize() { return size; }
    public LockerStatus getStatus() { return status; }
    public Package getCurrentPackage() { return currentPackage; }
}
