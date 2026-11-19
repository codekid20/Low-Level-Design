package observer;
import model.Package;
public interface NotificationObserver {
    void onPackageDeposited(Package pkg);
    void onPackagePickedUp(Package pkg);
}
