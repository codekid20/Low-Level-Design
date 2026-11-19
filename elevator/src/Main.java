import controller.ElevatorController;
import model.Direction;
import model.Elevator;
import model.Request;
import model.RequestType;
import observer.ElevatorDisplay;

public class Main {

    public static void main(String[] args) {
        ElevatorController controller = ElevatorController.getInstance();
        Elevator e1 = new Elevator(1, 0);
        Elevator e2 = new Elevator(2, 5);

        e1.addObserver(new ElevatorDisplay());
        e2.addObserver(new ElevatorDisplay());

        controller.registerElevator(e1);
        controller.registerElevator(e2);

        controller.submitRequest(new Request(3, Direction.UP, RequestType.HALL_CALL));
        e1.addStop(7);

        for(int tick = 0; tick < 10; tick++){
            controller.step();
        }
    }
}