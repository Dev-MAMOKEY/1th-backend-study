import controller.RemoteController;
import model.AirConditioner;
import model.RemoteControl;
import model.Television;
import view.ProductSelect;
import view.manipulation.CurrentStatus;

public class Runner {
    public static void run() {
        ProductSelect productSelect = new ProductSelect();
        RemoteControl[] devices = {new Television(), new AirConditioner()};
        CurrentStatus currentStatus = new CurrentStatus();
        RemoteController remoteController = new RemoteController(productSelect,devices,currentStatus);
        remoteController.run();
    }
}
