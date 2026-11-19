package observer;

import model.Package;

public class ConsoleNotificationObserver implements NotificationObserver{
    @Override
    public void onPackageDeposited(Package pkg) {
        System.out.println("[Notify] " + pkg.getRecipientId() + ": your package is ready, code: " + pkg.getPickupCode());
    }

    @Override
    public void onPackagePickedUp(Package pkg) {
        System.out.println("[Notify] Package " + pkg.getId() + " picked up by " + pkg.getRecipientId());
    }
}
