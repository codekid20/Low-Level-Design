package model;

import enums.LockerSize;
import enums.PackageStatus;

import java.time.LocalDateTime;

public class Package {
    private final String id;
    private final String recipientId;
    private final LockerSize size;
    private final String pickupCode;
    private PackageStatus status;
    private final LocalDateTime depositedAt;

    public Package(String id, String recipientId, LockerSize size, String pickupCode) {
        this.id = id;
        this.recipientId = recipientId;
        this.size = size;
        this.pickupCode = pickupCode;
        this.status = PackageStatus.AWAITING_PICKUP;
        this.depositedAt = LocalDateTime.now();
    }

    public void markPickedUp() { this.status = PackageStatus.PICKED_UP; }
    public String getId() { return id; }
    public String getRecipientId() { return recipientId; }
    public LockerSize getSize() { return size; }
    public String getPickupCode() { return pickupCode; }
    public PackageStatus getStatus() { return status; }
    public LocalDateTime getDepositedAt() { return depositedAt; }
}
